package Java_Advanced_6;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usernameInfo = new TreeMap<>();
        //username -> Map<IP,countOfCurrentIpLogs> ^
        while (!inputLine.equals("end")) {
            String ip = inputLine.split("\\s+")[0].split("=")[1];
            String username = inputLine.split("\\s+")[2].split("=")[1];
            usernameInfo.putIfAbsent(username, new LinkedHashMap<>());
            usernameInfo.get(username).putIfAbsent(ip, 0);
            Integer currentIpLogs = usernameInfo.get(username).get(ip);
            usernameInfo.get(username).put(ip, currentIpLogs + 1);
            inputLine = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> outerEntry : usernameInfo.entrySet()) {
            System.out.println(outerEntry.getKey() + ": ");
            Map<String, Integer> innerMap = outerEntry.getValue();
            int counter = innerMap.size();
            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                if (counter > 1) {
                    System.out.printf("%s => %d, ", innerEntry.getKey(), innerEntry.getValue());
                } else {
                    System.out.printf("%s => %d.%n", innerEntry.getKey(), innerEntry.getValue());
                }
                counter--;
            }
        }
    }
}