package Week3;

public class MultiTierDiscountSystem {
    public static void main(String[] args) {
        double purchaseAmount = 3500.00;   

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

        System.out.println("Purchase Amount : " + purchaseAmount);
        System.out.println("Discount Tier   : " + tier);
        System.out.println("Discount Amount : " + discountAmount);
        System.out.println("Final Price     : " + finalPrice);
    }
}

