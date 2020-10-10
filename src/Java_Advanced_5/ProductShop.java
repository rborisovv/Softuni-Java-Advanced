package Java_Advanced_5;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(", ");
        TreeMap<String, Map<String, Double>> productInformation = new TreeMap<>();
        while (!inputLine[0].equals("Revision")) {
            String shopName = inputLine[0];
            String productName = inputLine[1];
            Double productCost = Double.parseDouble(inputLine[2]);
            productInformation.putIfAbsent(shopName, new LinkedHashMap<>());
            productInformation.get(shopName).put(productName, productCost);
            inputLine = scanner.nextLine().split(", ");
        }
        productInformation
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}