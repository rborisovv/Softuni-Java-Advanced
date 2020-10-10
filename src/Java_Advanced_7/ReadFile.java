package Java_Advanced_7;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int currentByte = inputStream.read();
        while (currentByte != -1) {
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }

    }
}