package com.quickchat;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QuickChatApp {
    private Login login;
    private List<Message> sentMessages;
    private List<Message> disregardedMessages;
    private boolean isLoggedIn;

    public QuickChatApp() {
        login = new Login();
        sentMessages = new ArrayList<>();
        disregardedMessages = new ArrayList<>();
        isLoggedIn = false;
    }

    public void start() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        registerUser();
        if (login.getUser() != null) {
            loginUser();
        }
        if (isLoggedIn) {
            runChat();
        }
    }

    private void registerUser() {
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String username = JOptionPane.showInputDialog("Enter Username (up to 5 chars, must include '_'):");
        String password = JOptionPane.showInputDialog("Enter Password (8+ chars, capital, number, special char):");
        String cellNumber = JOptionPane.showInputDialog("Enter Cell Number (+27xxxxxxxxx):");
        String result = login.registerUser(firstName, lastName, username, password, cellNumber);
        JOptionPane.showMessageDialog(null, result);
    }

    private void loginUser() {
        String username = JOptionPane.showInputDialog("Enter Username:");
        String password = JOptionPane.showInputDialog("Enter Password:");
        String status = login.returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, status);
        isLoggedIn = status.contains("Welcome");
    }

    private void runChat() {
        int numMessages;
        try {
            numMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format.");
            return;
        }

        for (int i = 0; i < numMessages; ) {
            String choice = JOptionPane.showInputDialog(
                    "Select an option:\n1) Send Messages\n2) Show Recent Messages\n3) Quit");

            switch (choice == null ? "3" : choice) {
                case "1":
                    if (sendMessage()) {
                        i++;
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Feature coming soon!");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Total messages sent: " + sentMessages.size());
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "Total messages sent: " + sentMessages.size());
    }

    private boolean sendMessage() {
        String recipient = JOptionPane.showInputDialog("Enter Recipient Cell Number (+27xxxxxxxxx):");
        if (!Pattern.matches("\\+27\\d{9}", recipient)) {
            JOptionPane.showMessageDialog(null, "Invalid recipient cell number.");
            return false;
        }

        String messageId = JOptionPane.showInputDialog("Enter Message ID (10 digits):");
        String content = JOptionPane.showInputDialog("Enter Message (max 250 chars):");

        Message message = new Message(messageId, recipient, content, "Pending");

        if (!message.checkRecipientCell() || !message.checkMessageId()) {
            JOptionPane.showMessageDialog(null, "Invalid message ID or recipient number.");
            return false;
        }

        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int action = JOptionPane.showOptionDialog(null, "Choose an action:", "Message Action",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (action) {
            case 0: // Send
                message.sendMessage(); // internally adds to list + shows details
                sentMessages.add(message);
                return true;
            case 1: // Disregard
                message = new Message(messageId, recipient, content, "Disregard");
                disregardedMessages.add(message);
                return false;
            case 2: // Store
                message = new Message(messageId, recipient, content, "Stored");
                message.storeMessage();
                JOptionPane.showMessageDialog(null, "Message stored in JSON file.");
                return false;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuickChatApp().start());
    }
}
