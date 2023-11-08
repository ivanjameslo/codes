import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        String accountNumber;
        String customerName;
        String phoneNumber;
        double startingBalance;
        double amountDeposit;
        double annualIR;
        double withdrawal;

        SavingsAccount sa = new SavingsAccount();

        accountNumber = scan.nextLine();
        customerName = scan.nextLine();
        phoneNumber = scan.nextLine();
        startingBalance = scan.nextDouble();
        amountDeposit = scan.nextDouble();
        annualIR = scan.nextDouble();
        withdrawal = scan.nextDouble();

        sa.deposit(amountDeposit, startingBalance);
        sa.withdraw(withdrawal);
        sa.calculateMonthlyInterest(annualIR);

        scan.close();
    }
}
