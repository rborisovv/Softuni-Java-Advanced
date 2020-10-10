package Java_Advanced_2;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(";");
        String currentProduct = scanner.nextLine();
        int[] robotTimes = new int[inputLine.length];
        LinkedHashMap<String, Integer> robotsInfo = new LinkedHashMap<>();
        robotsInfoFill(inputLine, robotsInfo, robotTimes);
        while (!currentProduct.equals("End")) {

            currentProduct = scanner.nextLine();
        }
    }

    private static void robotsInfoFill(String[] inputLine, LinkedHashMap<String, Integer> robotsInfo, int[] robotTimes) {
        for (String currentInfo : inputLine) {
            String[] split = currentInfo.split("-");
            robotsInfo.put(split[0], Integer.valueOf(split[1]));
        }
        for (int i = 0; i < inputLine.length; i++) {
            String[] split = inputLine[i].split("-");
            robotTimes[i] = Integer.parseInt(split[1]);
        }
    }
}