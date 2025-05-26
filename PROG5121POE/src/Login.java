public class Login {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String cellNumber;

    public Login(String name, String surname, String username, String password, String cellNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
    }

    // Checks if the password is complex enough
    public boolean checkPasswordComplex() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    // Checks if the cell number starts with +27 and has 12 characters
    public boolean checkCellNumber() {
        return cellNumber != null && cellNumber.startsWith("+27") && cellNumber.length() == 12;

    }

    // Example: check that username contains underscore and is <= 5 characters
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }
}
