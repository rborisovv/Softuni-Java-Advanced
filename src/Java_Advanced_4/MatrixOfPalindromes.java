package Java_Advanced_4;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix) {
        char startingChar = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(Character.toString(startingChar) + (char) (startingChar + col)
                        + (startingChar) + " ");
            }
            startingChar++;
            System.out.println();
        }
    }
}