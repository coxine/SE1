package com.njuse.seecjvm.classloader;

import com.njuse.seecjvm.classloader.classfileparser.ClassFile;
import com.njuse.seecjvm.classloader.classfilereader.ClassFileReader;
import com.njuse.seecjvm.classloader.classfilereader.classpath.EntryType;
import com.njuse.seecjvm.memory.MethodArea;
import com.njuse.seecjvm.memory.jclass.Field;
import com.njuse.seecjvm.memory.jclass.InitState;
import com.njuse.seecjvm.memory.jclass.JClass;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.DoubleWrapper;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.FloatWrapper;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.IntWrapper;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.LongWrapper;
import com.njuse.seecjvm.runtime.Vars;
import com.njuse.seecjvm.runtime.struct.NullObject;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;

public class ClassLoader {
    private static ClassLoader classLoader = new ClassLoader();
    private ClassFileReader classFileReader;
    private MethodArea methodArea;

    private ClassLoader() {
        classFileReader = ClassFileReader.getInstance();
        methodArea = MethodArea.getInstance();
    }

    public static ClassLoader getInstance() {
        return classLoader;
    }

    /**
     * load phase
     *
     * @param className       name of class
     * @param initiatingEntry null value represents load MainClass
     */
    public JClass loadClass(String className, EntryType initiatingEntry) throws ClassNotFoundException {
        JClass ret;
        if ((ret = methodArea.findClass(className)) == null) {
            return loadNonArrayClass(className, initiatingEntry);
        }
        return ret;
    }

    private JClass loadNonArrayClass(String className, EntryType initiatingEntry) throws ClassNotFoundException {
        try {
            Pair<byte[], Integer> res = classFileReader.readClassFile(className, initiatingEntry);
            byte[] data = res.getKey();
            EntryType definingEntry = new EntryType(res.getValue());
            // define class
            JClass clazz = defineClass(data, definingEntry);
            // link class
            linkClass(clazz);
            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    /**
     *
     * define class
     * 
     * @param data          binary of class file
     * @param definingEntry defining loader of class
     */
    private JClass defineClass(byte[] data, EntryType definingEntry) throws ClassNotFoundException {
        ClassFile classFile = new ClassFile(data);
        JClass clazz = new JClass(classFile);

        clazz.setLoadEntryType(definingEntry);
        resolveSuperClass(clazz);
        resolveInterfaces(clazz);
        methodArea.addClass(clazz.getName(), clazz);
        return clazz;
    }

    /**
     * load superclass before add to method area
     */
    private void resolveSuperClass(JClass clazz) throws ClassNotFoundException {
        if (clazz.getSuperClassName() != "") {
            clazz.setSuperClass(loadClass(clazz.getSuperClassName(), clazz.getLoadEntryType()));
            resolveSuperClass(clazz.getSuperClass());
        }
    }

    /**
     * load interfaces before add to method area
     */
    private void resolveInterfaces(JClass clazz) throws ClassNotFoundException {
        int InterfaceCount = clazz.getInterfaceNames().length;
        clazz.setInterfaces(new JClass[InterfaceCount]);
        for (int i = 0; i < InterfaceCount; i++) {
            clazz.getInterfaces()[i] = loadClass(clazz.getInterfaceNames()[i], clazz.getLoadEntryType());
        }
    }

    /**
     * link phase
     */
    private void linkClass(JClass clazz) {
        verify(clazz);
        prepare(clazz);
    }

    /**
     * You don't need to write any code here.
     */
    private void verify(JClass clazz) {
        // do nothing
    }

    private void prepare(JClass clazz) {
        /**
         *
         * step1 (We do it for you here)
         * count the fields slot id in instance
         * count the fields slot id in class
         * step2
         * alloc memory for fields(We do it for you here) and init static vars
         * step3
         * set the init state
         */
        calInstanceFieldSlotIDs(clazz);
        calStaticFieldSlotIDs(clazz);
        allocAndInitStaticVars(clazz);
        clazz.setInitState(InitState.PREPARED);
    }

    /**
     * count the number of field slots in instance
     * long and double takes two slots
     * the field is not static
     */
    private void calInstanceFieldSlotIDs(JClass clazz) {
        int slotID = 0;
        if (clazz.getSuperClass() != null) {
            slotID = clazz.getSuperClass().getInstanceSlotCount();
        }
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            if (!f.isStatic()) {
                f.setSlotID(slotID);
                slotID++;
                if (f.isLongOrDouble())
                    slotID++;
            }
        }
        clazz.setInstanceSlotCount(slotID);
    }

    /**
     * count the number of field slots in class
     * long and double takes two slots
     * the field is static
     */
    private void calStaticFieldSlotIDs(JClass clazz) {
        int slotID = 0;
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            if (f.isStatic()) {
                f.setSlotID(slotID);
                slotID++;
                if (f.isLongOrDouble())
                    slotID++;
            }
        }
        clazz.setStaticSlotCount(slotID);

    }

    /**
     * primitive type is set to 0
     * ref type is set to null
     */
    private void initDefaultValue(JClass clazz, Field field) {
        /**
         * step 1
         * get static vars of class
         * step 2
         * get the slotID index of field
         * step 3
         * switch by descriptor or some part of descriptor
         * Handle basic type ZBCSIJDF and references (with new NullObject())
         */
        Vars staticVars = clazz.getStaticVars();
        int slotID = field.getSlotID();
        String descriptor = field.getDescriptor();
        switch (descriptor.charAt(0)) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                staticVars.setInt(slotID, 0);
                break;
            case 'J':
                staticVars.setLong(slotID, 0);
                break;
            case 'F':
                staticVars.setFloat(slotID, 0);
                break;
            case 'D':
                staticVars.setDouble(slotID, 0);
                break;
            default:
                staticVars.setObjectRef(slotID, new NullObject());
        }
    }

    /**
     * load const value from runtimeConstantPool for primitive type
     * String is not support now
     */
    private void loadValueFromRTCP(JClass clazz, Field field) {
        /**
         *
         * step 1
         * get static vars and runtime constant pool of class
         * step 2
         * get the slotID and constantValue index of field
         * step 3
         * switch by descriptor or some part of descriptor
         * just handle basic type ZBCSIJDF, you don't have to throw any exception
         * use wrapper to get value
         *
         * Example
         * long longVal = ((LongWrapper)
         * runtimeConstantPool.getConstant(constantPoolIndex)).getValue();
         */

        Vars staticVars = clazz.getStaticVars();
        RuntimeConstantPool runtimeConstantPool = clazz.getRuntimeConstantPool();
        int slotID = field.getSlotID();
        int constantValue = field.getConstValueIndex();
        String descriptor = field.getDescriptor();
        switch (descriptor.charAt(0)) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                int intVal = ((IntWrapper) runtimeConstantPool.getConstant(constantValue)).getValue();
                staticVars.setInt(slotID, intVal);
                break;
            case 'J':
                long longVal = ((LongWrapper) runtimeConstantPool.getConstant(constantValue)).getValue();
                staticVars.setLong(slotID, longVal);
                break;
            case 'F':
                float floatVal = ((FloatWrapper) runtimeConstantPool.getConstant(constantValue)).getValue();
                staticVars.setFloat(slotID, floatVal);
                break;
            case 'D':
                double doubleVal = ((DoubleWrapper) runtimeConstantPool.getConstant(constantValue)).getValue();
                staticVars.setDouble(slotID, doubleVal);
                break;
        }
    }

    /**
     * the value of static final field is in com.njuse.seecjvm.runtime constant pool
     * others will be set to default value
     */
    private void allocAndInitStaticVars(JClass clazz) {
        clazz.setStaticVars(new Vars(clazz.getStaticSlotCount()));
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            /**
             *
             * Refer to manual for details.
             */
            if (f.isFinal()) {
                loadValueFromRTCP(clazz, f);
            } else {
                initDefaultValue(clazz, f);
            }
        }
    }
}
