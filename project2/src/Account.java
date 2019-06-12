class Account {

  private double TRANSACTION_FEE = 1.50;

  int totalTransactions = 0;
  private double balance;


  Account(int startingBalance) {
    this.balance = startingBalance;
  }

  double getBalance() {
    return balance;
  }

  void deposit(double amount) {
    this.balance = this.balance + amount;
  }

  void withdraw(double amount) throws InsufficientFunds {
    if (this.balance - amount < 0) {
      throw new InsufficientFunds();
    }
    this.balance = this.balance - amount;
    totalTransactions++;
  }

  void withdrawWithFee(double amount) throws InsufficientFunds {
    if (this.balance - amount - TRANSACTION_FEE < 0) {
      throw new InsufficientFunds();
    }
    this.balance = this.balance - amount - TRANSACTION_FEE;
  }

  void transferTo(Account to, double amount) throws InsufficientFunds {
    this.withdraw(amount);
    to.deposit(amount);
  }
}
