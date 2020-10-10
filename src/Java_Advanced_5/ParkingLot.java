package Java_Advanced_5;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(", ");
        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();
        while (!data[0].equals("END")) {
            String way = data[0];
            String licensePlate = data[1];
            if (way.equals("IN")) {
                carNumbers.add(licensePlate);
            } else if (way.equals("OUT")) {
                carNumbers.remove(licensePlate);
            }
            data = scanner.nextLine().split(", ");
        }
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String carNumber : carNumbers) {
            System.out.println(carNumber);
        }
    }
}