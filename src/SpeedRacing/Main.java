package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInformation = scanner.nextLine().split("\\s+");
            String model = carInformation[0];
            int fuel = Integer.parseInt(carInformation[1]);
            double fuelCostForOneKm = Double.parseDouble(carInformation[2]);
            Car car = new Car(model, fuel, fuelCostForOneKm);
            cars.put(model, car);
        }
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            String model = command[1];
            int amountOfKms = Integer.parseInt(command[2]);
            Car carToDrive = cars.get(model);
            boolean isEnoughFuel = carToDrive.fuelCheck(amountOfKms);
            if (isEnoughFuel) {
                carToDrive.setFuel(amountOfKms);
                carToDrive.setDistanceTraveled(amountOfKms);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine().split("\\s+");
        }
        cars.forEach((key, value) -> System.out.println(value.toString()));
    }
}