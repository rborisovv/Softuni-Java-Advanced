package Java_Advanced_5;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Map<String, List<String>>> continentsInformation = new LinkedHashMap<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            String continent = currentLine[0];
            String country = currentLine[1];
            String city = currentLine[2];
            continentsInformation.putIfAbsent(continent, new LinkedHashMap<>());
            continentsInformation.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsInformation.get(continent).get(country).add(city);
        }
        continentsInformation
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.print(String.format("  %s -> %s%n", innerEntry.getKey(),
                                        innerEntry.getValue())
                                        .replaceAll("[\\[\\]]", ""));
                            });
                });
    }
}