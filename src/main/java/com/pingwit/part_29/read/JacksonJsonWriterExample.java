package com.pingwit.part_29.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JacksonJsonWriterExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        InputStream jsonFileStream = ClassLoader.getSystemResourceAsStream("part_29/read/userRegitry.json");

        User user = mapper.readValue(jsonFileStream, User.class);
        System.out.println(user);

        File output = new File("src/main/java/com/pingwit/part_29/read/user.json");
        mapper.writeValue(output, user);
    }
}
