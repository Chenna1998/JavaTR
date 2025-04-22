package com.controller;

import com.Exception.ResourceNotFoundException;
import com.model.Employee;
import com.service.EmployeeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

                while (true) {
                    System.out.println("******* Employee Operations *********");
                    System.out.println("1. Insert Employee");
                    System.out.println("2. Fetch all Employees");
                    System.out.println("3. Delete an Employee");
                    System.out.println("4. Update Employee Info");
                    System.out.println("5. Filter Employee Data");
                    System.out.println("6. Sort Employee Data");
                    System.out.println("7. Employee Stats for City");
                    System.out.println("0. Exit");

                    int input = sc.nextInt();

                    if (input == 0) {
                        System.out.println("Exiting Menu.. Thank you!!!");
                        break;
                    }

                    switch (input) {
                        case 1:
                            System.out.println("Insert Employee");
                            System.out.println("Enter Name:");
                            String name = sc.next();
                            System.out.println("Enter Salary");
                            double salary = sc.nextDouble();
                            System.out.println("Enter city:");
                            String city = sc.next();
                            System.out.println("Enter department:");
                            String department = sc.next();
                            System.out.println("Enter Joining Date:");
                            String dateOfJoining = sc.next();

                            Employee employee = new Employee(0,name,city,department,salary, LocalDate.parse(dateOfJoining));
                            //reach out to service
                            try {
                                employeeService.insertEmployee(employee);
                                System.out.println("Employee Insert Successful");
                            } catch (SQLException e) {
                                System.out.println("Insertion failed:"+e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("Fetch all Employees");
                            // reach out to service
                            List<Employee> list;
                            try {
                                list = employeeService.fetchAllEmployee();
                                for(Employee e : list){
                                    System.out.println(e);
                                }
                            } catch (SQLException e) {
                                System.out.println("Employee Fetch Unsuccessful:"+e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.println("Delete an Employee");
                            System.out.println("Enter the id to delete an employee:");
                            int id = sc.nextInt();
                            //reach out to service
                            try {
                                employeeService.validateId(id);
                                //if id is valid delete the employee
                                employeeService.deleteEmployee(id);
                                System.out.println("Employee Deleted");

                            } catch (SQLException | ResourceNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 4:
                            System.out.println("Update Employee Info");
                            System.out.println("Enter the id to Update:");
                            id = sc.nextInt();
                            try {
                                employee = employeeService.validateId(id);
                                System.out.println("Existing Empoloyee Record");
                                System.out.println(employee);
                                System.out.println("Enter new values to update:");
                                System.out.println("Enter Name:");
                                name = sc.next();
                                System.out.println("Enter Salary");
                                salary = sc.nextDouble();
                                System.out.println("Enter city:");
                                city = sc.next();
                                System.out.println("Enter department:");
                                department = sc.next();
                                //attach values to the existing object
                                employee.setName(name);
                                employee.setSalary(salary);
                                employee.setCity(city);
                                employee.setDepartment(department);
                                //reach out to service with attached new values object for updation in DB
                                employeeService.updateEmployee(employee);
                                System.out.println("Employee Record Updated");
                            } catch (SQLException | ResourceNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 5:
                            try {
                                list = employeeService.fetchAllEmployee();
                                while(true){
                                    System.out.println("Filter Employee Data Menu");
                                    System.out.println("1. Filter by city");
                                    System.out.println("2. Filter by salary");
                                    System.out.println("3. Filter by department");
                                    System.out.println("4. Filter by date of joining");
                                    System.out.println("0. Exit");
                                    int filterInput = sc.nextInt();

                                    if(filterInput == 0){
                                        break;
                                    }

                                    switch (filterInput) {
                                        case 1:
                                            System.out.println("Enter city value");
                                            List<Employee> filteredList = employeeService.filterEmployeeByCity(list,sc.next());
                                            for(Employee e : filteredList){
                                                System.out.println(e);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter salary value");
                                            filteredList = employeeService.filterEmployeeBySalary(list,sc.nextDouble());
                                            for(Employee e : filteredList){
                                                System.out.println(e);
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter department value");
                                            filteredList = employeeService.filterEmployeeByDepartment(list,sc.next());
                                            for(Employee e : filteredList){
                                                System.out.println(e);
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Enter DOJ value");
                                            filteredList = employeeService.filterEmployeeByDOJ(list,sc.next());
                                            for(Employee e : filteredList){
                                                System.out.println(e);
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid Input...try again");
                                    }
                                }
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            break;


                        case 6:
                            System.out.println("Sort Employee Data");
                            try {
                                list = employeeService.fetchAllEmployee();
                                List<Employee> sortedList = employeeService.sortBySalary(list,"DESC");
                                sortedList.stream().forEach(e-> System.out.println(e));
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        case 7:
                            try {
                                list = employeeService.fetchAllEmployee();
                                Map<String, Integer> map = employeeService.statsByCity(list);
                                System.out.println(map);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        default:
                            System.out.println("Invalid Input.. Try Again");
                    } // switch ends
                } // while ends

                sc.close();
    } // main ends
} // class ends
