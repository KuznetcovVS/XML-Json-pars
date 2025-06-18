package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlJsonParser {

    public List<Employee> parseXML(String filename) {
        List<Employee> employees = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filename));
            Element root = doc.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("employee")) {
                    Element employeeElement = (Element) node;

                    String id = getTagValue("id", employeeElement);
                    String firstName = getTagValue("firstName", employeeElement);
                    String lastName = getTagValue("lastName", employeeElement);
                    String country = getTagValue("country", employeeElement);
                    int age = Integer.parseInt(getTagValue("age", employeeElement));

                    Employee emp = new Employee(id, firstName, lastName, country, age);
                    employees.add(emp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Вспомогательный метод для получения значения тега
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public String listToJson(List<Employee> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }

    public void writeString(String json, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
