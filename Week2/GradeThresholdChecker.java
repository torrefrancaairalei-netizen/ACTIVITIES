package Week2;

import java.util.Scanner;

public class GradeThresholdChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter average grade: ");
        double average = input.nextDouble();
        System.out.print("Enter number of absences: ");
        int absences = input.nextInt();

        boolean passed = (average >= 75 && absences <= 3) || (average >= 90);

        System.out.println();
        System.out.println("Average  : " + average);
        System.out.println("Absences : " + absences);

        if (passed) {
            System.out.println("Result   : PASS");
            if (average >= 90) {
                System.out.println("Reason   : Congratulations! Your average is 90 or above, "
                        + "so your absences do not affect your result.");
            } else {
                System.out.println("Reason   : Congratulations! Your average is 75 or above "
                        + "and you have 3 or fewer absences.");
            }
        } else {
            System.out.println("Result   : FAIL");
            if (average < 75) {
                System.out.println("Reason   : Your average is below 75. "
                        + "You need an average of at least 75 to pass.");
            } else {
                System.out.println("Reason   : Your average is 75 or above, but you have more than "
                        + "3 absences. You need an average of 90 or above to pass with this many absences.");
            }
        }

        input.close();
    }
}
