package app;

public class Salesman extends Employee {

  private int annualSales;
  private final double COMMISSION_RATE = 0.02;
  private final int COMMISSION_MAX = 20000;

  /*
   * Constructor takes in same args as the base class plus
   * an int for the annual sales
   */
  public Salesman(String name, int monthlySalary, int annualSales) {
    super(name, monthlySalary);
    this.annualSales = annualSales;
  }

  /*
   * Returns the value of the base class annualSalary method
   * plus the value of the totalCommission helper function
   */
  @Override
  public int annualSalary() {
    return super.annualSalary() + totalCommission(this.annualSales);
  }

  /*
   * Helper method to calculate if the commission cap
   * has been reached or not. If commission rate * sales
   * is greater the the cap, then return the cap
   */
  private int totalCommission(int annualSales) {
    if (COMMISSION_RATE * annualSales > COMMISSION_MAX) {
      return COMMISSION_MAX;
    }
    return (int) (COMMISSION_RATE * annualSales);
  }

  @Override
  public String toString() {
    String salesDollarFormat = currentFormat.format(annualSales);
    return (super.toString() + "  Annual Sales: " + salesDollarFormat);
  }
}