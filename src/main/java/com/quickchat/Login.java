
  package com.quickchat;

import java.util.regex.Pattern;

    public class Login {
        private User user;

        public boolean checkUsername(String username) {
            return username != null && username.matches("^[a-zA-Z0-9_]{1,5}$") && username.contains("_");
        }

        public boolean checkPasswordComplexity(String password) {
            return password != null && password.length() >= 8 &&
                    Pattern.compile("[A-Z]").matcher(password).find() &&
                    Pattern.compile("[0-9]").matcher(password).find() &&
                    Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        }

        public boolean checkCellNumber(String cellNumber) {
            return cellNumber != null && Pattern.matches("\\+27\\d{9}", cellNumber);
        }

        public String registerUser(String firstName, String lastName, String username, String password, String cellNumber) {
            if (!checkUsername(username)) {
                return "Username is not correctly formatted: Must be up to 5 characters and contain an underscore.";
            }
            if (!checkPasswordComplexity(password)) {
                return "Password is not correctly formatted: Must be at least 8 characters, include a capital letter, number, and special character.";
            }
            if (!checkCellNumber(cellNumber)) {
                return "Cell number incorrectly formatted or does not contain international code (+27).";
            }
            this.user = new User(firstName, lastName, username, password, cellNumber);
            return "User successfully registered.";
        }

        public String returnLoginStatus(String username, String password) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return String.format("Welcome %s %s, it is great to see you again!",
                        user.getFirstName(), user.getLastName());
            }
            return "Username or password is incorrect, please try again.";
        }

        public User getUser() { return user; }
    }


