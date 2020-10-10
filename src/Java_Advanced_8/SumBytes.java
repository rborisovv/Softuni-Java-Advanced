package Java_Advanced_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        AtomicLong sum = new AtomicLong();
        Stream<String> lines = bufferedReader.lines();
        lines.map(String::toCharArray).forEach(line -> {
            for (char currentSymbol : line) {
                sum.addAndGet(currentSymbol);
            }
        });
        FileWriter writer  = new FileWriter("output.txt");
        writer.write(String.valueOf(sum));
        writer.write(System.lineSeparator());
        writer.close();
    }
}
