package Java_Advanced_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CountCharacterTypes {
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> lines = bufferedReader.lines();
        String vowelsTable = "a e i o u";
        String punctuationTable = ",!.?";
        AtomicInteger vowelsCounter = new AtomicInteger();
        AtomicInteger consonantsCounter = new AtomicInteger();
        AtomicInteger punctuationCounter = new AtomicInteger();
        lines.map(String::toCharArray).forEach(line -> {
            for (char currentSymbol : line) {
                String symbol = String.valueOf(currentSymbol);
                if (currentSymbol != ' ') {
                    if (vowelsTable.contains(symbol)) {
                        vowelsCounter.getAndIncrement();
                    } else if (punctuationTable.contains(symbol)) {
                        punctuationCounter.getAndIncrement();
                    } else {
                        consonantsCounter.getAndIncrement();
                    }
                }
            }
        });
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println("Vowels: " + vowelsCounter);
        writer.println("Consonants: " + consonantsCounter);
        writer.println("Punctuation: " + punctuationCounter);
        writer.close();
    }
}
