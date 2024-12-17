import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    // Constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        // Input student details
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter student " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student " + (i + 1) + " grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            students.add(new Student(name, grade));
        }

        // Calculate average, highest, and lowest grades
        int totalGrades = 0;
        int highestGrade = Integer.MIN_VALUE;
        int lowestGrade = Integer.MAX_VALUE;
        String highestStudent = "", lowestStudent = "";

        for (Student student : students) {
            totalGrades += student.grade;

            if (student.grade > highestGrade) {
                highestGrade = student.grade;
                highestStudent = student.name;
            }

            if (student.grade < lowestGrade) {
                lowestGrade = student.grade;
                lowestStudent = student.name;
            }
        }

        double averageGrade = (double) totalGrades / numberOfStudents;

        // Output results
        System.out.println("\n--- Student Grades ---");
        for (Student student : students) {
            System.out.println(student.name + ": " + student.grade);
        }

        System.out.printf("\nAverage Score: %.1f\n", averageGrade);
        System.out.println("Highest Score: " + highestGrade + " (" + highestStudent + ")");
        System.out.println("Lowest Score: " + lowestGrade + " (" + lowestStudent + ")");

        scanner.close();
    }
}
