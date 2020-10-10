package Java_Advanced_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        fillMatrix(matrix, scanner);
        int[] wrongInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int wrongNumber = matrix[wrongInput[0]][wrongInput[1]];
        List<int[]> wrongIndexes = new ArrayList<>();
        List<Integer> correctValues = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (wrongNumber == matrix[row][col]) {
                    wrongIndexes.add(new int[]{row, col});
                    correctValues.add(replaceWrongNumber(matrix, row, col, wrongNumber));
                }
            }
        }
        for (int i = 0; i < wrongIndexes.size(); i++) {
            int[] rowAndCol = wrongIndexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValues.get(i);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int replaceWrongNumber(int[][] matrix, int row, int col, int wrongNumber) {
        int sum = 0;
        if (isInBounds(matrix, row - 1, col) && wrongNumber != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row + 1, col) && wrongNumber != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row, col - 1) && wrongNumber != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(matrix, row, col + 1) && wrongNumber != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}