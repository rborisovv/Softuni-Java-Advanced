package Java_Advanced_6;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        int counter = 1;
        String lastResource = "";
        while (!inputLine.equals("stop")) {
            if (counter % 2 != 0) {
                resources.putIfAbsent(inputLine, 0);
                lastResource = inputLine;
            } else {
                Integer currentResourceValue = resources.get(lastResource);
                resources.put(lastResource, currentResourceValue + Integer.parseInt(inputLine));
            }
            counter++;
            inputLine = scanner.nextLine();
        }
        resources
                .forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}