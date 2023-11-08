public class SavingsAccount{
    
    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private double savingBalance;
    private double annualIR;

    private double amountDeposit;

    public SavingsAccount(){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.savingBalance = savingBalance;
        this.annualIR = annualIR;
    }

    public void deposit(double amountDeposit, double startingBalance){
        this.amountDeposit = amountDeposit;
        this.savingBalance = startingBalance + amountDeposit;
        System.out.printf("Deposited %.2f", amountDeposit);
        System.out.printf(" new balance is %.2f \n", savingBalance );
    }

    public void withdraw(double withdrawal){
        if (this.savingBalance < withdrawal){
            System.out.printf("Insufficient funds, available balance is %.2f \n", amountDeposit);
        }
        else{
            this.savingBalance = savingBalance - withdrawal;
            System.out.printf("Withdrawed %.2f", withdrawal);
            System.out.printf(" new balance is %.2f \n", savingBalance);
        }
    }

    public void calculateMonthlyInterest(double annualIR){
        double monthlyInterest;
        monthlyInterest = (savingBalance * annualIR) / 12;
        this.savingBalance = savingBalance + monthlyInterest;
        System.out.printf("New balance after the interest rate is applied %.2f", savingBalance);
    }

}