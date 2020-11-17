@startuml
class Account {
    - int id = 0;
    - double balance = 0;
    - double annualInterestRate = 0;
    - Date dataCreated;

    +Account()
    +Account(int id, double balance)
    +int getId()
    +double getBalance()
    +void setBalance(double balance)
    +double getAnnualInterestRate()
    +Date getDateCrDate()
    +void setAnnualInterestRate(double annualInterestRate)
    +double getMonthlyInteresRate()
    +double getMonthlyInteres()
    +void withDraw(double MoneyNum)
    +void desposit(double MoneyNum)
    
@enduml