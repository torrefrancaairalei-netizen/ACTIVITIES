package Week5;

public class ClassStatisticsCalculator {
    public static void main(String[] args) {
        int[] scores = {89, 92, 95, 90, 97, 88, 98, 93};

        int sum = 0;
        int highest = scores[0];  
        int lowest = scores[0];   

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];

            if (scores[i] > highest) {
                highest = scores[i];
            }

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        double average = (double) sum / scores.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);
    }
}
