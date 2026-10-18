public class ShoppingCalculator {
    public static void main(String[] args) {
        int quantity = 6;
        double unitPrice = 49.75;
        String storeName = "Aira Mini Grocery";

        // int * double -> double (the int is automatically widened)
        double totalCost = quantity * unitPrice;

        // totalCost should NOT be an int because prices have centavos
        // (decimal values). Storing it in an int would drop the fractional
        // part (or require a cast), so the total would be inaccurate.

        System.out.println("=== Receipt ===");
        System.out.println("Store      : " + storeName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Unit Price : " + unitPrice);
        System.out.println("Total Cost : " + totalCost);
    }
}

