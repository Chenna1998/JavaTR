package com.service;

import com.model.Employee;
import com.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    public List<Employee> fetchAllEmployee() throws SQLException {
        return  employeeRepository.fetchAllEmployee();
    }
}
