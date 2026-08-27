package Mutability.Challenge;

import java.util.ArrayList;
import java.util.List;

import Mutability.Challenge.BankAccount.AccountType;

public class BankCustomer {

  private final String name;
  private final int id;
  private List<BankAccount> accountList = new ArrayList<>();

  public BankCustomer(String name, int id, double checkingAmount, double savingAmount) {
    this.name = name;
    this.id = id;
    accountList.add(new BankAccount(AccountType.CHECKING, checkingAmount));
    accountList.add(new BankAccount(AccountType.SAVINGS, savingAmount));
  }

  public String getName() {return name;}
  public List<BankAccount> getAccountList() { return accountList;}

  @Override
  public String toString() {
    return "BankCustomer [name=" + name + ", id=" + id + ", accountList=" + accountList + "]";
  }
  
  
}
