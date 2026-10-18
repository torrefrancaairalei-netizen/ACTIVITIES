import java.util.Scanner;

public class PersonalProfilePrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter your height in meters: ");
        double height = input.nextDouble();

        System.out.print("Are you a student?: ");
        boolean isStudent = input.next().equalsIgnoreCase("yes");
        
        char initial = fullName.charAt(0); 

        System.out.println();
        System.out.println("=== Personal Profile ===");
        System.out.println("Full Name : " + fullName);
        System.out.println("Age       : " + age);
        System.out.println("Height    : " + height + " m");
        System.out.println("Initial   : " + initial);
        System.out.println("Student?  : " + isStudent);

        input.close();
    }
}
