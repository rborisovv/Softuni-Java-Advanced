package Java_Advanced_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\radko\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);
        FileOutputStream outputStream = new FileOutputStream(path);
        String table = ",.!?";
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (!table.contains(String.valueOf(currentChar))) {
                    System.out.print(currentChar);
                }
            }
        }
    }
}