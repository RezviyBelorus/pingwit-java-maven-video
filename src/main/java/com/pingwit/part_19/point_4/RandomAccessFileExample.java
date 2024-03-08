package com.pingwit.part_19.point_4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        File file = new File("src/com/pingwit/part_19/point_4/principles_oop.txt");

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            System.out.println(raf.getFilePointer());
            String rawLine = raf.readLine();
            String utf8 = new String(rawLine.getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("rawLine=" + rawLine.length());
            System.out.println("utf8=" + utf8.length());

            System.out.println(utf8);
            System.out.println(raf.getFilePointer());
            System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"), "UTF-8"));

            raf.seek(0);
            System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"), "UTF-8"));
//            System.out.println(raf.readLine());
            System.out.println(file.length());

            long filePointer = raf.getFilePointer();
            String newData = "New data";
            raf.writeBytes(newData);
            raf.writeChars("New data");

            raf.seek(filePointer + newData.length() * 2);
            System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"), "UTF-8"));
//            System.out.println(raf.readLine());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
