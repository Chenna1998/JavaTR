package com.controller;

import com.model.Employee;

import java.util.*;

public class LisOfObjectsDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList();
        Employee employee1 = new Employee(1,"rev","CS","HYD",34000);
        Employee employee2 = new Employee(2,"che","EE","DFW",13000);
        Employee employee3 = new Employee(3,"ghsd","ITM","PHX",90000);
        list = Arrays.asList(employee1,employee2,employee3);

        //iteration
        System.out.println("****** Before Sort ******");
        for(Employee e: list){
            System.out.println(e);
        }

        //sorting using Comparable interface
        Collections.sort(list); // e1.compareTo(e2)

        System.out.println("****** Asc Sort By Salary ******");
        for(Employee e : list){
            System.out.println(e);
        }

        //sorting using Comparator interface
        System.out.println("****** Asc Sort By Salary ******");
        Collections.sort(list,new A());
        for(Employee e : list){
            System.out.println(e);
        }
        System.out.println("****** Desc Sort By Salary ******");
        Collections.sort(list,new B());
        for(Employee e : list){
            System.out.println(e);
        }
        System.out.println("****** Asc Sort By City ******");
        Collections.sort(list,new C());
        for(Employee e : list){
            System.out.println(e);
        }
    }

}
class A implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return (int) (e1.getSalary() - e2.getSalary());
    }
}
class B implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return (int) (e2.getSalary() - e1.getSalary());
    }
}
class C implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
       return e1.getCity().compareTo(e2.getCity());
    }
}