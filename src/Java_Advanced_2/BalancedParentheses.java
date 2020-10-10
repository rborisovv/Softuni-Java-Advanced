package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        ArrayDeque<String> elements = new ArrayDeque<>();
        boolean isTrue = false;
        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == '(' || inputLine.charAt(i) == '['
                    || inputLine.charAt(i) == '{') {
                elements.push(String.valueOf(inputLine.charAt(i)));
            } else if (inputLine.charAt(i) == ')' || inputLine.charAt(i) == ']'
                    || inputLine.charAt(i) == '}') {
                if (elements.isEmpty()) {
                    isTrue = false;
                    break;
                }
                String lastSymbol = elements.pop();
                if (inputLine.charAt(i) == ')' && lastSymbol.equals("(")) {
                    isTrue = true;
                } else if (inputLine.charAt(i) == ']' && lastSymbol.equals("[")) {
                    isTrue = true;
                } else if (inputLine.charAt(i) == '}' && lastSymbol.equals("{")) {
                    isTrue = true;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}