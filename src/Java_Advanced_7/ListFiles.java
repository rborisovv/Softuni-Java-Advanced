package Java_Advanced_7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Objects;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        File[] folder = new File("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams")
                .listFiles();
        LinkedHashMap<String, Long> fileValues = new LinkedHashMap<>();
        for (File file : Objects.requireNonNull(folder)) {
            if (file.isFile()) {
                fileValues.putIfAbsent(file.getName(), 0L);
                Path path = Path.of(String.valueOf(file));
                long value = Files.size(path);
                fileValues.put(file.getName(), value);
            }
        }
        PrintWriter printWriter = new PrintWriter("output.txt");
        fileValues.forEach((key, value) -> printWriter.println
                (key + ": " + "[" +value + "]"));
        printWriter.close();
    }
}