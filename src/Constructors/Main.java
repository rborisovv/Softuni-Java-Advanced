package Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Constructors constructors;
        while (numberOfCars-- != 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 1) {
                constructors = new Constructors(tokens[0]);
            } else if (tokens.length == 2) {
                constructors = new Constructors(tokens[0], tokens[1]);
            } else {
                constructors =
                        new Constructors(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            System.out.println(constructors.getCar());
        }
    }
}