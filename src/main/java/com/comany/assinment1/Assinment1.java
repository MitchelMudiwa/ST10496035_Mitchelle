/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comany.assinment1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Assinment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect user input
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter Username (must contain '_' and be <= 5 chars): ");
        String userName = scanner.nextLine().trim();

        System.out.print("Enter Password (min 8 chars, must include uppercase, lowercase, digit, and special char): ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Number (must start with +27 and be 12 characters total): ");
        String cellNumber = scanner.nextLine().trim();

        // Create a Login object
        Login login = new Login(firstName, lastName, userName, password, cellNumber);

        // Perform validation checks
        boolean isUsernameValid = login.checkUserName();
        boolean isPasswordValid = login.checkPasswordComplex();
        boolean isCellValid = login.checkCellNumber();

        // Display results
        System.out.println("\nValidation Results:");
        System.out.println("Username valid: " + isUsernameValid);
        System.out.println("Password valid: " + isPasswordValid);
        System.out.println("Cell number valid: " + isCellValid);

        if (isUsernameValid && isPasswordValid && isCellValid) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Please fix the errors and try again.");
        }

        scanner.close();
    }
}

    

