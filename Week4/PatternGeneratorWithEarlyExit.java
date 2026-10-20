package Week4;

public class PatternGeneratorWithEarlyExit {
    public static void main(String[] args) {
        int size = 6;        
        int stopColumn = 4; 
        int skipColumn = 2; 

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) {

                // BREAK: exits the INNER loop once col passes stopColumn
                if (col > stopColumn) {
                    break;
                }

                // CONTINUE: skips printing only when col equals skipColumn
                if (col == skipColumn) {
                    continue;
                }

                System.out.print("* ");
            }
            System.out.println(); // move to the next row
        }
    }
}
