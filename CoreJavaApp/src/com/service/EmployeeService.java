package com.service;

import com.model.Employee;
import com.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public ArrayList<Employee> fetchEmployee() {
        ArrayList<Employee> earray = employeeRepository.fetchEmployee();
        return earray;
    }
}
