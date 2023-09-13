
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

class ATMinterface{

    private double balance;
    private double depositAmount;
    private double withdrawAmount;
    private double transfer;
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public double getTransfer() {
        return transfer;
    }

    public void setTransfer(double transfer) {
        this.transfer = transfer;
    }

    Map<Double, String> history = new HashMap<>();
    public ATMinterface(){

    }

    public void check_balance(){
        System.out.println("AvailableBalance is: " + getBalance());
    }

    public void withdraw(double withdraw){
        if(withdraw > getBalance()){
            System.out.println("Insufficient Balance...");
        }
        else {
            history.put(withdraw, "Amount Withdrawn");
            System.out.println(withdraw + "Amount Withdraw Successfully...!");
            setBalance(getBalance() - withdraw);
            check_balance();
        }
    }

    public void deposit(double deposit){
        history.put(deposit, "Amount Deposited");
        System.out.println(deposit + " Deposited Successfully...!");
        setBalance(getBalance() + deposit);
        check_balance();
    }

    public void transfer(double transfer){
        if(transfer > getBalance()){
            System.out.println("Insufficient Balance...");
        }
        else {
            history.put(transfer, "Amount Transfer");
            System.out.println("Transfer Successful!");
            setBalance(getBalance() - transfer);
            check_balance();
        }
    }

    public void history(){
        for(Map.Entry<Double, String>m:history.entrySet()) {
            System.out.println(m.getKey() + m.getValue());
        }
    }

    public static void main(String[] args) {

        int atmnumber = 98388;
        int atmPin = 983;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM Machine");
        System.out.println("Enter ATM Number: ");
        int atmNumber = sc.nextInt();

        System.out.println("Enter PIN: ");
        int pin = sc.nextInt();

        ATMinterface atm = new ATMinterface();

        if((atmNumber == atmnumber) && (pin == atmPin)){
            while (true){
                System.out.println("1. Check Balance\n2. Withdraw\n3. Deposite\n4. Transfer\n5. Transition History\n6. Quit");
                System.out.println("Enter the choice: ");

                int ch = sc.nextInt();
                if (ch == 1){
                    atm.check_balance();
                }
                else if (ch == 2){
                    System.out.println("Enter the amount which you want to Withdraw : ");
                    double with = sc.nextDouble();
                    atm.withdraw(with);
                }
                else if (ch == 3){
                    System.out.println("Enter the amount which you want to Deposit : ");

                    Double depo = sc.nextDouble();
                    atm.deposit(depo);
                }
                else if (ch == 4){
                    System.out.println("Enter recipient's account number : ");
                    int no = sc.nextInt();
                    System.out.println("Enter the amount which you want to transfer : ");
                    double trans = sc.nextDouble();
                    atm.transfer(trans);
                }
                else if (ch == 5) {
                    atm.history();
                }
                else if (ch == 6){
                    System.out.println("Collect Your ATM Card\nThank You for using atm machine");
                    System.exit(0);
                }
                else {
                    System.out.println("Please , Enter Correct Choice...");
                }
            }
        }
        else {
            System.out.println("Incorrect ATM Number or PIN");
            System.exit(0);
}
}
}