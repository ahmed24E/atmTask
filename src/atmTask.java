import java.util.Scanner;

public class atmTask {
    static Scanner scanner= new Scanner(System.in);
   static int correctNumber=1234;
    static double balance=2500.75;
    static int successfulTransactions = 0;

    public static boolean login(){
        int trys=0;
        while (trys<3){
            System.out.print("Enter your 4-digit PIN: ");
            int enteredNumber= scanner.nextInt();
            if (enteredNumber==correctNumber){
                System.out.println("Login successful!");
                return true;
            }else {
                trys++;
                System.out.println("Incorrect PIN. Attempts remaining: "+(3-trys));
            }
        }
        System.out.println("Your account has been locked.");
        return false;
    };
    /////////////////////////////////////////
    public static void atmMenu(){
        System.out.println("\n========= ATM =========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show Account Status");
        System.out.println("5. Exit");
        System.out.println("=======================");
        System.out.print("Enter your choice: ");
    };
    ////////////////////////////////////////
    public static void checkBalance() {
        System.out.println("Current balance: " + balance);
    };
    //////////////////////////////////////////
    public static void deposit(){
        System.out.print("Enter deposit amount: ");
        double amount=scanner.nextDouble();
        if(amount>0){
            balance += amount;
            successfulTransactions++;
            System.out.println("Deposit successful!");
            System.out.println("Updated balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    };
    //////////////////////////////////////
    public static void withdraw(){
        System.out.println("Remember Your Account Balance = " +balance);

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount == 0) {

            System.out.println("Transaction cancelled.");

        } else if (amount < 0) {

            System.out.println("Invalid amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient balance.");

        } else {

            balance -= amount;
            successfulTransactions++;

            System.out.println("Withdrawal successful!");
            System.out.println("Updated balance: " + balance);

            if (balance == 0) {
                System.out.println("Warning: Your account is empty.");
            }
        }
    };
    /////////////////////////
    public static void showAccountStatus() {

        if (balance >= 5000) {

            System.out.println("VIP Customer");

        } else if (balance >= 1000) {

            System.out.println("Regular Customer");

        } else {

            System.out.println("Low Balance");
        }
    };
    ///////////////////////
    public static void runATM(){
        int choice;
        do {
            atmMenu();
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    showAccountStatus();
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM.");
                    System.out.println("Total successful transactions: "
                            + successfulTransactions);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }while (choice != 5);
    }
    ////////////////////////////////////////////////////

    public static void main(String[] args){
        if (login()) {
            runATM();
        }
        scanner.close();
    }
}
