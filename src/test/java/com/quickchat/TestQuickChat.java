package com.quickchat;

import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class TestQuickChat {
    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.registerUser("John", "Doe", "j_doe", "Password123!", "+27834567890");

        Message.clearMessages();

        Message.addMessage(new Message("1234567890", "+27834557896", "Did you get the cake?", "Sent"));
        Message.addMessage(new Message("2234567890", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored"));
        Message.addMessage(new Message("3234567890", "+27834484567", "Yohoooo, I am at your gate.", "Disregard"));
        Message.addMessage(new Message("4234567890", "+27838884567", "It is dinner time!", "Sent"));
        Message.addMessage(new Message("5234567890", "+27838884567", "ok, I am leaving without you.", "Stored"));

        Message.loadStoredMessages(); // Optional
    }

    @Test
    public void testSentMessagesArray(Object QuickChat) {
        String expected = "Sender: +27834567890, Recipient: +27834557896, Message: Did you get the cake?\n" +
                "Sender: +27834567890, Recipient: +27838884567, Message: It is dinner time!\n";
        assertEquals(expected, QuickChat.getClass());
    }

    @Test
    public void testLongestMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expected, TestQuickChat.displayLongestMessage());
    }

    private static String displayLongestMessage() {
        return "";
    }

    @Test
    public void testSearchByRecipient(Object QuickChat) {
        String expected = "Messages to +27838884567:\n" +
                "Where are you? You are late! I have asked you to be on time.\n" +
                "It is dinner time!\n" +
                "ok, I am leaving without you.\n";
        assertEquals(expected,
                QuickChat.hashCode());
    }

    @Test
    public void testDeleteByMessageHash() throws UnsupportedEncodingException {
        String hash = "42:2ITTIME";
        String expected = "Message \"It is dinner time!\" successfully deleted.";
        assertEquals(expected, hash.getBytes(hash));
        assertFalse(Message.getMessageHashes().contains(hash));
    }

    @Test
    public void testDisplayReport(Object QuickChat) {
        String expected = "Sent Messages Report:\n" +
                "Message Hash: 12:1DIDGET, Recipient: +27834557896, Message: Did you get the cake?\n" +
                "Message Hash: 42:2ITTIME, Recipient: +27838884567, Message: It is dinner time!\n";
        assertEquals(expected, QuickChat.getClass());
    }
}
