package ru.netology;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    public Employee(String id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    // Геттеры (если нужны)
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
}
