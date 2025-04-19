package com.controller;

import com.service.TransferService;

import java.util.Scanner;
public class TransferController {
    public static void main(String[] args) {
        //take input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter senderID:");
        int senderId = scanner.nextInt();
        System.out.println("Enter receiverID:");
        int receiverId = scanner.nextInt();
        System.out.println("Enter transferAmount:");
        double amount = scanner.nextDouble();
        //reachout to service
        TransferService transferService = new TransferService();
        boolean isSuccess = transferService.transfer(senderId, receiverId, amount);
        //output
        System.out.println(isSuccess?"Transfer Successful": "Transfer Failed");
        scanner.close();
    }
}