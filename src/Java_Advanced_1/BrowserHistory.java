package Java_Advanced_1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String line = scanner.nextLine();
        String currentUrl = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = history.pop();
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    history.push(currentUrl);
                }
                currentUrl = line;
            }
            line = scanner.nextLine();
            System.out.println(currentUrl);
        }
    }
}