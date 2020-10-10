package Java_Advanced_4;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][rows];
        fillMatrix(matrix, scanner);
        int sumOfFirstDiagonal = findFirstDiagonal(matrix);
        int sumOfSecondDiagonal = findSecondDiagonal(matrix);
        System.out.println(Math.abs(sumOfFirstDiagonal - sumOfSecondDiagonal));

    }

    private static int findSecondDiagonal(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sum += matrix[row][col];
            col++;
        }
        return sum;
    }

    private static int findFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}