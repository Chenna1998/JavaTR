package com.model;

public class Employee implements Comparable<Employee>{
    /*Instance Variables*/
    private int id;
    private String name;
    private String department;
    private String city;
    private double salary;

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String department, String city, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.city = city;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Employee e2) {
        //return (int) (this.salary - e2.salary); // ASC
         return (int) (e2.salary - this.salary); // DESC
//        if(this.salary < e2.salary ) return -1;
//        if(this.salary > e2.salary)  return 1;
//        return 0;
    }
    //Employee - salary is the field to sort
    //ASC - DESC:
    // ----ASC----
    //e1: 10000, e2:12000
    //[e1,e2] : [e1,e2]   e1.salary < e2.salary : no change :- -ve
    //e1: 15000, e2:12000
    //[e1,e2] : [e2,e1]   e1.salary > e2.salary : swap  :- +ve then swapped by JVM
    //e1: 12000, e2:12000
    //[e1,e2] : [e1,e2]   e1.salary == e2.salary : no change  :- 0

}
