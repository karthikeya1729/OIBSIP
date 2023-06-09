package my;

import java.util.*;

public class ATM {
    Scanner sc=new Scanner(System.in);
    int pin=1234;
    float SavingsBalance=100000;
    float CurrentBalance=100000;
    /**Transaction details Stored in list named TransactionDetails
     *
     */
    ArrayList<Integer> SavingsTransactionDetails=new ArrayList<>();
    ArrayList<Integer> CurrentTransactionDetails=new ArrayList<>();

    public void checkpin(){
        System.out.println("____Please Enter your PIN_____");
        int enteredPin=sc.nextInt();
        if(enteredPin==pin){
            System.out.println("____WELCOME_____");
            Menu();
        }
        else{
            System.out.println("_____Incorrect Pin !!_____");
        }
    }
    public void Menu(){
        System.out.println("_____Enter-1 for Transaction History_____");
        System.out.println("_____Enter-2 for Withdrawal_____");
        System.out.println("_____Enter-3 for Deposit______");
        System.out.println("_____Enter-4 for Transfer fund_______");
        System.out.println("_____Enter-5 for Check Balance______");
        System.out.println("_____Enter-6 for Change Pin _____");
        System.out.println("_____Enter-7 for Quit______");
        int option=sc.nextInt();

        switch(option){
            case 1:
                TransactionHistory();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                TranserFund();
                break;
            case 5:
                checkBalance();
                break;
            case 6:
                ChangePin();
                break;
            case 7:
                Exit();
                break;
            default:
                System.out.println("Please Enter Correct Option");
                Menu();
        }
    }
    private void ChangePin() {
        System.out.println("_____Please Enter your current PIN_____");
        int enteredP=sc.nextInt();
        if(enteredP==pin){
            System.out.println("_____Enter new PIN_____");
            int pin=sc.nextInt();
            System.out.println("PIN sucessfully changed");
            Menu();
        }
        else{
            System.out.println("______INVALID PIN_______");
            Menu();
        }

    }
    private void Exit() {
        checkpin();
    }
    private void checkBalance() {
        System.out.println("Choose Account Type");
        System.out.println("Enter 1: Savings Account");
        System.out.println("Enter 2 :Current Account");
        int option3=sc.nextInt();
        if(option3==1){
            System.out.println(SavingsBalance);
        }
        else if(option3==2){
            System.out.println(CurrentBalance);
        }
        else{
            System.out.println("Enter cohttps://2387-61-1-174-106.in.ngrok.io/rrect Option");
            checkBalance();
        }
    }
    private void TranserFund() {
        System.out.println("Choose Account Type");
        System.out.println("Enter 1: Savings Account");
        System.out.println("Enter 2 :Current Account");
        int option4=sc.nextInt();
        if(option4==1){
            System.out.println("Your Savings Balance" + SavingsBalance);
            System.out.println("Enter Account details of receiver");
            System.out.println("Enter Account Number");
            int AccountNumber=sc.nextInt();
            System.out.println("Enter IFSC Code");
            int IFSCcode=sc.nextInt();
            System.out.println("Enter Amount");
            int Amount=sc.nextInt();
            if(Amount<SavingsBalance){
                System.out.println("Fund Transfer Succesfully");
                SavingsBalance-=Amount;
            }
            else{
                System.out.println("Insufficient Funds");
            }
        }
        else if(option4==2){
            System.out.println("Your Current Account Balance" + CurrentBalance);
            System.out.println("Enter Account details of receiver");
            System.out.println("Enter Account Number");
            int AccountNumber=sc.nextInt();
            System.out.println("Enter IFSC Code");
            int IFSCcode=sc.nextInt();
            System.out.println("Enter Amount");
            int Amount=sc.nextInt();
            if(Amount<CurrentBalance){
                System.out.println("Fund Transfer Succesfully");
                CurrentBalance-=Amount;
            }
            else{
                System.out.println("Insufficient Funds");
            }
        }
        else{
            System.out.println("Enter correct Option");
            TranserFund();
        }
    }
    private void withdraw() {
        System.out.println("Please Choose Account Type");
        System.out.println("Enter 1: Savings Account");
        System.out.println("Enter 2: Current Account");
        int option3=sc.nextInt();
        if(option3==1){
            System.out.println("Please Enter Amount");
            int amount=sc.nextInt();
            if(amount<SavingsBalance){
                 System.out.println("Collect Your Cash");
                 SavingsTransactionDetails.add(-amount);
                 SavingsBalance-=amount;
                 Menu();}
            else{
                System.out.println("Insufficient Funds");
                Exit();
            }
        }
        else if(option3==2){
            System.out.println("Please Enter Amount");
            int amount=sc.nextInt();
            if(amount<CurrentBalance){
                System.out.println("Collect Your Cash");
                CurrentBalance-=amount;
                CurrentTransactionDetails.add(-amount);
                Menu();
            }
            else{
                System.out.println("Insufficient Funds");
                Exit();
            }
        }
        else{
            System.out.println("Choose correct Account Type");
            withdraw();
        }

    }
    private void deposit() {
        System.out.println("Please Choose Account Type");
        System.out.println("Enter 1: Savings Account");
        System.out.println("Enter 2: Current Account");
        int option2=sc.nextInt();
        if(option2==1){
            System.out.println("Please Enter Amount");
            int amount=sc.nextInt();
            SavingsBalance+=amount;
            System.out.println("Amount Deposited Sucessfully");
            SavingsTransactionDetails.add(amount);
            Menu();
        }
        else if(option2==2){
            System.out.println("Please Enter Amount");
            int amount=sc.nextInt();
            CurrentBalance+=amount;
            System.out.println("Amount Deposited Sucessfully");
            CurrentTransactionDetails.add(amount);
            Menu();
        }
        else{
            System.out.println("Choose correct Account Type");
            withdraw();
        }
        
    }
    private void TransactionHistory() {
        System.out.println("Choose account type");
        System.out.println("Enter 1: Savings Account");
        System.out.println("Enter 2: Current Account");
        int option2=sc.nextInt();
        if(option2==1){
            System.out.println(SavingsTransactionDetails);
            Menu();
        }
        else if(option2==2){
            System.out.println(CurrentTransactionDetails);
          
        }
        else{
            System.out.println("Choose correct Account Type");
            TransactionHistory();
        }

        Menu();
    }
}
