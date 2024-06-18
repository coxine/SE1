package edu.nju;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * format : dir/subdir/target.jar
 */
public class ArchivedEntry extends Entry {
    public ArchivedEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        File archive = new File(this.classPath);
        if (!archive.exists()) {
            return null;
        }

        String zipPath = classPath;
        ZipFile zipFile = new ZipFile(zipPath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            System.out.println(entry.getName());
            if (entry.getName().equals(className.replace(FILE_SEPARATOR, "/"))) {
                return IOUtil.readFileByBytes(zipFile.getInputStream(entry));
            }
        }
        zipFile.close();
        return null;
    }
}
