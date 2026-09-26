package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    double[] transactions = new double[1000];
    int numOfTransactions = 0 ;

    public BankAccount(String name, int startingBalance){
        this.name= name ;
        this.currentBalance= startingBalance;
    }

    public void deposit(double amount){
        if (amount >0 ){
            this.currentBalance+=amount;
            transactions[numOfTransactions]= amount;
            System.out.println("Name: "+this.name+ " | Deposited amount: " + amount + " | New balance: " + this.currentBalance);
            numOfTransactions++;
        }else {
            System.out.println("Error : unsuccessful deposits. ");
        }

    }

    public void withdraw(double amount){
        if (amount >0 && amount <= this.currentBalance ){
            this.currentBalance-=amount;
            transactions[numOfTransactions]= -amount;
            System.out.println("Name: "+this.name+ " | Withdrawal amount: " + amount + " | New balance: " + this.currentBalance);
            numOfTransactions++;
        }else {
            System.out.println("Error : unsuccessful withdrawal. ");
        }
    }

    public void displayTransactions(){
        System.out.println("Transactions : ");
        for (double i: transactions){
            if (i>0){
                System.out.println("    Deposit : "+ i );
            }else if (i<0){
                System.out.println("    Withdrawal : "+(-1)* i );
            }else {
                break ;
            }
        }
    }

    public void displayBalance(){
        System.out.println("Balance : " + this.currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
