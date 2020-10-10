package Java_Advanced_6;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInfo = scanner.nextLine();
        LinkedHashMap<String, String> usernameInfo = new LinkedHashMap<>();
        int counter = 1;
        String lastRecordedUsername = "";
        while (!userInfo.equals("stop")) {
            if (counter % 2 != 0) {
                usernameInfo.put(userInfo, "");
                lastRecordedUsername = userInfo;
            } else {
                if (userInfo.contains(".us") || userInfo.contains(".uk") || userInfo.contains(".com")) {
                    usernameInfo.remove(lastRecordedUsername);
                } else {
                    usernameInfo.put(lastRecordedUsername, userInfo);
                }
            }
            counter++;
            userInfo = scanner.nextLine();
        }
        usernameInfo.forEach((user, email) -> System.out.printf("%s -> %s%n", user, email));
    }
}