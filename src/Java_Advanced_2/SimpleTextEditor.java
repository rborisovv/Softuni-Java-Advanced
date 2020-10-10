package Java_Advanced_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> text = new ArrayDeque<>();
        ArrayDeque<String> textHistory = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");
            switch (currentCommand[0]) {
                case "1":
                    for (int j = 0; j < currentCommand[1].length(); j++) {
                        text.offer(String.valueOf(currentCommand[1].charAt(j)));
                    }
                    addToTextHistory(textHistory, text);
                    break;
                case "2":
                    int numberOfIndexesToErase = Integer.parseInt(currentCommand[1]);
                    removeIndexesFromText(numberOfIndexesToErase, text);
                    addToTextHistory(textHistory, text);
                    break;
                case "3":
                    int elementToReturn = Integer.parseInt(currentCommand[1]);
                    returnElement(text, elementToReturn);
                    break;
                case "4":
                    if (!textHistory.isEmpty()) {
                        textHistory.pop();
                        String peek = textHistory.peek();
                        text.clear();
                        for (int j = 0; j < (peek != null ? peek.length() : 0); j++) {
                            text.offer(String.valueOf(peek.charAt(j)));
                        }
                    }
                    break;
            }
        }
    }

    private static void addToTextHistory(ArrayDeque<String> textHistory, ArrayDeque<String> text) {
        String tempHistoryString = String.valueOf(text).replaceAll("[\\[\\],\\s+]", "");
        textHistory.push(tempHistoryString);
    }

    private static void returnElement(ArrayDeque<String> text, int elementToReturn) {
        String tempTail = text.toString();
        tempTail = tempTail.replaceAll("[\\[\\],\\s+]", "");
        String letter = String.valueOf(tempTail.charAt(elementToReturn - 1));
        System.out.println(letter);
    }

    private static void removeIndexesFromText(int numberOfIndexesToErase, ArrayDeque<String> currentQueuedText) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> tempStack = new ArrayDeque<>();
        while (!currentQueuedText.isEmpty()) {
            stack.push(currentQueuedText.poll());
        }
        for (int i = 0; i < numberOfIndexesToErase; i++) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        currentQueuedText.clear();
        while (!tempStack.isEmpty()) {
            currentQueuedText.offer(tempStack.pop());
        }
    }
}