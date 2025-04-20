package com.controller;

import com.service.MapDemoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {
    public static void main(String[] args) {
        //I/P
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter ID");
        int id = sc.nextInt();

        //reach out to service
        MapDemoService mapDemoService = new MapDemoService();
        boolean isValid = mapDemoService.validateUser(name, id);

        //O/P
        System.out.println(isValid?"Valid User" : "Invalid User");

    }
}
/*
Map
|
|
HashMap
 */