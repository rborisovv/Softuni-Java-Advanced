package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> elements = new ArrayDeque<>();
        enqueueElements(Integer.parseInt(inputLine[0]), elements, scanner);
        dequeueElements(Integer.parseInt(inputLine[1]), elements);
        checkForElement(Integer.parseInt(inputLine[2]), elements);
    }

    private static void checkForElement(int numberToCheck, ArrayDeque<Integer> elements) {
        if (elements.isEmpty()) {
            System.out.println(0);
            return;
        }
        if (elements.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            findBiggestNumber(elements);
        }
    }

    private static void findBiggestNumber(ArrayDeque<Integer> elements) {
        int smallestNumber = Integer.MAX_VALUE;
        for (Integer element : elements) {
            if (element < smallestNumber) {
                smallestNumber = element;
            }
        }
        System.out.println(smallestNumber);
    }

    private static void dequeueElements(int numberOfElementsToDequeue, ArrayDeque<Integer> elements) {
        for (int i = 0; i < numberOfElementsToDequeue; i++) {
            elements.poll();
        }
    }

    private static void enqueueElements(int numberOfElementsToEnqueue, ArrayDeque<Integer> elements, Scanner scanner) {
        String[] elementsToEnqueue = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numberOfElementsToEnqueue; i++) {
            elements.offer(Integer.parseInt(elementsToEnqueue[i]));
        }
    }
}