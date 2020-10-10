package Java_Advanced_4;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputLineInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = inputLineInfo[0];
        int cols = inputLineInfo[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        int[] biggestValues = new int[2];
        findSum(matrix, biggestValues);
    }

    private static void findSum(int[][] matrix, int[] biggestValues) {
        int maximumSum = Integer.MIN_VALUE;
        biggestValues = new int[2];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maximumSum) {
                    maximumSum = sum;
                    biggestValues[0] = row;
                    biggestValues[1] = col;
                }
            }
        }
        System.out.println("Sum = " + maximumSum);
        for (int row = biggestValues[0]; row <= biggestValues[0] + 2; row++) {
            for (int col = biggestValues[1]; col <= biggestValues[1] + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}