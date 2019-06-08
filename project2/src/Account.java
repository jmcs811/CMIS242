public class Account {

  public double TRANSACTION_FEE = 1.50;

  public static int totalTransactions = 0;
  private double balance;


  public Account(int startingBalance) {
    this.balance = startingBalance;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
    this.balance = this.balance + amount;
  }

  public void withdraw(double amount) throws InsufficientFunds {
    if (this.balance - amount < 0) {
      throw new InsufficientFunds();
    }

    this.balance = this.balance - amount;
  }

  public void withdrawWithFee(double amount) throws InsufficientFunds {
    if (this.balance - amount - TRANSACTION_FEE < 0) {
      throw new InsufficientFunds();
    }
    this.balance = this.balance - amount - TRANSACTION_FEE;
  }

  public void transferTo(Account to, double amount) throws InsufficientFunds {
    this.withdraw(amount);
    to.deposit(amount);
  }
}
