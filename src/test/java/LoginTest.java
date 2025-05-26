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
public class LoginTest {
    @Test
    public void testCheckUserName_Valid() {
        Login login = new Login("John", "Doe", "j_d", "Pass123!", "+27841234567");
        assertTrue(login.checkUserName(), "Username should be valid with underscore and length <= 5");
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login login = new Login("Jane", "Smith", "janedoe", "Pass123!", "+27841234567");
        assertFalse(login.checkUserName(), "Username is too long and should be invalid");
    }

    @Test
    public void testCheckPasswordComplex_Valid() {
        Login login = new Login("Alex", "Jones", "a_j", "StrongP@ss1", "+27841234567");
        assertTrue(login.checkPasswordComplex(), "Password meets all complexity requirements");
    }

    @Test
    public void testCheckPasswordComplex_Invalid() {
        Login login = new Login("Alex", "Jones", "a_j", "weakpass", "+27841234567");
        assertFalse(login.checkPasswordComplex(), "Password does not meet complexity requirements");
    }

    @Test
    public void testCheckCellNumber_Valid() {
        Login login = new Login("Sam", "Lee", "s_l", "Test123@", "+27811234567");
        assertTrue(login.checkCellNumber(), "Cell number should start with +27 and be 12 characters long");
    }

    @Test
    public void testCheckCellNumber_Invalid() {
        Login login = new Login("Sam", "Lee", "s_l", "Test123@", "0811234567");
        assertFalse(login.checkCellNumber(), "Cell number does not start with +27");
    }
}