package Week5;

public class ClassRankingSystem {
    public static void main(String[] args) {
        String[] names = {"John", "Kaith", "Gab", "Honey", "Jake"};
        int[][] rawQuizData = {
            {90, 85, 95, 80},   
            {78, 82, 88, 92},   
            {95, 90, 85, 90},   
            {85, 90, 80, 85},   
            {70, 75, 80, 65}    
        };

        Student[] students = new Student[names.length];
        for (int i = 0; i < names.length; i++) {
            students[i] = new Student(names[i], rawQuizData[i]);
        }

        sortByAverageDescending(students);
        assignRanks(students);

        printLeaderboard(students);

        System.out.println();
        System.out.println("Rank of Honey: " + linearSearchRank(students, "Honey"));
    }

    public static void sortByAverageDescending(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].average < students[j + 1].average) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void assignRanks(Student[] sorted) {
        for (int i = 0; i < sorted.length; i++) {
            if (i > 0 && Math.abs(sorted[i].average - sorted[i - 1].average) < 0.0001) {
                sorted[i].rank = sorted[i - 1].rank; 
            } else {
                sorted[i].rank = i + 1;              
            }
        }
    }

    public static int linearSearchRank(Student[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equals(name)) {
                return students[i].rank;
            }
        }
        return -1; 
    }

    public static void printLeaderboard(Student[] students) {
        System.out.println("=== Class Ranking Leaderboard ===");
        System.out.printf("%-6s%-10s%7s%n", "Rank", "Name", "Average");

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%-6d%-10s%7.2f%n",
                    students[i].rank, students[i].name, students[i].average);
        }
    }
}

class Student {
    String name;
    int[] quizzes;
    double average;
    int rank;

    Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
        this.average = computeAverage();
    }

    private double computeAverage() {
        int sum = 0;
        for (int i = 0; i < quizzes.length; i++) {
            sum += quizzes[i];
        }
        return (double) sum / quizzes.length;
    }
}
