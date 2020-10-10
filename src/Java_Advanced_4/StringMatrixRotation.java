package Java_Advanced_4;

import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angle = Integer.parseInt(scanner.nextLine()) % 360;
        System.out.println(angle);
    }
}
