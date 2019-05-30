/////////////////////////////////////////////
// File: Test.java (main)
// Author: Justin Casey
// Date: March 30, 2019
// Purpose: Employee salary calculations.
//          Displays various data points of
//          employees salary (commissions, bonuses)
//

package app;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {

    // Max number of employees per year
    final int EMPLOYEES_MAX = 10;

    /*
     * Create two Employee arrays to hold the list of employees
     * Create two counters to hold number of employees
     */
    Employee[] year2014 = new Employee[EMPLOYEES_MAX];
    Employee[] year2015 = new Employee[EMPLOYEES_MAX];
    int counter2014 = 0;
    int counter2015 = 0;

    /*
     * Opening a file to read in the information and creating
     * a scanner to read the contents of the file
     */
    File a = new File("/home/jcasey/projects/java/cmis242/project1/project1/src/app/data.txt");
    Scanner scanner = new Scanner(a);

    /*
     * While the scanner hasn't reached the end of the file
     * make a new employee obj of the correct type and add to
     * the correct array(depending on the year).
     */
    while (scanner.hasNext()) {
      int year = Integer.parseInt(scanner.next());
      String type = scanner.next();
      String name = scanner.next();
      int monthlySalary = Integer.parseInt(scanner.next());

      /*
       * Use a switch to create the correct type of employee
       * the default case will an executive assuming all input
       * is valid
       */
      Employee employee;
      switch (type) {
        case "Employee":
          employee = new Employee(name, monthlySalary);
          break;
        case "Salesman":
          int annualSales = Integer.parseInt(scanner.next());
          employee = new Salesman(name, monthlySalary, annualSales);
          break;
        default:
          int stockPrice = Integer.parseInt(scanner.next());
          employee = new Executive(name, monthlySalary, stockPrice);
          break;
      }

      // add employee object to correct array using a switch
      switch (year) {
        case 2014:
          year2014[counter2014++] = employee;
          break;
        case 2015:
          year2015[counter2015++] = employee;
          break;
      }
    }
    // close the scanner. Its no longer needed
    scanner.close();

    // Print out report for both years
    printReport(year2014, 2014, counter2014);
    printReport(year2015, 2015, counter2015);
  }

  private static void printReport(Employee[] employees, int year, int count) {

    // Report header
    System.out.println("****************************************");
    System.out.printf("****Employee stats for the year %d****\n", year);
    System.out.println("****************************************");

    // Handle is year is empty
    if (count <= 0){
      System.out.printf("\nNo stats for the year %d\n\n", year);
      System.out.println("****************************************\n");
      return;
    }

    // used to print in $00.00 format
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

    int averageEmployeeSalary = 0;
    for (int i = 0; i < count; i++) {
      System.out.println(employees[i].toString() +
          "  Annual Salary: " +
          format.format(employees[i].annualSalary()) + "\n");

      averageEmployeeSalary += employees[i].annualSalary();
    }

    System.out.printf(
        "\n****Avg Employee compensation for %d was %s ****\n\n",
        year, format.format(averageEmployeeSalary / count));
  }
}