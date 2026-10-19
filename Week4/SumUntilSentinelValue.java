package Week4;

import java.util.Scanner;

public class SumUntilSentinel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        while (number != -1) {
            total += number;
            System.out.print("Enter an integer: ");
            number = input.nextInt();
        }

        System.out.println("Final total: " + total);

        input.close();
    }
}

