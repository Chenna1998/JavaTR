package com.repository;

import com.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {


    public ArrayList<Employee> fetchEmployee() {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        //Attach instance variables(properties) values to objects
        employee1.setId(1);
        employee1.setCity("SLC");
        employee1.setDepartment("CS");
        employee1.setName("Hary");

        employee2.setId(2);
        employee2.setName("Raki");
        employee2.setCity("DFW");
        employee2.setDepartment("ITM");

        employee3.setId(3);
        employee3.setCity("PHX");
        employee3.setName("Bal");
        employee3.setDepartment("EE");

        //put these objects in list
        ArrayList<Employee> list = new ArrayList();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        return list;

    }
}
