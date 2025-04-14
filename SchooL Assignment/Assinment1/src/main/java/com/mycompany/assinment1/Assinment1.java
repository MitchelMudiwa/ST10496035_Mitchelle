/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assinment1;


/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Assinment1 {
    

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cellphone number with international code +27");
        String phoneNumber = scanner.nextLine();
        //Regular expression pattern
        //^\+ => starts with +
        //|d{1,3} =>country code(1 to 3 digits)
        //\d{1,10} =>phone number (1 to 10 didgits)
        //Total pattern:+<country code><number up to 10 digits> 
        String regex ="^\\+\\d{1,3}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()){
            System.out.println("True");
            System.out.println("Cellphone number successfully addded");
        }else{
            System.out.println("False");
            System.out.println("Cellphone number incorreclty formatted or does not contain international code");
        }
        
        scanner.close();
        
        
        
    }
}
