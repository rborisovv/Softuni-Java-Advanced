package Java_Advanced_5;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        LinkedHashMap<Double, Integer> elements = new LinkedHashMap<>();
        for (double value : arr) {
            elements.putIfAbsent(value, 0);
            Integer curr = elements.get(value) + 1;
            elements.put(value, curr);
        }
        elements.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
