package Java_Advanced_7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\radko\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter("integers.txt");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.flush();
        writer.close();
    }
}
