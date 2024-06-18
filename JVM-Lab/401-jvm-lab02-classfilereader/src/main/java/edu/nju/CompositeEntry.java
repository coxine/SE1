package edu.nju;

import java.io.IOException;

/**
 * format : dir/subdir;dir/subdir/*;dir/target.jar*
 */
public class CompositeEntry extends Entry {
    public CompositeEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        String[] paths = classPath.split(PATH_SEPARATOR);
        for (String path : paths) {
            Entry entry = null;
            if (path.contains("*")) {
                entry = new WildEntry(path);
            } else if (path.contains(".jar") || path.contains(".zip") || path.contains(".JAR")
                    || path.contains(".ZIP")) {
                entry = new ArchivedEntry(path);
            } else {
                entry = new DirEntry(path);
            }
            byte[] ret = entry.readClassFile(className);
            if (ret != null) {
                return ret;
            }
        }
        return null;
    }
}
