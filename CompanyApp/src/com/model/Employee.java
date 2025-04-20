package com.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String city;
    private String department;
    private double salary;
    private LocalDate dateOfJoining;

    public Employee(int id, String name, String city, String department, double salary, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
