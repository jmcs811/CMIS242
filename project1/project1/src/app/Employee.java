package app;

public class Employee {
    private String name;
    private int monthlySalary;
    private final int YEAR_OF_MONTHS = 12;

    public Employee(String name, int monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public int annualSalary() {
        return monthlySalary * YEAR_OF_MONTHS;
    }

    public String toString() {
        return "Name: " + name + " Salary: $" + monthlySalary;
    }
}