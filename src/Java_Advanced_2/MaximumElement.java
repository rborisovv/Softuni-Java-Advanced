package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> elements = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    int element = Integer.parseInt(command[1]);
                    elements.push(element);
                    break;
                case "2":
                    if (!elements.isEmpty()) {
                        elements.pop();
                    }
                    break;
                case "3":
                    largestNumberCheck(elements);
                    break;
            }
        }
    }

    private static void largestNumberCheck(ArrayDeque<Integer> elements) {
        int currentMaximum = Integer.MIN_VALUE;
        for (Integer element : elements) {
            if (element > currentMaximum) {
                currentMaximum = element;
            }
        }
        System.out.println(currentMaximum);
    }
}