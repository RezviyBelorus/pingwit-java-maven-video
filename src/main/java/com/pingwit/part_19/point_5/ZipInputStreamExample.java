package com.pingwit.part_19.point_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamExample {
    public static void main(String[] args) {
        String path = "src/com/pingwit/part_19/point_5/Theory Annotation.xlsx";

        try (InputStream is = new FileInputStream(path);
             ZipInputStream zip = new ZipInputStream(is)
        ) {
            ZipFile zipFile = new ZipFile(path);

            ZipEntry zipEntry;
            while ((zipEntry = zip.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());

                if (zipEntry.getName().endsWith("sharedStrings.xml")) {
                    try (InputStream entryInputStream = zipFile.getInputStream(zipEntry)) {
                        Files.copy(entryInputStream, Path.of("src/com/pingwit/part_19/point_5/sharedStrings.xml"));
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
