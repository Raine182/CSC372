package account;

import java.io.*;
import java.util.*;

public class StudentList {
    private List<StudentData> studentList = new LinkedList<>();

    public void add(StudentData student) {
        studentList.add(student);
    }

    public void sortByName() {
        studentList.sort(Comparator.comparing(StudentData::getName));
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (StudentData student : studentList) {
                writer.println(student);
            }
            System.out.println("Student data saved to " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
