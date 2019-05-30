package app;

public class Executive extends Employee {

  private int stockPrice;
  private final int BONUS_MAX = 30000;
  private final int STOCK_PRICE_MIN = 50;  // minimum to receive the bonus

  /*
   * Constructor takes in same args as base class
   * plus an int for the stock price
   */
  public Executive(String name, int monthlySalary, int stockPrice) {
    super(name, monthlySalary);
    this.stockPrice = stockPrice;
  }

  /*
   * if stock price is greater then the min stock
   * price then return the annual salary plus the bonus
   * else just return the annual salary (no bonus)
   */
  @Override
  public int annualSalary() {
    if (stockPrice > STOCK_PRICE_MIN) {
      return super.annualSalary() + BONUS_MAX;
    }
    return super.annualSalary();
  }

  public String toString() {
    String stockDollarFormat = currentFormat.format(stockPrice);
    return (super.toString() + "  Stock Price: " + stockDollarFormat);
  }
}