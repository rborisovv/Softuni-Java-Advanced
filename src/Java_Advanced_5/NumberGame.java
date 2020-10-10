package Java_Advanced_5;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameRounds = 50;
        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (int i = gameRounds; i > 0; i--) {
            Integer firstDeckCard = firstDeck.iterator().next();
            firstDeck.remove(firstDeckCard);
            Integer secondDeckCard = secondDeck.iterator().next();
            secondDeck.remove(secondDeckCard);
            if (firstDeckCard > secondDeckCard) {
                firstDeck.add(firstDeckCard);
                firstDeck.add(secondDeckCard);
            } else if (secondDeckCard > firstDeckCard) {
                secondDeck.add(firstDeckCard);
                secondDeck.add(secondDeckCard);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}