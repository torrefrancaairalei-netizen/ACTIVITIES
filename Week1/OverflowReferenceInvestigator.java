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

        System.out.println("s1 == s2      : " + (s1 == s2));        // false
        System.out.println("s1 == s3      : " + (s1 == s3));        // false
        System.out.println("s2 == s3      : " + (s2 == s3));        // false
        System.out.println("s1.equals(s2) : " + s1.equals(s2));     // true
        System.out.println("s1.equals(s3) : " + s1.equals(s3));     // true
        System.out.println("s2.equals(s3) : " + s2.equals(s3));     // true
        // == compares references (are they the same object in memory?).
        // s1 and s2 were each created with "new", so they are two different
        // objects. s3 points to the pooled literal, a third object, so every
        // == is false. .equals() compares the text contents, which are all
        // "hello", so every .equals() is true.

        // --- Part 3: shared array reference ---
        int[] original = {1, 2, 3};
        int[] alias = original;            // copies the reference, not the array
        alias[0] = 99;                     // modify through one variable
        System.out.println("original[0] = " + original[0]);     // 99
        // Both variables point to the SAME array object, so a change made
        // through alias is visible through original.
    }
}

