package Week2;

import java.util.Scanner;

public class FourFunctionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = input.nextInt();
        System.out.print("Enter second integer: ");
        int b = input.nextInt();

        System.out.println("=== Results ===");
        System.out.println("Addition       (" + a + " + " + b + ") = " + (a + b));
        System.out.println("Subtraction    (" + a + " - " + b + ") = " + (a - b));
        System.out.println("Multiplication (" + a + " * " + b + ") = " + (a * b));

        if (b != 0) {
            System.out.println("Division       (" + a + " / " + b + ") = " + (a / b));
            System.out.println("Modulus        (" + a + " % " + b + ") = " + (a % b));
        } else {
            System.out.println("Division and modulus are undefined when the second number is 0.");
        }

        // Division (/) and modulus (%) behave differently with negative operands.
        // Integer division truncates toward zero (-7 / 2 = -3, not -4), and the
        // result of % takes the sign of the first operand (-7 % 2 = -1, 7 % -2 = 1).
        // Addition, subtraction, and multiplication follow normal math rules.

        input.close();
    }
}
