
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template


/**
 *
 * @author RC_Student_lab.*;
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class UserValidationTest {
    @Test
    public void testUsernameCorrectFormat() {
        assertTrue(UserValidation.isUsernameValid("KYL_1"));
    }

    @Test
    public void testUsernameIncorrectFormat() {
        assertFalse(UserValidation.isUsernameValid("KYL"));
    }

    @Test
    public void testUsernameMessageCorrect() {
        String message = UserValidation.processUsername("KYL_1", "John", "Doe");
        assertEquals("Welcome John Doe, it is great to see you.", message);
    }

    @Test
    public void testUsernameMessageIncorrect() {
        String message = UserValidation.processUsername("KYL", "John", "Doe");
        assertEquals("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.", message);
    }

    @Test
    public void testPasswordMeetsRequirements() {
        assertTrue(UserValidation.isPasswordComplex("CHNNSEC@KE99"));
        assertEquals("Password successfully captured.", UserValidation.processPassword("CHNNSEC@KE99"));
    }

    @Test
    public void testPasswordFailsRequirements() {
        assertFalse(UserValidation.isPasswordComplex("password"));
        assertEquals("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.",
                UserValidation.processPassword("password"));
    }

    @Test
    public void testCellPhoneCorrectFormat() {
        assertTrue(UserValidation.isCellNumberValid("+27821234567"));
        assertEquals("Cell number successfully captured.", UserValidation.processCellNumber("+27821234567"));
    }

    @Test
    public void testCellPhoneIncorrectFormat() {
        assertFalse(UserValidation.isCellNumberValid("0821234567"));
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                UserValidation.processCellNumber("0821234567"));
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(UserValidation.login("KYL_1", "CHNNSEC@KE99"));
    }

    @Test
    public void testLoginFailure() {
        assertFalse(UserValidation.login("KYL", "password"));
    }
}
 