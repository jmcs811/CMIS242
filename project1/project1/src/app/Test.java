package app;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        
        final int EMPLOYEES_MAX = 10;

        Employee[] year2014 = new Employee[EMPLOYEES_MAX];
        Employee[] year2015 = new Employee[EMPLOYEES_MAX];
        int counter2014 = 0;
        int counter2015 = 0;

        File a = new File("/home/jcasey/projects/java/cmis140/project1/project1/src/app/data.txt");
        Scanner scanner = new Scanner(a);

        while(scanner.hasNext()) {
            int year = Integer.parseInt(scanner.next());
            String type = scanner.next();
            String name = scanner.next();
            int monthlySalary = Integer.parseInt(scanner.next());

            Employee employee = null;
            switch(type) {
                case "Employee":
                    employee = new Employee(name, monthlySalary);
                    break;
                case "Salseman":
                    int annualSales = Integer.parseInt(scanner.next());
                    employee = new Salesman(name, monthlySalary, annualSales);
                    break;
                default:
                    int stockPrice = Integer.parseInt(scanner.next());
                    employee = new Executive(name, monthlySalary, stockPrice);
                    break;
            }

            switch(year) {
                case 2014:
                    year2014[counter2014++] = employee;
                    break;
                default:
                    year2015[counter2015++] = employee;
                    break;
            }
        }
        scanner.close();

        printReport(year2014, 2014, counter2014);
        printReport(year2015, 2015, counter2015);
    }

    private static void printReport(Employee[] employees, int year, int count) {
        System.out.println("****************************************");
        System.out.printf("****Employee stats for the year %d****\n", year);
        System.out.println("****************************************");

        int totalEmployeeSalary = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].toString());
            totalEmployeeSalary += employees[i].annualSalary();
        }

        System.out.printf("\n****Total Employee compensation for %d was %d****\n\n", year, totalEmployeeSalary);
    }
}