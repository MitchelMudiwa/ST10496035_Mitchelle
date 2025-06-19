package com.quickchat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    void testCheckMessageId() {
        Message message = new Message("+27812345678", "Hello world", "Did you get the cake?", "Sent");
        assertTrue(message.checkMessageId(), "Message ID should be 10 digits");
    }

    @Test
    void testCheckRecipientCellValid() {
        Message message = new Message("+27812345678", "Hello", "Did you get the cake?", "Sent");
        assertEquals(12, message.checkRecipientCell(), "Valid cell number should return length");
    }

    @Test
    void testCheckRecipientCellInvalid() {
        Message message = new Message("0812345678", "Hello", "Did you get the cake?", "Sent");
        assertEquals(-1, message.checkRecipientCell(), "Invalid cell number should return -1");
    }

    @Test
    void testCreateMessageHash() {
        Message message = new Message("+27812345678", "Hit the ball thanks", "Did you get the cake?", "Sent");
        String hash = message.createMessageHash();
        assertTrue(hash.matches("\\d{2}:\\d+HITTHANKS"), "Hash should match format");
    }

    @Test
    void testSendMessageValid() {
        Message message = new Message("+27812345678", "Short message", "Did you get the cake?", "Sent");
        assertEquals("Message sent", message.sendMessage(), "Valid message should send");
    }

    @Test
    void testSendMessageTooLong() {
        String longMessage = "x".repeat(251);
        Message message = new Message("+27812345678", longMessage, "Did you get the cake?", "Sent");
        assertEquals("Please enter a message of less than 250 characters", message.sendMessage(),
                "Long message should fail");
    }
}