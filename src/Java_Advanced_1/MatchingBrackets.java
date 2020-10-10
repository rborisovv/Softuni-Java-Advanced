package Java_Advanced_1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                System.out.println(line.substring(stack.pop(), i + 1));
            }
        }
    }
}