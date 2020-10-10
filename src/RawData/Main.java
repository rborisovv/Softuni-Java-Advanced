package RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Engine> enginesMap = new LinkedHashMap<>();
        LinkedHashMap<String, Cargo> cargoesMap = new LinkedHashMap<>();
        LinkedHashMap<String, Tires> tiresMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carsInfo = scanner.nextLine().split("\\s+");
            String model = carsInfo[0];
            int engineSpeed = Integer.parseInt(carsInfo[1]);
            int enginePower = Integer.parseInt(carsInfo[2]);
            int cargoWeight = Integer.parseInt(carsInfo[3]);
            String cargoType = carsInfo[4];
            double firstTyrePressure = Double.parseDouble(carsInfo[5]);
            int firstTireAge = Integer.parseInt(carsInfo[6]);
            double secondTyrePressure = Double.parseDouble(carsInfo[7]);
            int secondTireAge = Integer.parseInt(carsInfo[8]);
            double thirdTyrePressure = Double.parseDouble(carsInfo[9]);
            int thirdTyreAge = Integer.parseInt(carsInfo[10]);
            double fourthTyrePressure = Double.parseDouble(carsInfo[11]);
            int fourthTireAge = Integer.parseInt(carsInfo[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(firstTyrePressure, firstTireAge,
                    secondTyrePressure, secondTireAge,
                    thirdTyrePressure, thirdTyreAge,
                    fourthTyrePressure, fourthTireAge);
            enginesMap.put(model, engine);
            cargoesMap.put(model, cargo);
            tiresMap.put(model, tires);
        }
        String typeOfCargo = scanner.nextLine();
        if (typeOfCargo.equals("fragile")) {
            //fragile" :
            // print all cars whose Cargo Type is -
            // - "fragile" with a tire whose pressure is  < 1
            for (Map.Entry<String, Cargo> entry : cargoesMap.entrySet()) {
                if (entry.getValue().getCargoType().equals("fragile")) {
                    int neededPressureLvl = 1;
                    Tires currentModel = tiresMap.get(entry.getKey());
                    if (currentModel.getFirstTirePressure() < neededPressureLvl
                            || currentModel.getSecondTirePressure() < neededPressureLvl ||
                            currentModel.getThirdTirePressure() < neededPressureLvl ||
                            currentModel.getFourthTirePressure() < neededPressureLvl) {
                        System.out.println(entry.getKey());
                    }
                }
            }
        } else if (typeOfCargo.equals("flamable")) {
            //flammable
            //print all cars whose Cargo Type is -
            //- "flammable" and have Engine Power > 250.
            for (Map.Entry<String, Cargo> entry : cargoesMap.entrySet()) {
                if (entry.getValue().getCargoType().equals("flamable")) {
                    Engine currentEngine = enginesMap.get(entry.getKey());
                    if (currentEngine.getEnginePower() > 250) {
                        System.out.println(entry.getKey());
                    }
                }
            }
        }
    }
}