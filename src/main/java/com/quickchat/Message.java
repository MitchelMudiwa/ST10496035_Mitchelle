package com.quickchat;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Message {
    private final String messageId;
    private final String recipient;
    private final String message;
    private final String messageHash;
    private String flag;

    private static int totalMessagesSent = 0;
    private static final List<Message> sentMessages = new ArrayList<>();
    private static final List<Message> disregardedMessages = new ArrayList<>();
    private static final List<Message> storedMessages = new ArrayList<>();
    private static final List<String> messageHashes = new ArrayList<>();
    private static final List<String> messageIds = new ArrayList<>();

    public Message(String messageId, String recipient, String message, String flag) {
        this.messageId = messageId;
        this.recipient = normalizeRecipient(recipient);
        this.message = message;
        this.flag = flag;
        this.messageHash = createMessageHash();

        switch (flag) {
            case "Sent" -> {
                sentMessages.add(this);
                totalMessagesSent++;
            }
            case "Disregard" -> disregardedMessages.add(this);
            case "Stored" -> storedMessages.add(this);
        }

        messageHashes.add(messageHash);
        messageIds.add(messageId);
    }

    public static void clearMessages() {
    }

    public static void getMessageHashes(Message sent) {
    }

    public static void addMessage(Message sent) {
    }

    private String normalizeRecipient(String recipient) {
        if (recipient.startsWith("0") && recipient.length() == 10) {
            return "+27" + recipient.substring(1);
        }
        return recipient;
    }

    public boolean checkMessageId() {
        return messageId != null && messageId.matches("\\d{10}");
    }

    public boolean checkRecipientCell() {
        return recipient != null && recipient.matches("^\\+27\\d{9}$");
    }

    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        String hash = messageId.substring(0, 2) + ":" + totalMessagesSent + firstWord + lastWord;
        return hash.toUpperCase();
    }

    public String sendMessage() {
        if (message.length() > 250) {
            return "Please enter a message of less than 250 characters.";
        }
        if (!checkRecipientCell()) {
            return "Recipient cell number is invalid.";
        }

        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Message Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> {
                this.flag = "Sent";
                sentMessages.add(this);
                totalMessagesSent++;
                messageHashes.add(messageHash);
                messageIds.add(messageId);
                displayMessageDetails();
                return "Message sent.";
            }
            case 1 -> {
                this.flag = "Disregard";
                disregardedMessages.add(this);
                messageHashes.add(messageHash);
                messageIds.add(messageId);
                return "Message disregarded.";
            }
            case 2 -> {
                this.flag = "Stored";
                storedMessages.add(this);
                storeMessage();
                messageHashes.add(messageHash);
                messageIds.add(messageId);
                return "Message stored.";
            }
            default -> {
                return "No action taken.";
            }
        }
    }

    private void displayMessageDetails() {
        JOptionPane.showMessageDialog(null, getDetails(), "Message Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getDetails() {
        return "Message ID: " + messageId + "\n" +
                "Message Hash: " + messageHash + "\n" +
                "Recipient: " + recipient + "\n" +
                "Message: " + message;
    }

    public void storeMessage() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Message> allMessages = loadMessageList();

        allMessages.add(this);

        try (FileWriter writer = new FileWriter("messages.json")) {
            gson.toJson(allMessages, writer);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
        }
    }

    private List<Message> loadMessageList() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("messages.json")) {
            return gson.fromJson(reader, new TypeToken<List<Message>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void loadStoredMessages() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("messages.json")) {
            List<Message> messages = gson.fromJson(reader, new TypeToken<List<Message>>() {}.getType());
            storedMessages.clear();
            for (Message msg : messages) {
                if ("Stored".equals(msg.flag)) {
                    storedMessages.add(msg);
                }
            }
        } catch (IOException e) {
            // file not found or unreadable — silent fail is fine here
        }
    }

    public static List<Message> getSentMessages() {
        return sentMessages;
    }

    public static List<Message> getDisregardedMessages() {
        return disregardedMessages;
    }

    public static List<Message> getStoredMessages() {
        return storedMessages;
    }

    public static List<String> getMessageHashes() {
        return messageHashes;
    }

    public static List<String> getMessageIds(Message sent) {
        return messageIds;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    // Getters
    public String getMessageId() {
        return messageId;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getFlag() {
        return flag;
    }
}
