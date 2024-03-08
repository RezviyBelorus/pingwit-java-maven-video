package com.pingwit.part_19.point_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/com/pingwit/part_19/point_3/FilesExample.java");
        Path target = Path.of("src/com/pingwit/part_19/point_3/FilesExampleCopy.txt");

        System.out.println(path.getFileSystem());
        System.out.println(path.getFileName());

        String text = Files.readString(path);
        System.out.println(text);

//        Path copy = Files.copy(path, target);
        Path helloWorld = Files.writeString(target, "Hello World V2");
        // baeldung.com   stackoverflow.com
    }
}
