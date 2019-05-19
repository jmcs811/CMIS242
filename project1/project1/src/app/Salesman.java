package app;

public class Salesman extends Employee {
    private int annualSales;
    private final double COMMISSION_RATE = 0.02;
    private final int COMMISSION_MAX = 20000;

    public Salesman(String name, int monthlySalary, int annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    @Override
    public int annualSalary() {
        return super.annualSalary() + totalCommission(this.annualSales) ;
    }

    private int totalCommission(int annualSales) {
        if (COMMISSION_RATE * annualSales > COMMISSION_MAX) {
            return COMMISSION_MAX;
        }
        return (int) (COMMISSION_RATE* annualSales);
    }

    @Override
    public String toString() {
        return (super.toString() + " Annual Sales: $" + annualSales);
    }

}