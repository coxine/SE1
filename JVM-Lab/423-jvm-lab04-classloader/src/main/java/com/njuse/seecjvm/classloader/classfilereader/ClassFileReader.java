package com.njuse.seecjvm.classloader.classfilereader;

import com.njuse.seecjvm.classloader.classfilereader.classpath.*;
import com.njuse.seecjvm.util.PathUtil;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;

/**
 * This class is the simulated implementation of Java Classloader.
 */
public class ClassFileReader {
    private static ClassFileReader reader = new ClassFileReader();
    private static final String FILE_SEPARATOR = File.separator;
    private static final String PATH_SEPARATOR = File.pathSeparator;

    private ClassFileReader() {
    }

    public static ClassFileReader getInstance() {
        return reader;
    }

    private static Entry bootClasspath = null;// bootstrap class entry
    private static Entry extClasspath = null;// extension class entry
    private static Entry userClasspath = null;// user class entry

    public static void setBootClasspath(String classpath) {
        bootClasspath = chooseEntryType(classpath);
    }

    public static void setExtClasspath(String classpath) {
        extClasspath = chooseEntryType(classpath);
    }

    public static void setUserClasspath(String classpath) {
        userClasspath = chooseEntryType(classpath);
    }

    /**
     * select Entry by type of classpath
     */
    public static Entry chooseEntryType(String classpath) {
        if (classpath.contains(PATH_SEPARATOR)) {
            return new CompositeEntry(classpath);
        }
        if (classpath.endsWith("*")) {
            return new WildEntry(classpath);
        }
        if (classpath.endsWith(".jar") || classpath.endsWith(".JAR")
                || classpath.endsWith(".zip") || classpath.endsWith(".ZIP")) {
            return new ArchivedEntry(classpath);
        }
        return new DirEntry(classpath);
    }

    /**
     * @param className class to be read
     * @param privilege privilege of relevant class
     * @return content of class file and the privilege of loaded class
     */
    public Pair<byte[], Integer> readClassFile(String className, EntryType privilege)
            throws IOException, ClassNotFoundException {
        String realClassName = className + ".class";
        realClassName = PathUtil.transform(realClassName);
        byte[] content = null;
        int entryPrivilege = privilege == null ? EntryType.USR : privilege.getValue();
        int retPrivilege = 0;
        try {
            if (entryPrivilege >= EntryType.BOOT) {
                content = bootClasspath.readClass(realClassName);
                retPrivilege = EntryType.BOOT;
                if (content == null && entryPrivilege >= EntryType.EXT) {
                    content = extClasspath.readClass(realClassName);
                    retPrivilege = EntryType.EXT;
                    if (content == null && entryPrivilege >= EntryType.USR) {
                        content = userClasspath.readClass(realClassName);
                        retPrivilege = EntryType.USR;
                    }
                }
            }

        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
        if (content == null) {
            throw new ClassNotFoundException();
        }
        return Pair.of(content, retPrivilege);
    }
}
