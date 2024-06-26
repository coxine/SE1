package com.njuse.seecjvm.classloader.classfileparser.constantpool.info;

import com.njuse.seecjvm.classloader.classfileparser.constantpool.ConstantPool;

public class ClassInfo extends ConstantPoolInfo {

    private int nameIndex;

    public ClassInfo(ConstantPool constantPool, int nameIndex) {

        super(constantPool);
        this.nameIndex = nameIndex;
        super.tag = ConstantPoolInfo.CLASS;
    }

    public String getClassName() {
        return ((UTF8Info) myCP.get(nameIndex)).getString();
    }

    @Override
    public String toString() {
        return getClassName();
    }
}
