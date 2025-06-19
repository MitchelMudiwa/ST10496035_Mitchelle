package com.quickchat;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class JsonHandler {
        private static final String JSON_FILE = "src/main/resources/stored_messages.json";

        public static void storeMessage(Message message) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            List<Message> messages = readMessages();
            messages.add(message);
            mapper.writeValue(new File(JSON_FILE), messages);
        }

        public static List<Message> readMessages() throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(JSON_FILE);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return new ArrayList<>(List.of(mapper.readValue(file, Message[].class)));
        }
    }

