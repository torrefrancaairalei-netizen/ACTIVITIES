package Week2;

public class GradeThresholdChecker {
    public static void main(String[] args) {
        double average = 82.5;
        int absences = 2;

        boolean meetsNormalRule = (average >= 75 && absences <= 3);
        boolean meetsHighAverage = (average >= 90);
        boolean passed = (average >= 75 && absences <= 3) || (average >= 90);

        System.out.println("Average  : " + average);
        System.out.println("Absences : " + absences);
        System.out.println("Average >= 75 AND absences <= 3 : " + meetsNormalRule);
        System.out.println("Average >= 90 (any absences)    : " + meetsHighAverage);

        if (passed) {
            System.out.println("Result   : PASS");
            if (meetsHighAverage) {
                System.out.println("Reason   : Average is 90 or higher, so absences do not matter.");
            } else {
                System.out.println("Reason   : Average is at least 75 and absences are 3 or fewer.");
            }
        } else {
            System.out.println("Result   : FAIL");
            System.out.println("Reason   : Needs average >= 75 with absences <= 3, or average >= 90.");
        }
    }
}

