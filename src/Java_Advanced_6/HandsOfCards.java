package Java_Advanced_6;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, LinkedHashSet<String>> players = new LinkedHashMap<>();
        while (!inputLine.equals("JOKER")) {
            String name = inputLine.split(": ")[0];
            String[] cards = inputLine.split(": ")[1].split(", ");
            players.putIfAbsent(name, new LinkedHashSet<>());
            players.get(name).addAll(Arrays.asList(cards));
            inputLine = scanner.nextLine();
        }
        players
                .forEach((key, value) -> System.out.printf("%s: %d%n", key, sumPoints(value)));
    }

    private static int sumPoints(LinkedHashSet<String> cards) {
        int sum = 0;
        for (String card : cards) {
            if (card.contains("10")) {
                sum += 10 * getPoints().get(card.charAt(2));
                continue;
            }
            char firstSymbol = card.charAt(0);
            char secondSymbol = card.charAt(1);
            sum += getPoints().get(firstSymbol) * getPoints().get(secondSymbol);
        }
        return sum;
    }

    private static HashMap<Character, Integer> getPoints() {
        HashMap<Character, Integer> points = new HashMap<>();
        points.put('1' , 1);
        points.put('2' , 2);
        points.put('3' , 3);
        points.put('4' , 4);
        points.put('5' , 5);
        points.put('6' , 6);
        points.put('7' , 7);
        points.put('8' , 8);
        points.put('9' , 9);
        points.put('J' , 11);
        points.put('Q' , 12);
        points.put('K' , 13);
        points.put('S' , 4);
        points.put('H' , 3);
        points.put('D' , 2);
        points.put('C' , 1);
        points.put('A' , 14);
        return points;
    }
}
