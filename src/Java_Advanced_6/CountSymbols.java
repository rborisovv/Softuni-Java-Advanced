package Java_Advanced_6;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        String sentence = scanner.nextLine();
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            symbols.putIfAbsent(currentChar, 0);
            Integer currentValue = symbols.get(currentChar) + 1;
            symbols.put(currentChar, currentValue);
        }
        symbols
                .forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
