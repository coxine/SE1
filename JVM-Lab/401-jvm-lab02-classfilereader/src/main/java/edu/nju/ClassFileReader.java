package edu.nju;

import java.io.File;
import java.io.IOException;

public class ClassFileReader {
    private static final String FILE_SEPARATOR = File.separator;
    private static final String PATH_SEPARATOR = File.pathSeparator;

    private static Entry bootStrapReader;

    public static Entry chooseEntryType(String classPath) {
        /**
         * tips:
         * Every case can correspond to a class
         * These cases are disordered
         * You should take care of the order of if-else
         * case 1 classPath with wildcard
         * case 2 normal dir path
         * case 3 archived file
         * case 4 classPath with path separator
         */

        if (classPath.contains(PATH_SEPARATOR)) {
            // Only CompositeEntry contains PATH_SEPARATOR
            return new CompositeEntry(classPath);
        } else if (classPath.contains("*")) {
            // WildEntry contains *
            return new WildEntry(classPath);
        } else if (classPath.contains(".jar") || classPath.contains(".JAR") || classPath.contains(".zip")
                || classPath.contains(".ZIP")) {
            // ArchivedEntry contains .jar .JAR .zip .ZIP
            return new ArchivedEntry(classPath);
        } else {
            // Other cases are DirEntry
            return new DirEntry(classPath);
        }
    }

    /**
     *
     * @param classPath where to find target class
     * @param className format: /package/.../class
     * @return content of classfile
     */
    public static byte[] readClassFile(String classPath, String className) throws ClassNotFoundException {
        byte[] ret = new byte[0];
        if (classPath == null || className == null) {
            ret = null;
        } else {
            className = IOUtil.transform(className);
            className += ".class";
            bootStrapReader = chooseEntryType(classPath);

            try {
                ret = bootStrapReader.readClassFile(className);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (ret == null)
            throw new ClassNotFoundException();
        return ret;
    }
}
