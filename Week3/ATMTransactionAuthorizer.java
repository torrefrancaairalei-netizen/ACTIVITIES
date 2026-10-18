package Week3;

public class ATMTransactionAuthorizer {
    public static void main(String[] args) {
        String correctUsername = "aira";
        String correctPin = "1234";
        double balance = 25000.00;

        String enteredUsername = "aira";
        String enteredPin = "1234";
        double withdrawAmount = 5000.00;

        boolean approved = false;
        String denialReason = "";
        String tier = "";
        double dailyLimit = 0;
        double feePercent = 0;
        double fee = 0;
        double totalDeduction = 0;

        if (enteredUsername.equals(correctUsername)) {
            if (enteredPin.length() == 4 && enteredPin.equals(correctPin)) {

                if (balance >= 100000) {
                    tier = "Platinum";
                    dailyLimit = 100000;
                } else if (balance >= 50000) {
                    tier = "Gold";
                    dailyLimit = 50000;
                } else if (balance >= 10000) {
                    tier = "Silver";
                    dailyLimit = 20000;
                } else {
                    tier = "Bronze";
                    dailyLimit = 5000;
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
                }

                fee = withdrawAmount * feePercent / 100;
                totalDeduction = withdrawAmount + fee;

                if (totalDeduction <= balance) {
                    if (withdrawAmount <= dailyLimit) {
                        approved = true;
                    } else {
                        denialReason = "Withdrawal exceeds the " + tier
                                + " daily limit of " + dailyLimit + ".";
                    }
                } else {
                    denialReason = "Insufficient balance. Amount plus fee ("
                            + totalDeduction + ") is more than your balance (" + balance + ").";
                }
            } else {
                denialReason = "Incorrect or invalid 4-digit PIN.";
            }
        } else {
            denialReason = "Username not found.";
        }

        System.out.println("=== ATM Transaction ===");
        if (approved) {
            System.out.println("Status          : APPROVED");
            System.out.println("Account Tier    : " + tier);
            System.out.println("Withdrawal      : " + withdrawAmount);
            System.out.println("Fee (" + feePercent + "%)    : " + fee);
            System.out.println("New Balance     : " + (balance - totalDeduction));
        } else {
            System.out.println("Status          : DENIED");
            System.out.println("Reason          : " + denialReason);
        }
    }
}



