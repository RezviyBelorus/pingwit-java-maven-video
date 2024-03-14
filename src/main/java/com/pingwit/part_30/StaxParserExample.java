package com.pingwit.part_30;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxParserExample {
    public static void main(String[] args) throws XMLStreamException {
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");

        List<Employee> employees = parseXML(resource);

        employees.forEach(System.out::println);
    }

    private static List<Employee> parseXML(InputStream file) throws XMLStreamException {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(file);
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equals("employee")) {
                    employee = new Employee();
                    Attribute id = startElement.getAttributeByName(new QName("id"));
                    if (id != null) {
                        employee.setId(Long.valueOf(id.getValue()));
                    }
                } else {
                    String localPart = startElement.getName().getLocalPart();
                    switch (localPart) {
                        case "firstName" -> {
                            xmlEvent = xmlEventReader.nextEvent();
                            employee.setFirstName(xmlEvent.asCharacters().getData());
                        }
                        case "lastName" -> {
                            xmlEvent = xmlEventReader.nextEvent();
                            employee.setLastName(xmlEvent.asCharacters().getData());
                        }
                        case "location" -> {
                            xmlEvent = xmlEventReader.nextEvent();
                            employee.setLocation(xmlEvent.asCharacters().getData());
                        }
                    }
                }
            }

            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("employee")) {
                    employees.add(employee);
                }
            }
        }

        return employees;
    }
}
