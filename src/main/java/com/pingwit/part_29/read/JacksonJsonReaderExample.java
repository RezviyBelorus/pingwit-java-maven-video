package com.pingwit.part_29.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;

public class JacksonJsonReaderExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        InputStream jsonFileStream = ClassLoader.getSystemResourceAsStream("part_29/read/userRegitry.json");

        User user = mapper.readValue(jsonFileStream, User.class);
        System.out.println(user);
    }
}
