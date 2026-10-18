import java.util.Scanner;

public class ShoppingCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter store name: ");
        String storeName = input.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();

        // int * double -> double (the int is automatically widened)
        double totalCost = quantity * unitPrice;

        // totalCost should NOT be an int because prices have centavos
        // (decimal values). Storing it in an int would drop the fractional
        // part (or require a cast), so the total would be inaccurate.

        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Store      : " + storeName);
        System.out.println("Quantity   : " + quantity);
        System.out.printf("Unit Price : %.2f%n", unitPrice);
        System.out.printf("Total Cost : %.2f%n", totalCost);

        input.close();
    }
}
