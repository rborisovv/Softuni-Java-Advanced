package Java_Advanced_3;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] firstMatrix = fillMatrices(scanner, rows, cols);
        char[][] secondMatrix = fillMatrices(scanner, rows, cols);
        resultedMatrix(firstMatrix, secondMatrix);

    }

    private static void resultedMatrix(char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print((firstMatrix[row][col] = firstMatrix[row][col]) + " ");
                } else {
                    System.out.print(('*') + " ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrices(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] inputForArray = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputForArray[col].charAt(0);
            }
        }
        return matrix;
    }
}