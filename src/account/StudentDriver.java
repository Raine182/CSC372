package account;

import java.util.Scanner;

public class StudentDriver {
public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentList studentList = new StudentList();

            // Prompt user for student data
            while (true) {
                System.out.print("Enter student name (or 'quit' to finish): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("quit")) {
                    break;
                }

                System.out.print("Enter student address: ");
                String address = scanner.nextLine();

                double gpa;
                while (true) {
                    System.out.print("Enter GPA: ");
                    try {
                        gpa = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA. Please enter a valid numeric value.");
                    }
                }

                studentList.add(new StudentData(name, address, gpa));
            }

            // Sort the list by name
            studentList.sortByName();

            // Write student data to a text file
            studentList.saveToFile("student_data.txt");

            System.out.println("Student data processed successfully!");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}