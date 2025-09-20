import java.util.Scanner;

class Student {
    String rollNo;
    String name;
    String course;
    double marks;
    String grade;

    Scanner sc = new Scanner(System.in);

    public void inputStudent() {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Course: ");
        course = sc.nextLine();
        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        sc.nextLine();  // consume leftover newline
        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 50) grade = "D";
        else grade = "F";
    }

    public void displayStudent() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }
}

class StudentManagementSystem {
    Student[] students;
    int studentCount;

    public void initializeSystem(int size) {
        students = new Student[size];
        studentCount = 0;
    }

    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. The system is full!");
            return;
        }
        Student s = new Student();
        s.inputStudent();
        students[studentCount] = s;
        studentCount++;
        System.out.println("Student added successfully!\n");
    }

    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records available!\n");
            return;
        }
        System.out.println("======= Student Records =======");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.print("Enter the maximum number of students: ");
        int size = sc.nextInt();
        sc.nextLine();  // consume newline

        sms.initializeSystem(size);

        int choice;
        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
