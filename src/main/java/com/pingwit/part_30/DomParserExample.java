package com.pingwit.part_30;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DomParserExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");
        Document document = documentBuilder.parse(resource);

        List<Employee> employees = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Employee employee = new Employee();

                String id = node.getAttributes().getNamedItem("id").getNodeValue();
                employee.setId(Long.valueOf(id));

                NodeList childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();

                        switch (cNode.getNodeName()) {
                            case "firstName" -> employee.setFirstName(content);
                            case "lastName" -> employee.setLastName(content);
                            case "location" -> employee.setLocation(content);
                        }
                    }
                }
                employees.add(employee);
            }
        }

        employees.forEach(System.out::println);
    }
}
