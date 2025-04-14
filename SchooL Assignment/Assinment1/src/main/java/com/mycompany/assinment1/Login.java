/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assinment1;

/**
 *
 * @author RC_Student_lab
 */
//Atribution
public class Login extends Assinment1 {
        private String firstname;
        private String lastname;
        private String username;
        private String password;
        private String cellNumber;
        
       // construction
public Login(String firstname,String lastname,String username,String password, String cellNumber) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
    this.cellNumber = cellNumber;
}   
public boolean checkUserName(){
    return username.contains("_")&& username.length()<=5;
  
}
 public boolean checkPasswordComplex(String password){
     return password.length()>=8&&
             password.matches(".*[A-Z].*")&&
             password.matches(".*[a-z].*")&&
             password.matches(".*[0-9].*")&&
             password.matches(".*[!@#$%^&*()].*");
 }
 public boolean checkCellPhoneNumber(){
     return cellNumber != null && cellNumber.matches("\\+27\\d{9}");
     
     
   
   
             
            
             
     
}             

    boolean checkPasswordComplex() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean loginUser(String kyl_1, String pass123) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
     
     
     
     
     
     
     
     
 }
        
       
        
 
    
    
    
    

