package edu.nju;

import java.io.IOException;
import java.io.File;

/**
 * format : dir/.../*
 */
public class WildEntry extends Entry {
    public WildEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        String replacedPath = classPath.replace("*", "");
        File[] files = new File(replacedPath).listFiles();
        if (files != null) {
            for (File file : files) {
                Entry entry = null;
                if (file.getName().contains(".jar") || file.getName().contains(".zip")
                        || file.getName().contains(".JAR") || file.getName().contains(".ZIP")) {
                    entry = new ArchivedEntry(file.getPath());
                } else {
                    entry = new DirEntry(file.getPath());
                }
                byte[] ret = entry.readClassFile(className);
                if (ret != null) {
                    return ret;
                }
            }
        }
        return null;
    }

    public String buildFilePath(String replacedPath, String className) {
        return IOUtil.transform(replacedPath) + FILE_SEPARATOR + className;
    }
}
