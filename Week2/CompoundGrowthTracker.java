package Week2;

import java.util.Scanner;

public class CompoundGrowthTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Inputs ---
        System.out.print("Enter initial balance: ");
        double balance = input.nextDouble();
        System.out.print("Enter deposit amount: ");
        double deposit = input.nextDouble();
        System.out.print("Enter interest rate (%): ");
        double ratePercent = input.nextDouble();
        System.out.print("Enter starting count: ");
        int startCount = input.nextInt();

        double growth = 1 + ratePercent / 100;

        // --- Part 1: compound assignment operators (+= and *=) ---
        System.out.println();
        System.out.println("=== Balance Growth ===");
        System.out.printf("Starting balance : %.2f%n", balance);

        balance += deposit;      // deposit
        System.out.printf("After += deposit : %.2f%n", balance);

        balance *= growth;       // interest
        System.out.printf("After *= growth  : %.2f%n", balance);

        balance += deposit;      // another deposit
        System.out.printf("After += deposit : %.2f%n", balance);

        balance *= growth;       // interest again
        System.out.printf("After *= growth  : %.2f%n", balance);

        // --- Part 2: postfix increment (count++) ---
        System.out.println();
        System.out.println("=== Increment Test ===");
        int count = startCount;
        System.out.println("count++ prints   : " + count++);
        System.out.println("count now        : " + count);

        // --- Part 3: prefix increment (++count) ---
        count = startCount;
        System.out.println("++count prints   : " + ++count);
        System.out.println("count now        : " + count);

        // Why the two printed values differ:
        // With count++ (postfix), Java first uses the old value of count
        // in the println, and only after that adds 1. So it prints the
        // starting value, and printing count again right after shows the
        // increased value.
        // With ++count (prefix), Java adds 1 to count first and then uses
        // the new value in the println. So it prints the increased value
        // immediately, and printing count again right after shows the same value.
        // In short: postfix = use first, then increase; prefix = increase
        // first, then use.

        input.close();
    }
}
