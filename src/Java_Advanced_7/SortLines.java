package Java_Advanced_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        Files.write(Paths.get("output.txt"), lines);
    }
}
