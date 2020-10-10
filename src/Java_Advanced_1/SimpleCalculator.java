package Java_Advanced_1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        Collections.addAll(numbers, firstLine);
        int result = 0;
        while (numbers.size() > 1) {
            int firstNumber = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int secondNumber = Integer.parseInt(numbers.pop());
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
            }
            numbers.push(String.valueOf(result));
        }
        System.out.println(numbers.pop());
    }
}