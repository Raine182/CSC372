package account;
import java.util.Scanner;

public class RecursiveProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Please enter five numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        int product = calculateProduct(numbers, 0);
        System.out.println("The product of the five numbers is: " + product);
    }

    public static int calculateProduct(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        return numbers[index] * calculateProduct(numbers, index + 1);
    }
}
