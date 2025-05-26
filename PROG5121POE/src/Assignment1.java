import javax.swing.JOptionPane;

public class Assignment1 {
    public static void main(String[] args) {
        // Collect user input using JOptionPane dialogs
        String firstName = JOptionPane.showInputDialog(null, "Enter First Name:");
        String lastName = JOptionPane.showInputDialog(null, "Enter Last Name:");
        String userName = JOptionPane.showInputDialog(null, "Enter Username (must contain '_' and be <= 5 chars):");
        String password = JOptionPane.showInputDialog(null, "Enter Password (min 8 chars, must include uppercase, lowercase, digit, and special char):");
        String cellNumber = JOptionPane.showInputDialog(null, "Enter Cell Number (must start with +27 and be 12 characters total):");

        // Create a Login object
        Login login = new Login(firstName, lastName, userName, password, cellNumber);

        // Perform validation checks
        boolean isUsernameValid = login.checkUserName();
        boolean isPasswordValid = login.checkPasswordComplex();
        boolean isCellValid = login.checkCellNumber();

        // Prepare result message
        StringBuilder result = new StringBuilder("Validation Results:\n");
        result.append("Username valid: ").append(isUsernameValid).append("\n");
        result.append("Password valid: ").append(isPasswordValid).append("\n");
        result.append("Cell number valid: ").append(isCellValid).append("\n");

        if (isUsernameValid && isPasswordValid && isCellValid) {
            result.append("Registration successful!");
        } else {
            result.append("Registration failed. Please fix the errors and try again.");
        }

        // Show the results in a message dialog
        JOptionPane.showMessageDialog(null, result.toString());
    }
}
