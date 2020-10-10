package Java_Advanced_4;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = inputLine[0];
        int cols = inputLine[1];
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            if (isValidCommand(command, rows, cols)) {
                String tmp = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
                matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] =
                        matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];
                matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = tmp;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine().split("\\s+");
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String[] command, int rows, int cols) {
        return command[0].equals("swap") && command.length - 1 == 4 &&
                Integer.parseInt(command[1]) >= 0 && Integer.parseInt(command[1]) < rows
                && Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) < cols
                && Integer.parseInt(command[3]) >= 0 && Integer.parseInt(command[3]) < rows
                && Integer.parseInt(command[4]) >= 0 && Integer.parseInt(command[4]) < cols;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}