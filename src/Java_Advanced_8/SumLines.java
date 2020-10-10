package Java_Advanced_8;

import java.io.*;
import java.util.stream.Stream;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(line -> {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                sum += currentSymbol;
            }
            System.out.println(sum);
        });
    }
}
