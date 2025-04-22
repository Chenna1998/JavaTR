package com.service;

import com.Exception.ResourceNotFoundException;
import com.model.Employee;
import com.repository.EmployeeRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    public List<Employee> fetchAllEmployee() throws SQLException {
        return  employeeRepository.fetchAllEmployee();
    }

    public Employee validateId(int id) throws SQLException, ResourceNotFoundException {
        return employeeRepository.validateId(id);
    }

    public void deleteEmployee(int id) throws SQLException {
        employeeRepository.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeRepository.updateEmployee(employee);
    }

    public List<Employee> filterEmployeeByCity(List<Employee> list, String city) {
        return list.stream()
                .filter(e->e.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Employee> filterEmployeeBySalary(List<Employee> list, double salary) {
        return list.stream()
                .filter(e->e.getSalary()>=salary)
                .collect(Collectors.toList());
    }

    public List<Employee> filterEmployeeByDepartment(List<Employee> list, String department) {
        return list.stream()
                .filter(e->e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Employee> filterEmployeeByDOJ(List<Employee> list, String DOJ) {
        return list.stream()
                .filter(e->e.getDateOfJoining().compareTo(LocalDate.parse(DOJ)) < 1)
                .collect(Collectors.toList());
    }

    public List<Employee> sortBySalary(List<Employee> list, String direction) {
        List<Employee> sortedList = list.stream()
                .sorted(Comparator.comparing(e->e.getSalary()))
                .collect(Collectors.toList());
        if(direction.equalsIgnoreCase("ASC"))
            return sortedList;
        else{
            Collections.reverse(sortedList);
            return sortedList;
        }
    }

    public Map<String, Integer> statsByCity(List<Employee> list) {
        Map<String, Integer> map = new HashMap<>();
        List<String> listOfCities = list.stream().map(e->e.getCity()).distinct().collect(Collectors.toList());

//        for(String city : listOfCities){
//           int count = (int) list.stream().filter(e->e.getCity().equalsIgnoreCase(city)).count();
//           map.put(city,count);
//        }
        //using foreach
        listOfCities.stream().forEach(city->{
            int count = (int) list.stream().filter(e->e.getCity().equalsIgnoreCase(city)).count();
            map.put(city,count);
        });
        return map;

    }
}
