package CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> employees = new HashMap<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            employees.putIfAbsent(department, new Department(department));
            employees.get(department).getEmployees().add(employee);
        }
        Department maxAvgSalary = employees
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().avgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAvgSalary.getEmployeeName());
        maxAvgSalary.getEmployees()
                .stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getSalary(), e1.getSalary())).forEach(entry ->
                System.out.println(entry.toString()));
    }
}