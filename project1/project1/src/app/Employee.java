/////////////////////////////////////////////
// File: Employee.java (base class)
// Author: Justin Casey
// Date: March 30, 2019
// Purpose: Base class of employee. All
//          other employee classes will
//          inherit from this class
//

package app;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee {

  private String name;
  private int monthlySalary;
  private final int YEAR_OF_MONTHS = 12;

  // used for $00.00 format
  public static NumberFormat currentFormat = NumberFormat.getCurrencyInstance(Locale.US);

  /*
   * Constructor takes in a String for the name
   * and an int for the monthly salary
   */
  public Employee(String name, int monthlySalary) {
    this.name = name;
    this.monthlySalary = monthlySalary;
  }

  /*
   * Returns the annual salary (12 * monthlySalary)
   */
  public int annualSalary() {
    return monthlySalary * YEAR_OF_MONTHS;
  }

  public String toString() {
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
    String monthlySalaryDollarFormat = format.format(monthlySalary);
    return "Name: " + name + "  Monthly Salary: " + monthlySalaryDollarFormat;
  }
}