package com.pingwit.part_29.read;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JacksonJsonArrayReaderExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream jsonFileStream = ClassLoader.getSystemResourceAsStream("part_29/read/json_array_simple.json");
        List<String> videos = mapper.readValue(jsonFileStream, new TypeReference<>() {
        });

        System.out.println(videos);

        System.out.println("===");

        InputStream jsonTaxiDrivers = ClassLoader.getSystemResourceAsStream("part_29/read/json_array_complex.json");
        List<TaxiDriver> taxiDrivers = mapper.readValue(jsonTaxiDrivers, new TypeReference<>() {
        });
        System.out.println(taxiDrivers);
    }
}
