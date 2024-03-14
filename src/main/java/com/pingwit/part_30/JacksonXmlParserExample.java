package com.pingwit.part_30;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JacksonXmlParserExample {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");

        List<Employee> employees = xmlMapper.readValue(resource, new TypeReference<>() {
        });

        employees.forEach(System.out::println);
    }
}
