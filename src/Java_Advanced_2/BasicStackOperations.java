package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> elements = new ArrayDeque<>();
        addElementsToStack(Integer.parseInt(inputLine[0]), elements, scanner);
        removeElements(Integer.parseInt(inputLine[1]), elements);
        elementCheck(Integer.parseInt(inputLine[2]), elements);
    }

    private static void elementCheck(int checkForNumber, ArrayDeque<Integer> elements) {
        if (elements.contains(checkForNumber)) {
            System.out.println("true");
        } else {
            if (elements.isEmpty()) {
                System.out.println(0);
                return;
            }
            checkForSmallestNumber(elements);
        }
    }

    private static void checkForSmallestNumber(ArrayDeque<Integer> elements) {
        int currentSmallest = Integer.MAX_VALUE;
        while (!elements.isEmpty()) {
            int currentElement = elements.pop();
            if (currentElement < currentSmallest) {
                currentSmallest = currentElement;
            }
        }
        System.out.println(currentSmallest);
    }

    private static void removeElements(int removedElementsCount, ArrayDeque<Integer> elements) {
        for (int i = 0; i < removedElementsCount; i++) {
            elements.pop();
        }
    }

    private static void addElementsToStack(int numberOfElements, ArrayDeque<Integer> elements, Scanner scanner) {
        String[] elementsToPush = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numberOfElements; i++) {
            elements.push(Integer.valueOf(elementsToPush[i]));
        }
    }
}