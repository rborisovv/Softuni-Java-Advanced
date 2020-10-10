package Java_Advanced_8;

import java.io.*;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        FileReader fileReader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Stream<String> lines = bufferedReader.lines();
        PrintWriter fileWriter = new PrintWriter("output.txt");
        AtomicInteger counter = new AtomicInteger(1);
        lines.forEach(line -> {
            fileWriter.println(counter.getAndIncrement() + "." + " " + line);
        });
        fileWriter.close();
    }
}
