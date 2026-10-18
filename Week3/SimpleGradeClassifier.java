package Week3;

import java.util.Scanner;

public class SimpleGradeClassifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter score: ");
        int score = input.nextInt();

        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        input.close();
    }
}

