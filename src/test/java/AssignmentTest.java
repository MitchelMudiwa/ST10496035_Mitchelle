/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.comany.assinment1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class AssignmentTest {
  @Test
    public void testValidUserName() {
        Login login = new Login("John", "Doe", "j_doe", "Pa$$word1", "+27123456789");
        assertTrue(login.checkUserName(), "Username should be valid");
    }

    @Test
    public void testInvalidUserName() {
        Login login = new Login("Jane", "Smith", "janesmith", "Pa$$word1", "+27123456789");
        assertFalse(login.checkUserName(), "Username should be invalid (no underscore or too long)");
    }

    @Test
    public void testValidPassword() {
        Login login = new Login("John", "Doe", "j_d", "Abc@1234", "+27123456789");
        assertTrue(login.checkPasswordComplex(), "Password should meet complexity requirements");
    }

    @Test
    public void testInvalidPassword() {
        Login login = new Login("John", "Doe", "j_d", "password", "+27123456789");
        assertFalse(login.checkPasswordComplex(), "Password should fail complexity check");
    }

    @Test
    public void testValidCellNumber() {
        Login login = new Login("John", "Doe", "j_d", "Pa$$word1", "+27123456789");
        assertTrue(login.isValidCellNumber(), "Cell number should be valid");
    }

    @Test
    public void testInvalidCellNumber() {
        Login login = new Login("John", "Doe", "j_d", "Pa$$word1", "0123456789");
        assertFalse(login.isValidCellNumber(), "Cell number should be invalid (missing +27)");
    }

    @Test
    public void testLoginStatusSuccess() {
        Login login = new Login("John", "Doe", "j_d", "Pa$$word1", "+27123456789");
        assertEquals("Login information is valid.", login.getLoginStatus());
    }

    @Test
    public void testLoginStatusFailure() {
        Login login = new Login("John", "Doe", "john", "password", "0123456789");
        assertEquals("Login information is invalid. Please check username, password, and cell number.", login.getLoginStatus());
    }
}