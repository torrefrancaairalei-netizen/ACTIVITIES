package Week3;

import java.util.Scanner;

public class NestedLoginValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Stored (correct) account details
        String correctUsername = "aira";
        String correctPassword = "java123";
        boolean accountLocked = false;   // change to true to test the locked path

        // Values typed by the user
        System.out.print("Enter username: ");
        String enteredUsername = input.next();
        System.out.print("Enter password: ");
        String enteredPassword = input.next();

        System.out.println();
        System.out.println("=== Login Check ===");

        if (enteredUsername.equals(correctUsername)) {
            System.out.println("Stage 1 (username)       : PASSED");
            if (enteredPassword.equals(correctPassword)) {
                System.out.println("Stage 2 (password)       : PASSED");
                if (!accountLocked) {
                    System.out.println("Stage 3 (account status) : PASSED");
                    System.out.println("Login successful. Welcome, " + enteredUsername + "!");
                } else {
                    System.out.println("Stage 3 (account status) : FAILED");
                    System.out.println("Login failed: your account is locked.");
                }
            } else {
                System.out.println("Stage 2 (password)       : FAILED");
                System.out.println("Login failed: incorrect password.");
            }
        } else {
            System.out.println("Stage 1 (username)       : FAILED");
            System.out.println("Login failed: username not found.");
        }

        input.close();
    }
}
