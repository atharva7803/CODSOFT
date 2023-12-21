import java.util.Scanner;

    class BankAccount{
        private double Balance;

        public BankAccount(double intialBalance){
            this.Balance = intialBalance;
        }

        public double seeBalance(){
            return Balance;
        }

        public void deposit(double amount){
            Balance += amount;
        }

        public boolean withdraw(double amount){
            if(amount <= Balance){
                Balance -= amount;
                return true;
            }
            else{
                System.out.println("Insufficient Balance!");
                return false;
            }
        }
    }

    class ATM{
        private BankAccount userAccount;

        public ATM(BankAccount userAccount){
            this.userAccount = userAccount;
        }

        public void displayMenu(){
            System.out.println("1) Withdraw");
            System.out.println("2) Deposit");
            System.out.println("3) Check Balance");
            System.out.println("4) Exit");
        }

        public void Transactions(int choice, Scanner sc){
            switch (choice) {
                case 1:
                    System.out.println("Enter Withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    if(userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawl Successful! \nRemaining Balance: "+ userAccount.seeBalance());
                    }
                    break;
                    
                case 2:
                    System.out.println("Enter dposit amount: ");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit sucessful. \nUpdated Balance: "+ userAccount.seeBalance());
                    break;

                case 3:
                    System.out.println("Current Balance: "+ userAccount.seeBalance());
                    break;

                case 4:
                    System.out.println("Exiting. Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    
            }
        }

    }

    public class ATMinterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        BankAccount userAccount = new BankAccount(1000);

        ATM atm = new ATM(userAccount);

        int choice;
        do{
            atm.displayMenu();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            atm.Transactions(choice, sc);
        }
        while(choice != 4);
    }
}