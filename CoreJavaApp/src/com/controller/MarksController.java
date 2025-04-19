package com.controller;

import com.service.MarksService;

import java.util.Scanner;

public class MarksController {
    public static void main(String[] args) {
        /* I/P*/
        System.out.println("Enter total number of Subjects");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[] marks = new double[num];// {0.0,0.0,0.0}
        System.out.println("Enter subject marks");
        for(int i=0;i<num;i++){
            System.out.println("marks of subject: " + (i+1));
            marks[i] = scanner.nextDouble();
        }

        /*  reachout to service layer*/
        MarksService marksService = new MarksService();
        String grade = marksService.computePercentage(marks);


        /* O/P */
        System.out.print("Grade is "+ grade);
        scanner.close();
    }
}
