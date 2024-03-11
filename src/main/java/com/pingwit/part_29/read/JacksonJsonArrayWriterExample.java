package com.pingwit.part_29.read;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JacksonJsonArrayWriterExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream jsonTaxiDrivers = ClassLoader.getSystemResourceAsStream("part_29/read/json_array_complex.json");
        List<TaxiDriver> taxiDrivers = mapper.readValue(jsonTaxiDrivers, new TypeReference<>() {
        });
        System.out.println(taxiDrivers);

        String taxiDriversAsJsonArrayString = mapper.writeValueAsString(taxiDrivers);
        System.out.println(taxiDriversAsJsonArrayString);

        File output = new File("src/main/java/com/pingwit/part_29/read/taxiDrivers.json");
        mapper.writeValue(output, taxiDrivers);

        List<TaxiDriver> taxiDriversFromString = mapper.readValue(taxiDriversAsJsonArrayString, new TypeReference<>() {
        });
        System.out.println(taxiDriversFromString);
    }
}
