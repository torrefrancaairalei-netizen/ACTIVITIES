package Week4;

public class PatternGeneratorWithEarlyExit {
    public static void main(String[] args) {
        int size = 6;
        int stopColumn = 4;
        int skipColumn = 2;

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) {

                if (col > stopColumn) {
                    break;      // BREAK: stops the inner loop early
                }

                if (col == skipColumn) {
                    continue;   // CONTINUE: skips printing this column
                }

                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
