package Java_Advanced_1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> documents = new ArrayDeque<>();
        while (!command.equals("print")) {
            if (!command.equals("cancel")) {
                documents.offer(command);
            } else {
                if (documents.isEmpty()) {
                    System.out.println("Printer is on standby");
                    command = scanner.nextLine();
                    continue;
                }
                System.out.println("Canceled " + documents.pop());
            }
            command = scanner.nextLine();
        }
        while (!documents.isEmpty()) {
            System.out.println(documents.pop());
        }
    }
}