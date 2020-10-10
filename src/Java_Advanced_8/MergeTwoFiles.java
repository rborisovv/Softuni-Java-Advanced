package Java_Advanced_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\radko\\Desktop\\04. " +
                "Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayDeque<String> queue = new ArrayDeque<>();
        bufferedReader.lines().forEach(queue::offer);
        fileReader = new FileReader("C:\\Users\\radko\\Desktop\\04. " +
                "Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        bufferedReader = new BufferedReader(fileReader);
        bufferedReader.lines().forEach(queue::offer);
        PrintWriter printWriter = new PrintWriter("output.txt");
        while (!queue.isEmpty()) {
            printWriter.println(queue.poll());
        }
        printWriter.close();
    }
}