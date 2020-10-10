package Java_Advanced_3;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixInputInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixInputInfo[0];
        int cols = matrixInputInfo[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        findSumOfMatrix(matrix, rows, cols);
    }

    private static void findSumOfMatrix(int[][] matrix, int rows, int cols) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int currentColElement : row) {
                sum += currentColElement;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}