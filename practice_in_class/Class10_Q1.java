import java.util.Date;

public class Class10_Q1 {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dataCreated;

    public Class10_Q1() {
        super();
        this.dataCreated = new Date();
    }

    public Class10_Q1(int id, double balance) {
        super();
        this.id = id;
        this.balance = balance;
        this.dataCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCrDate() {
        return dataCreated;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInteresRate() throws Exception {
        if (this.annualInterestRate == 0) {
            throw new Exception("未设置利息");
        } else {
            return annualInterestRate / 12;
        }
    }
    public double getMonthlyInteres(){
        double interest = this.balance*this.annualInterestRate/12;
        return interest;
    }
    public void withDraw(double MoneyNum) throws Exception {
        if (MoneyNum > this.balance) {
            throw new Exception("余额不足");
        } else {
            this.balance -= MoneyNum;
        }
    }

    public void desposit(double MoneyNum) {
        this.balance += MoneyNum;
    }

    public static void main(String[] args) throws Exception {
        Class10_Q1 myAccount = new Class10_Q1(1122, 20000);
        myAccount.setAnnualInterestRate(0.045);
        myAccount.withDraw(2500);
        myAccount.desposit(3000);
        System.out.println("余额：" + myAccount.getBalance());
        System.out.println("月利息：" + myAccount.getMonthlyInteres());
        System.out.println("开户日期：" + myAccount.getDateCrDate());
    }
}