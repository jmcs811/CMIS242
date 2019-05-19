package app;

public class Executive extends Employee {

    private int stockPrice;
    private final int BONUS_MAX = 30000;
    private final int STOCK_PRICE_MIN = 50;

    public Executive(String name, int monthlySalary, int stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = stockPrice;
    }

    @Override
    public int annualSalary() {
        if (stockPrice > STOCK_PRICE_MIN) {
            return super.annualSalary() + BONUS_MAX;
        }
        return super.annualSalary();
    }

    public String toString() {
        return (super.toString()+ " Stock Price: $" + stockPrice);
    }
}