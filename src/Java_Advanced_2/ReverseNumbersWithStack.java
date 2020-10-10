package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        for (String number : inputLine) {
            numbers.push(number);
        }
        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}