package Java_Advanced_6;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernameInfo = scanner.nextLine().split("-");
        HashMap<String, String> phoneBook = new HashMap<>();
        while (!usernameInfo[0].equals("search")) {
            String name = usernameInfo[0];
            String number = usernameInfo[1];
            phoneBook.putIfAbsent(name, "");
            phoneBook.put(name, number);
            usernameInfo = scanner.nextLine().split("-");
        }
        String searchForName = scanner.nextLine();
        while (!searchForName.equals("stop")) {
            if (phoneBook.containsKey(searchForName)) {
                System.out.printf("%s -> %s%n", searchForName, phoneBook.get(searchForName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchForName);
            }
            searchForName = scanner.nextLine();
        }
    }
}
