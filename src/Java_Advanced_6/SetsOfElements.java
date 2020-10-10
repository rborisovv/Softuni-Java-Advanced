package Java_Advanced_6;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < arr[0]; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < arr[1]; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSet.retainAll(secondSet);
        for (Integer number : firstSet) {
            System.out.print(number + " ");
        }
    }
}