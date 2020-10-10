package Java_Advanced_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        FileReader fileReader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] line = bufferedReader.readLine().split("\\s+");
        HashMap<String, Integer> counts = new HashMap<>();
        Arrays.stream(line).forEach(word -> counts.put(word, 0));
        Path textPath = Path.of("C:\\Users\\radko\\Desktop\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        fileReader = new FileReader(String.valueOf(textPath));
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine().split(", ");
        for (String textLine : line) {
            StringTokenizer stringTokenizer = new StringTokenizer(textLine, " ");
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                if (counts.containsKey(token)) {
                    Integer currentCount = counts.get(token);
                    counts.put(token, currentCount + 1);
                }
            }
        }
        PrintWriter printWriter = new PrintWriter("output.txt");
        counts.
                entrySet().
                stream().
                sorted((count1, count2) -> count2.getValue().compareTo(count1.getValue()))
                .forEach(word -> printWriter.println(word.getKey() + " - " + word.getValue()));
        printWriter.close();
    }
}