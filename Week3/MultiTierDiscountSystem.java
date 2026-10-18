package Week3;

import java.util.Scanner;

public class MultiTierDiscountSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        if (purchaseAmount < 0) {
            System.out.println("Invalid amount: purchase amount cannot be negative.");
        } else {
            double discountPercent;
            String tier;

            if (purchaseAmount >= 5000) {
                discountPercent = 15;
                tier = "Platinum (15% off)";
            } else if (purchaseAmount >= 3000) {
                discountPercent = 10;
                tier = "Gold (10% off)";
            } else if (purchaseAmount >= 1000) {
                discountPercent = 5;
                tier = "Silver (5% off)";
            } else {
                discountPercent = 0;
                tier = "Regular (no discount)";
            }

            double discountAmount = purchaseAmount * discountPercent / 100;
            double finalPrice = purchaseAmount - discountAmount;

            System.out.println();
            System.out.println("=== Discount Summary ===");
            System.out.printf("Purchase Amount : %.2f%n", purchaseAmount);
            System.out.println("Discount Tier   : " + tier);
            System.out.printf("Discount Amount : %.2f%n", discountAmount);
            System.out.printf("Final Price     : %.2f%n", finalPrice);
            System.out.printf("You Saved       : %.2f%n", discountAmount);
        }

        input.close();
    }
}
