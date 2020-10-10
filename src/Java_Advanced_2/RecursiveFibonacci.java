package Java_Advanced_2;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        long[] currentData = new long[number + 1];
        System.out.println(fib(number, currentData));
    }

    private static long fib(int number, long[] currentData) {
        if (number <= 1) {
            return 1;
        }
        if (currentData[number] != 0) {
            return currentData[number];
        }
        return currentData[number] = fib(number - 1, currentData) + fib(number - 2, currentData);
    }
}