package Week2;

public class CompoundGrowthTracker {
    public static void main(String[] args) {
        // --- Part 1: compound assignment operators (+= and *=) ---
        double balance = 1000.00;
        System.out.printf("Starting balance : %.2f%n", balance);

        balance += 500;      // deposit of 500
        System.out.printf("After += 500     : %.2f%n", balance);

        balance *= 1.05;     // 5% interest
        System.out.printf("After *= 1.05    : %.2f%n", balance);

        balance += 250;      // deposit of 250
        System.out.printf("After += 250     : %.2f%n", balance);

        balance *= 1.10;     // 10% interest
        System.out.printf("After *= 1.10    : %.2f%n", balance);

        // --- Part 2: postfix increment (count++) ---
        int count = 5;
        System.out.println("count++ prints   : " + count++);
        System.out.println("count now        : " + count);

        // --- Part 3: prefix increment (++count) ---
        count = 5;
        System.out.println("++count prints   : " + ++count);
        System.out.println("count now        : " + count);

        // Why the two printed values differ:
        // With count++ (postfix), Java first uses the old value of count (5)
        // in the println, and only after that adds 1. So it prints 5, and
        // printing count again right after shows 6.
        // With ++count (prefix), Java adds 1 to count first (5 becomes 6) and
        // then uses the new value in the println. So it prints 6, and
        // printing count again right after still shows 6.
        // In short: postfix = use first, then increase; prefix = increase
        // first, then use.
    }
}

