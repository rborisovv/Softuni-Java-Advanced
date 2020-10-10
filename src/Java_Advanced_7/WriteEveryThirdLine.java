package Java_Advanced_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileReader fileReader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Stream<String> lines = bufferedReader.lines();
        PrintWriter printWriter = new PrintWriter("output.txt");
        final int[] counter = {1};
        lines.forEach(line -> {
            if (counter[0] % 3 == 0) {
                printWriter.println(line);
            }
            counter[0]++;
        });
        printWriter.close();
    }
}
