package com.pingwit.part_19.point_5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamInMemoryExample {
    public static void main(String[] args) {
        String path = "src/com/pingwit/part_19/point_5/Theory Annotation.xlsx";

        try (InputStream is = new FileInputStream(path);
             ZipInputStream zip = new ZipInputStream(is)
        ) {
            ZipEntry zipEntry;
            while ((zipEntry = zip.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());

                if (zipEntry.getName().endsWith("sharedStrings.xml")) {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();

                    byte[] buffer = new byte[2048];
                    int length;

                    while ((length = zip.read(buffer)) != -1) {
                        bos.write(buffer, 0, length);
                    }

                    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                    Files.copy(bis, Path.of("src/com/pingwit/part_19/point_5/sharedStrings_memory.xml"));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
