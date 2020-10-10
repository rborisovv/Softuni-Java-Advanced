package Java_Advanced_6;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        LinkedHashMap<String, LinkedHashMap<String, Long>> statistics = new LinkedHashMap<>();
        while (!input[0].equals("report")) {
            String city = input[0];
            String country = input[1];
            Long population = Long.parseLong(input[2]);
            statistics.putIfAbsent(country, new LinkedHashMap<>());
            statistics.get(country).put(city, 0L);
            Long currentPopulation = statistics.get(country).get(city);
            statistics.get(country).put(city, currentPopulation + population);
            input = scanner.nextLine().split("\\|");
        }
        statistics
                .entrySet()
                .stream()
                .sorted((firstCountry, secondCountry) -> {
                    long firstInnerMapSum = 0;
                    long secondInnerMapSum = 0;
                    LinkedHashMap<String, Long> firstMapCities = firstCountry.getValue();
                    LinkedHashMap<String, Long> secondMapCities = secondCountry.getValue();
                    for (Long currentCityPopulation : firstMapCities.values()) {
                        firstInnerMapSum += currentCityPopulation;
                    }
                    for (Long currentCityPopulation : secondMapCities.values()) {
                        secondInnerMapSum += currentCityPopulation;
                    }

                    return Long.compare(secondInnerMapSum, firstInnerMapSum);
                }).forEach(entry -> {
            System.out.printf("%s (total population: %d)%n", entry.getKey(), getCountryPopulation(entry.getValue()));
            entry
                    .getValue()
                    .entrySet()
                    .stream()
                    .sorted((firstCity, secondCity) ->
                            secondCity.getValue().compareTo(firstCity.getValue())).forEach(innerEntry ->
                    System.out.println(String.format("=>%s: %d", innerEntry.getKey(), innerEntry.getValue())));
        });
    }

    private static long getCountryPopulation(LinkedHashMap<String, Long> innerMap) {
        long sum = 0;
        for (Long currentCityPopulation : innerMap.values()) {
            sum += currentCityPopulation;
        }
        return sum;
    }
}