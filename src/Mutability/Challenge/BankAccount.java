package Mutability.Challenge;

public class BankAccount {

  public enum AccountType {CHECKING, SAVINGS};
  private final AccountType accType;
  private double balance;

  protected BankAccount(AccountType accType, double balance) {
    this.accType = accType;
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "BankAccount [accType=" + accType + ", balance=" + balance + "]";
  }

  



  
}
