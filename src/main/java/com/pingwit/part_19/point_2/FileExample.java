package com.pingwit.part_19.point_2;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/pingwit/part_19/point_2/my_file.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        file.createNewFile();
        file.delete();
        file.delete();

        System.out.println("file.exists()=" + file.exists());
    }
}
