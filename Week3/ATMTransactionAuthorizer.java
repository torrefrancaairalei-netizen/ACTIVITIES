package Week3;

import java.util.Scanner;

public class ATMTransactionAuthorizer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

     
        String correctUsername = "Aira";
        String correctPin = "1111";
        double balance = 1000000.00;


        System.out.print("Enter username: ");
        String enteredUsername = input.next();
        System.out.print("Enter 4-digit PIN: ");
        String enteredPin = input.next();
        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = input.nextDouble();


        boolean approved = false;
        String denialReason = "";
        String tier = "";
        double dailyLimit = 0;
        double feePercent = 0;
        double fee = 0;
        double totalDeduction = 0;


        if (enteredUsername.equals(correctUsername)) {
            if (enteredPin.matches("\\d{4}")) {
                if (enteredPin.equals(correctPin)) {


                    if (balance >= 100000) {
                        tier = "Platinum";
                        dailyLimit = 100000;
                    } else if (balance >= 50000) {
                        tier = "Gold";
                        dailyLimit = 30000;
                    } else if (balance >= 10000) {
                        tier = "Silver";
                        dailyLimit = 10000;
                    } else {
                        tier = "Bronze";
                        dailyLimit = 3000;
                    }


                    switch (tier) {
                        case "Bronze":
                            feePercent = 2.0;
                            break;
                        case "Silver":
                            feePercent = 1.5;
                            break;
                        case "Gold":
                            feePercent = 1.0;
                            break;
                        case "Platinum":
                            feePercent = 0.0;
                            break;
                        default:
                            feePercent = 2.0;
                            break;
                    }

                    fee = withdrawAmount * feePercent / 100;
                    totalDeduction = withdrawAmount + fee;


                    if (withdrawAmount <= 0) {
                        denialReason = "Withdrawal amount must be greater than zero.";
                    } else if (totalDeduction <= balance) {
                        if (withdrawAmount <= dailyLimit) {
                            approved = true;
                        } else {
                            denialReason = String.format(
                                    "Withdrawal of %.2f exceeds the %s daily limit of %.2f.",
                                    withdrawAmount, tier, dailyLimit);
                        }
                    } else {
                        denialReason = String.format(
                                "Insufficient balance. Amount plus fee (%.2f) is more than your balance (%.2f).",
                                totalDeduction, balance);
                    }
                } else {
                    denialReason = "Incorrect PIN.";
                }
            } else {
                denialReason = "PIN must be exactly 4 digits.";
            }
        } else {
            denialReason = "Username not found.";
        }

        // 5. Combine everything: APPROVE or DENY
        System.out.println();
        System.out.println("=== ATM Transaction ===");
        if (approved) {
            System.out.println("Status          : APPROVED");
            System.out.println("Account Tier    : " + tier);
            System.out.printf("Daily Limit     : %.2f%n", dailyLimit);
            System.out.printf("Withdrawal      : %.2f%n", withdrawAmount);
            System.out.printf("Fee (%.1f%%)      : %.2f%n", feePercent, fee);
            System.out.printf("Total Deducted  : %.2f%n", totalDeduction);
            System.out.printf("Old Balance     : %.2f%n", balance);
            System.out.printf("New Balance     : %.2f%n", balance - totalDeduction);
            System.out.printf("Limit Left Today: %.2f%n", dailyLimit - withdrawAmount);
        } else {
            System.out.println("Status          : DENIED");
            System.out.println("Reason          : " + denialReason);
        }

        input.close();
    }
}

