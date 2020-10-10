package Java_Advanced_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\radko\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int currentByte = inputStream.read();
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        while (currentByte != -1) {
            if (currentByte == ' ' || currentByte == '\n') {
                outputStream.write(currentByte);
            } else {
                outputStream.write(String.valueOf(currentByte).getBytes());
            }
            currentByte = inputStream.read();
        }
        outputStream.close();
    }
}