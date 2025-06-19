package com.quickchat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login();
    }

    @Test
    void testCheckUsernameValid() {
        assertTrue(login.checkUsername("u_s12"), "Valid username should pass");
    }

    @Test
    void testCheckUsernameInvalid() {
        assertFalse(login.checkUsername("user12"), "Username without underscore should fail");
        assertFalse(login.checkUsername("user_123"), "Username longer than 5 chars should fail");
    }

    @Test
    void testCheckPasswordComplexityValid() {
        assertTrue(login.checkPasswordComplexity("Pass123!"), "Valid password should pass");
    }

    @Test
    void testCheckPasswordComplexityInvalid() {
        assertFalse(login.checkPasswordComplexity("pass123"), "Password without capital/special char should fail");
        assertFalse(login.checkPasswordComplexity("Pass12!"), "Password shorter than 8 chars should fail");
    }

    @Test
    void testCheckCellNumberValid() {
        assertTrue(login.checkCellNumber("+27812345678"), "Valid RSA cell number should pass");
    }

    @Test
    void testCheckCellNumberInvalid() {
        assertFalse(login.checkCellNumber("0812345678"), "Cell number without +27 should fail");
        assertFalse(login.checkCellNumber("+278123456"), "Cell number with wrong length should fail");
    }

    @Test
    void testRegisterUserSuccess() {
        String result = login.registerUser("John", "Doe", "u_s12", "Pass123!", "+27812345678");
        assertEquals("User successfully registered.", result);
    }

    @Test
    void testRegisterUserFailure() {
        String result = login.registerUser("John", "Doe", "user12", "Pass123!", "+27812345678");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    void testLoginStatusSuccess() {
        login.registerUser("John", "Doe", "u_s12", "Pass123!", "+27812345678");
        String status = login.returnLoginStatus("u_s12", "Pass123!");
        assertEquals("Welcome John Doe, it is great to see you again!", status);
    }

    @Test
    void testLoginStatusFailure() {
        login.registerUser("John", "Doe", "u_s12", "Pass123!", "+27812345678");
        String status = login.returnLoginStatus("u_s12", "WrongPass");
        assertEquals("Username or password is incorrect, please try again.", status);
    }
}