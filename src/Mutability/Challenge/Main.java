package Mutability.Challenge;

import Mutability.Challenge.BankAccount.AccountType;

public class Main {

  public static void main(String[] args) {
    
    BankAccount acc1 = new BankAccount(AccountType.CHECKING, 20.26);
    BankAccount acc2 = new BankAccount(AccountType.SAVINGS, 20.49);
    BankCustomer customer = new BankCustomer("Alan", 123456);
    customer.getAccountList().add(acc1);
    customer.getAccountList().add(acc2);
    System.out.println(customer);
  }
  
}
