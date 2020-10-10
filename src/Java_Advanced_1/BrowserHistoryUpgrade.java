package Java_Advanced_1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayDeque<String> browserHistoryBackwardLinks = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForwardLinks = new ArrayDeque<>();
        String currentURL = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (browserHistoryBackwardLinks.isEmpty()) {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    browserHistoryForwardLinks.addFirst(currentURL);
                    currentURL = browserHistoryBackwardLinks.pop();
                }
            } else if (line.equals("forward")) {
                if (browserHistoryForwardLinks.isEmpty()) {
                    System.out.println("no next URLs");
                    browserHistoryForwardLinks.clear();
                    line = scanner.nextLine();
                    continue;
                } else {
                    currentURL = browserHistoryForwardLinks.poll();
                }
            } else {
                if (!currentURL.isEmpty()) {
                    browserHistoryBackwardLinks.push(currentURL);
                }
                currentURL = line;
            }
            System.out.println(currentURL);
            line = scanner.nextLine();
        }
    }
}
