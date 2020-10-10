package Java_Advanced_5;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, String> studentInfo = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            double avgSum = 0;
            for (String grade : grades) {
                avgSum += Double.parseDouble(grade);
            }
            avgSum = avgSum / grades.length;
            DecimalFormat decimalFormat = new DecimalFormat("#.####################");
            String format = decimalFormat.format(avgSum);
            studentInfo.put(name, format);
        }
        studentInfo
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
                });
    }
}