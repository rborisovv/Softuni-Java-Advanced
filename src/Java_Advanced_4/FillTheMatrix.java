package Java_Advanced_4;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(inputLine[0]);
        String wayOfPrinting = inputLine[1];
        int[][] matrix = new int[rows][rows];
        if (wayOfPrinting.equals("A")) {
            matrixFillFirstCase(matrix);
        } else if (wayOfPrinting.equals("B")) {
            matrixFillSecondCase(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixFillSecondCase(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }


    private static void matrixFillFirstCase(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }
}