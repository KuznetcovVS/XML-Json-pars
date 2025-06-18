package ru.netology;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String country;
    private int age;

public Employee() {
    // Пустой конструктор
}

    public Employee(String id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

}
