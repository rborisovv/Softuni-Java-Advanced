package Java_Advanced_3;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputMatrixInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = inputMatrixInfo[0];
        int cols = inputMatrixInfo[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        findBiggestSum(matrix);
    }

    private static void findBiggestSum(int[][] matrix) {
        int[] bestElements = new int[4];
        int bestSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestElements[0] = matrix[row][col];
                    bestElements[1] = matrix[row][col + 1];
                    bestElements[2] = matrix[row + 1][col];
                    bestElements[3] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int i = 0; i < bestElements.length; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(bestElements[i] + " ");
        }
        System.out.println();
        System.out.println(bestSum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}
