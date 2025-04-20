package com.controller;

import com.model.Employee;
import com.service.EmployeeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                            List<Employee> list = new ArrayList<>();
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
                            // Add delete logic here
                            break;

                        case 4:
                            System.out.println("Update Employee Info");
                            // Add update logic here
                            break;

                        case 5:
                            System.out.println("Filter Employee Data");
                            // Add filter logic here
                            break;

                        case 6:
                            System.out.println("Sort Employee Data");
                            // Add sort logic here
                            break;

                        default:
                            System.out.println("Invalid Input.. Try Again");
                    } // switch ends
                } // while ends

                sc.close();
    } // main ends
} // class ends
