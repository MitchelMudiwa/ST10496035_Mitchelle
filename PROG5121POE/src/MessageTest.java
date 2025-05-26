import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private static Message message;

    @BeforeAll
    public static void setUp() {
        message = new Message("+27831234567", "Hello there, welcome!");
    }

    @Test
    public void testValidConstructor() {
        assertDoesNotThrow(() -> new Message("+27831112233", "Short message"));
    }

    @Test
    public void testInvalidRecipientThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Message("0831234567", "Test message");
        });
        assertEquals("Invalid recipient number. Must start with +27 and be followed by 9 digits.", exception.getMessage());
    }

    @Test
    public void testMessageTooLongThrowsException() {
        String longMessage = "x".repeat(251);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Message("+27831234567", longMessage);
        });
        assertEquals("Message exceeds 250 characters.", exception.getMessage());
    }

    @Test
    public void testGetMessageContent() {
        assertEquals("Hello there, welcome!", message.getMessageContent());
    }

    @Test
    public void testIsValidMessageID() {
        assertTrue(message.isValidMessageID());
    }

    @Test
    public void testIsValidRecipient() {
        assertTrue(message.isValidRecipient("+27831234567"));
        assertFalse(message.isValidRecipient("27831234567")); // Missing +
        assertFalse(message.isValidRecipient("+271234"));     // Too short
    }

    @Test
    public void testGetMessageOption() {
        assertEquals("Message successfully sent.", message.getMessageOption(1));
        assertEquals("Press 0 to delete message.", message.getMessageOption(2));
        assertEquals("Message successfully stored.", message.getMessageOption(3));
        assertEquals("Invalid option entered.", message.getMessageOption(99));
    }

    @Test
    public void testToJSON() {
        JsonObject json = message.toJSON();
        assertEquals(message.getMessageContent(), json.get("message").getAsString());
        assertEquals(message.getTotalMessagesSent(), Message.getTotalMessagesSent());
        assertTrue(json.has("messageID"));
        assertTrue(json.has("messageHash"));
    }

    @Test
    public void testPrintMessageDetails() {
        String details = message.printMessageDetails();
        assertTrue(details.contains("Message ID:"));
        assertTrue(details.contains("Recipient: +27831234567"));
        assertTrue(details.contains("Message: Hello there, welcome!"));
    }

    @Test
    public void testGetTotalMessagesSent() {
        int before = Message.getTotalMessagesSent();
        new Message("+27830000000", "Another test message");
        assertEquals(before + 1, Message.getTotalMessagesSent());
    }
}
