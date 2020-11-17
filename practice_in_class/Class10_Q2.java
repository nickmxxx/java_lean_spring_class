import java.util.ArrayList;
import java.util.Date;

public class Class10_Q2 {
    public static void main(String[] args) {
        Account account = new Account("George", 1122, 1000, 0.015);
        System.out.println("账户持有者：" + account.name + "\n账户利率：" + account.annualInterestRate);
        account.withDraw(30);
        account.withDraw(40);
        account.withDraw(50);
        account.deposit(5);
        account.deposit(4);
        account.deposit(2);
        System.out.println("交易流水：" + account.transactions);
    }
}

class Account {
    public String name;
    int id = 0;
    double balance = 0;
    double annualInterestRate = 0;
    Date dataCreated;
    ArrayList transactions = new ArrayList();

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public Account(String name, int id, double balance, double annualInterestRate) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void withDraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction('W', amount, getBalance()));
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, getBalance()));
    }
}

class Transaction {
    char type;
    double amount;
    double balance;
    String description;

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Transaction(char type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "type=" + type + ", amount=" + amount + ", balance=" + balance+", Date= "+new Date();
    }
}