package edu.nju;

import java.io.File;
import java.io.IOException;

public abstract class Entry {
    public final String PATH_SEPARATOR = File.pathSeparator;
    public final String FILE_SEPARATOR = File.separator;
    public String classPath;

    public Entry(String classPath) {
        this.classPath = classPath;
    }

    public java.nio.file.Path StringToPath() {
        return java.nio.file.Paths.get(this.classPath);
    }

    public abstract byte[] readClassFile(String className) throws IOException;
}
