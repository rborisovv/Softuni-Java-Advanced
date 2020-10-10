package Java_Advanced_8;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Stream;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> lines = bufferedReader.lines();
        PrintWriter writer = new PrintWriter("output.txt");
        lines.map(String::toUpperCase).forEach(writer::println);
        writer.close();
    }
}
