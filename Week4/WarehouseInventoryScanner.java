package Week4;

import java.util.Scanner;

public class WarehouseInventoryScanner {

    static void restockShelf(int[][] warehouse, Scanner input) {
        System.out.print("Enter row (0-" + (warehouse.length - 1) + "): ");
        int row = input.nextInt();
        System.out.print("Enter shelf (0-" + (warehouse[0].length - 1) + "): ");
        int col = input.nextInt();

        if (row < 0 || row >= warehouse.length || col < 0 || col >= warehouse[row].length) {
            System.out.println("Invalid shelf location.");
            return;  
        }

        if (warehouse[row][col] == -1) {
            System.out.println("That shelf is damaged and cannot be restocked.");
            return;     
        }

        System.out.print("Enter quantity to add: ");
        int quantity = input.nextInt();

        while (quantity <= 0) {
            System.out.print("Invalid. Quantity must be greater than 0. Try again: ");
            quantity = input.nextInt();
        }

        warehouse[row][col] += quantity;
        System.out.println("Restocked shelf [" + row + "][" + col + "]. New count: "
                + warehouse[row][col]);
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] warehouse = {
            {20, 15, 30},
            {-1,  8, 12},
            {25,  2, 40},
            {18, -1,  9}
        };
        int criticalLevel = 5;   

        int choice;

        do {
            System.out.println();
            System.out.println("=== Warehouse Inventory Menu ===");
            System.out.println("1. Show total inventory");
            System.out.println("2. Find first critically low shelf");
            System.out.println("3. Restock a shelf");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    int total = 0;
                    for (int r = 0; r < warehouse.length; r++) {
                        for (int c = 0; c < warehouse[r].length; c++) {
                            if (warehouse[r][c] == -1) {
                                continue;  
                            }
                            total += warehouse[r][c];
                        }
                    }
                    System.out.println("Total inventory (damaged shelves skipped): " + total);
                    break;

                case 2:
                    boolean found = false;
                    int lowRow = -1;
                    int lowCol = -1;
                    for (int r = 0; r < warehouse.length; r++) {
                        for (int c = 0; c < warehouse[r].length; c++) {
                            if (warehouse[r][c] == -1) {
                                continue;   
                            }
                            if (warehouse[r][c] < criticalLevel) {
                                found = true;
                                lowRow = r;
                                lowCol = c;
                                break;     
                            }
                        }
                        if (found) {
                            break;        
                        }
                    }
                    if (found) {
                        System.out.println("First critically low shelf: [" + lowRow + "]["
                                + lowCol + "] with " + warehouse[lowRow][lowCol] + " item(s).");
                    } else {
                        System.out.println("No critically low shelves found.");
                    }
                    break;

                case 3:
                    restockShelf(warehouse, input);
                    break;

                case 4:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1 to 4.");
                    break;
            }
        } while (choice != 4);

        input.close();
    }
}
