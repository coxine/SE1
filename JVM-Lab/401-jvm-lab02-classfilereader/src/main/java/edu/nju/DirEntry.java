package edu.nju;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * format : dir/subdir/.../
 */
public class DirEntry extends Entry {
    public DirEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        File classFile = new File(buildFilePath(className));
        if (classFile.exists()) {
            try {
                FileInputStream classStream = new FileInputStream(classFile);
                return IOUtil.readFileByBytes(classStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String buildFilePath(String className) {
        return IOUtil.transform(classPath) + FILE_SEPARATOR + className;
    }
}
