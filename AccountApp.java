
public class AccountApp {
  public static void main (String[] args) {
    Account.setAnnualInterestRate(5.5);

    //Write a test program that creates an Account with annual interest rate 1.5%, balance 1000, id 1122, and name George
    Account account = new Account("George", 1122, 1000);
    
    //Deposit $30, $40, and $50 to the account and withdraw $5, $4, and $2 from the account.
    account.deposit(30);
    account.deposit(40);
    account.deposit(50);
    
    account.withdraw(5);
    account.withdraw(4);
    account.withdraw(2);
    
    //Print an account summary that shows account holder name, interest rate, balance, and all transactions.
    System.out.println("Name: " + account.getName());
    System.out.println("Annual interest rate: " + Account.getAnnualInterestRate());
    System.out.println("Balance: " + account.getBalance());
    
    java.util.ArrayList list = account.getTransactions();
    
    System.out.printf("%-35s%-15s%-15s%-15s\n", "Date", "Type", "Amount", "Balance");
    
    for (int i = 0; i < list.size(); i++) {
      Transaction transaction = (Transaction)(list.get(i));
      System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), 
          transaction.getType(), transaction.getAmount(), transaction.getBalance());
    }
  }
}


class Account {
  private int id;

  //Add a new data field name of the String type to store the name of the customer.
  private String name;
  private double balance;
  private static double annualInterestRate;
  private java.util.Date dateCreated;
  
  //Add a new data field named transactions whose type is ArrayList that stores the transaction for the accounts. Each transaction is an instance of the Transaction class. 
  private java.util.ArrayList transactions = new java.util.ArrayList();

  public Account() {
    dateCreated = new java.util.Date();
  }

  public Account(String name, int id, double balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
    dateCreated = new java.util.Date();
  }
  
  public int getId() {
    return this.id;
  }

  public double getBalance() {
    return balance;
  }

  public java.util.ArrayList getTransactions() {
    return transactions;
  }

  public String getName() {
    return name;
  }
  
  public static double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public void setId(int id) {
    this.id =id;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public static void setAnnualInterestRate(double annualInterestRate) {
    Account.annualInterestRate = annualInterestRate;
  }

  public double getMonthlyInterest() {
    return balance * (annualInterestRate / 1200);
  }

  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  //Modify the withdraw and deposit methods to add a transaction to the transactions array list.
  public void withdraw(double amount) {
    balance -= amount;
    transactions.add(new Transaction('W', amount, balance, ""));
  }

  public void deposit(double amount) {
    balance += amount;
    transactions.add(new Transaction('D', amount, balance, ""));
  }
}

class Transaction {
  private java.util.Date date;
  private char type;
  private double amount;
  private double balance;
  private String description;
  
  public Transaction(char type, double amount, double balance,
      String description) {
    date = new java.util.Date();
    this.type = type;
    this.amount = amount;
    this.balance = balance;
    this.description = description;
  }

  public java.util.Date getDate() {
    return date;
  }
  
  public char getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }
  
  public double getBalance() {
    return balance;
  }
  
  public String getDescription() {
    return description;
  }
}
