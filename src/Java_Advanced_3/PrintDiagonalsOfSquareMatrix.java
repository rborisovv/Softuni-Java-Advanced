package Java_Advanced_3;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[inputNumber][inputNumber];
        fillMatrix(matrix, scanner);
        findDiagonals(matrix);
    }

    private static void findDiagonals(int[][] matrix) {
        //first Diagonal
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
        //secondDiagonal
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
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