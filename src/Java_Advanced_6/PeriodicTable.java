package Java_Advanced_6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] splitElements = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(splitElements));
        }
        for (String chemicalElement : chemicalElements) {
            System.out.print(chemicalElement + " ");
        }
    }
}
