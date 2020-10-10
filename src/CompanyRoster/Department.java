package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String employeeName;
    private List<Employee> employees;

    public Department(String employeeName) {
        this.employeeName = employeeName;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double avgSalary() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public String getEmployeeName() {
        return this.employeeName;
    }
}