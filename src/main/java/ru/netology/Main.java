package ru.netology;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        XmlJsonParser parser = new XmlJsonParser();

        // Парсим XML
        List<Employee> employees = parser.parseXML("src/main/resources/data.xml");

        // Преобразуем в JSON
        String jsonString = parser.listToJson(employees);

        // Записываем в файл
        parser.writeString(jsonString, "data2.json");

    }
}
