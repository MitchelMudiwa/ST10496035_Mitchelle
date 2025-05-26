/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.comany.assinment1.Message;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testGetMessageContent() {
        System.out.println("getMessageContent");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageContent();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsValidMessageID() {
        System.out.println("isValidMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.isValidMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsValidRecipient() {
        System.out.println("isValidRecipient");
        String number = "";
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.isValidRecipient(number);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMessageOption() {
        System.out.println("getMessageOption");
        int option = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageOption(option);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSON() {
        System.out.println("toJSON");
        Message instance = null;
        JSONObject expResult = null;
        JSONObject result = instance.toJSON();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintMessageDetails() {
        System.out.println("printMessageDetails");
        Message instance = null;
        String expResult = "";
        String result = instance.printMessageDetails();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTotalMessagesSent() {
        System.out.println("getTotalMessagesSent");
        int expResult = 0;
        int result = Message.getTotalMessagesSent();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}