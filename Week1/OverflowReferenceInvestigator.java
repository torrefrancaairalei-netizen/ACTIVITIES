import java.util.Arrays;

public class OverflowReferenceInvestigator {
    public static void main(String[] args) {
        // --- Part 1: byte overflow ---
        byte small = 127;       // maximum value of a byte
        small++;                // wraps around to the minimum value
        System.out.println("byte 127 + 1 = " + small);   // -128
        // A byte only holds -128 to 127. Going past the max wraps around
        // to the minimum instead of throwing an error.

        // --- Part 2: String comparison ---
        String s1 = new String("hello");   // new object on the heap
        String s2 = new String("hello");   // another new object on the heap
        String s3 = "hello";               // literal (String pool)

        System.out.println();
        System.out.println("s1 == s2      : " + (s1 == s2));
        // s1 == s2 -> false: both were created with "new", so they are two
        // separate objects in memory, even though the text is the same.

        System.out.println("s1 == s3      : " + (s1 == s3));
        // s1 == s3 -> false: s1 is a new object on the heap, while s3 points
        // to the literal in the String pool, so they are different objects.

        System.out.println("s2 == s3      : " + (s2 == s3));
        // s2 == s3 -> false: same reason; s2 is a new object, s3 is the pooled literal.

        System.out.println("s1.equals(s2) : " + s1.equals(s2));
        System.out.println("s1.equals(s3) : " + s1.equals(s3));
        System.out.println("s2.equals(s3) : " + s2.equals(s3));
        // All .equals() -> true: .equals() compares the text (contents),
        // and all three Strings contain "hello".

        // --- Part 3: shared array reference ---
        int[] original = {1, 2, 3};
        int[] alias = original;            // copies the reference, not the array

        System.out.println();
        System.out.println("Before: original = " + Arrays.toString(original)
                + ", alias = " + Arrays.toString(alias));

        alias[0] = 99;                     // modify through one variable

        System.out.println("After : original = " + Arrays.toString(original)
                + ", alias = " + Arrays.toString(alias));
        // Both variables point to the SAME array object, so a change made
        // through alias is visible through original.
    }
}
