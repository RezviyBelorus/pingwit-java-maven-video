package com.pingwit.part_30;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SaxParserExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

        SAXHandler handler = new SAXHandler();
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");
        parser.parse(resource, handler);

        List<Employee> empList = handler.getEmployees();

        empList.forEach(System.out::println);
    }
}

class SAXHandler extends DefaultHandler {
    private List<Employee> employees = new ArrayList<>();
    private Employee employee = null;
    private String content = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            //Create a new EmployeeXml object when the start tag is found
            case "employee" -> {
                employee = new Employee();
                String id = attributes.getValue("id");
                employee.setId(Long.valueOf(id));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            //Add the employee to list once end tag is found
            case "employee" -> employees.add(employee);
            //For all other end tags the employee has to be updated.
            case "firstName" -> employee.setFirstName(content);
            case "lastName" -> employee.setLastName(content);
            case "location" -> employee.setLocation(content);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
        System.out.println(content);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
