package Java_Advanced_5;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsRecords = new TreeMap<>();
        for (int currentStudent = 0; currentStudent < numberOfStudents; currentStudent++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String name = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);
            studentsRecords.putIfAbsent(name, new LinkedList<>());
            List<Double> currentList = studentsRecords.get(name);
            currentList.add(grade);
            studentsRecords.put(name, currentList);
        }
        studentsRecords
                .forEach((key, value) -> System.out.printf("%s -> %s(avg: %.2f)%n", key, getGrades(value), getAverage(value)));
    }

    private static Object getGrades(List<Double> values) {
        StringBuilder sb = new StringBuilder();
        for (Double grade : values) {
            sb.append(grade).append(" ");
        }
        String[] arr = sb.toString().split("\\s+");
        sb.setLength(0);
        for (String element : arr) {
            String tmp = String.format("%.2f", Double.parseDouble(element));
            sb.append(tmp).append(" ");
        }
        return sb.toString();
    }

    private static double getAverage(List<Double> grades) {
        double averageSum = 0;
        for (Double grade : grades) {
            averageSum += grade;
        }
        averageSum = averageSum / grades.size();
        return averageSum;
    }
}