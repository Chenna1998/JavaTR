package com.controller;

import com.model.Employee;
import com.service.EmployeeService;

import java.util.ArrayList;

public class EmpoloyeeController {
    public static void main(String[] args) {
        //Reach out to Emp Service
        EmployeeService employeeService = new EmployeeService();
        ArrayList<Employee> earray = employeeService.fetchEmployee();

        //output
        for(Employee e : earray){
            System.out.println(e.getName()+ " is living in " + e.getCity() + " working in " + e.getDepartment() + " with id " + e.getId());
        }
    }
}
