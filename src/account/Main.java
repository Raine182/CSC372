package account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Main {
    public static void selectionSort(ArrayList<Student> arr, Comparator<Student> comparator) {
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (comparator.compare(arr.get(j), arr.get(min_idx)) < 0)
                    min_idx = j;

            Collections.swap(arr, min_idx, i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(new Student(111, "Sherlock Holmes", "london"));
        arr.add(new Student(108, "John Watson", "london"));
        arr.add(new Student(131, "Peter Parker", "nyc"));
        arr.add(new Student(121, "Preta Kapur", "jaipur"));
        arr.add(new Student(153, "Miles Morales", "nyc"));
        arr.add(new Student(98, "Kamala Khan", "new jersey"));
        arr.add(new Student(101, "Ron Burgandy", "san diego"));
        arr.add(new Student(166, "Clark Kent", "kansas city"));
        arr.add(new Student(144, "Tony Stark", "malibu"));
        arr.add(new Student(100, "Carol Danvers", "beverly"));

        System.out.println("Unsorted");
        for (int i=0; i<arr.size(); i++)
            System.out.println(arr.get(i));

        selectionSort(arr, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<arr.size(); i++)
            System.out.println(arr.get(i));

        selectionSort(arr, new Sortbyname());

        System.out.println("\nSorted by name");
        for (int i=0; i<arr.size(); i++)
            System.out.println(arr.get(i));
    }
}