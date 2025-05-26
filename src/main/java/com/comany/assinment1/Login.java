/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comany.assinment1;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellNumber;

    public Login(String firstName, String lastName, String userName, String password, String cellNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellNumber = cellNumber;
    }

    // Check if username is valid
    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplex() {
        return password.length() >= 8 &&
               password.matches(".[A-Z].") &&
               password.matches(".[a-z].") &&
               password.matches(".[0-9].") &&
               password.matches(".[!@#$%^&()].*");
    }

    // Check if cell number is valid
    public boolean isValidCellNumber() {
        return cellNumber != null && cellNumber.startsWith("+27") && cellNumber.length() == 9;
    }

    public String getLoginStatus() {
        if (checkUserName() && checkPasswordComplex() && isValidCellNumber()) {
            return "Login information is valid.";
        } else {
            return "Login information is invalid. Please check username, password, and cell number.";
        }
    }

    public boolean checkCellNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

