package Week2;

public class PrecedencePuzzleSolver {
    public static void main(String[] args) {
        // Expression 1
        // PREDICTED: true
        boolean r1 = 10 + 5 * 2 - 8 / 4 % 3 > 15 && 7 % 4 == 3;
        System.out.println("Expression 1 -> Predicted: true | Actual: " + r1);

        // Expression 2
        // PREDICTED: r2 = 19, x = 7
        int x = 5;
        int r2 = x++ + ++x * 2;
        System.out.println("Expression 2 -> Predicted: r2 = 19, x = 7 | Actual: r2 = "
                + r2 + ", x = " + x);

        // Expression 3
        // PREDICTED: true
        boolean r3 = 7 / 2 * 2.0 == 7.0;
        System.out.println("Expression 3 -> Predicted: true | Actual: " + r3);
        // I was wrong. I predicted true because I thought 7 / 2 * 2.0 would be 7.0.
        // The precedence rule I missed: / and * have equal precedence and go left
        // to right, so 7 / 2 is done first. Since both 7 and 2 are ints, this is
        // integer division = 3 (the .5 is dropped). Then 3 * 2.0 = 6.0, and
        // 6.0 == 7.0 is false.
    }
}

