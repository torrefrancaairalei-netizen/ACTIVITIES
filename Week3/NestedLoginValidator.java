package Week3;

public class NestedLoginValidator {
    public static void main(String[] args) {
        String correctUsername = "aira";
        String correctPassword = "java123";
        boolean accountLocked = false;

        String enteredUsername = "aira";
        String enteredPassword = "java123";

        if (enteredUsername.equals(correctUsername)) {
            if (enteredPassword.equals(correctPassword)) {
                if (!accountLocked) {
                    System.out.println("Login successful. Welcome, " + enteredUsername + "!");
                } else {
                    System.out.println("Login failed: your account is locked.");
                }
            } else {
                System.out.println("Login failed: incorrect password.");
            }
        } else {
            System.out.println("Login failed: username not found.");
        }

    }
}


