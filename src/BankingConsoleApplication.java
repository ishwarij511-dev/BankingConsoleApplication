
import java.util.Scanner;

public class BankingConsoleApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 10000.0;
        int choice;

        System.out.println("Welcome to Krishna Bank");
        System.out.printf("Opening Balance: ₹%.2f%n", balance);

        while (true) {

            System.out.println("\n===== BANKING MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Enter 1 to 4.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.printf(
                        "Current Balance: ₹%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.nextLine();
                        break;
                    }

                    double deposit = sc.nextDouble();

                    if (deposit <= 0) {
                        System.out.println(
                            "Amount must be greater than zero.");
                    } else {
                        balance += deposit;
                        System.out.println("Deposit successful.");
                        System.out.printf(
                            "Updated Balance: ₹%.2f%n", balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.nextLine();
                        break;
                    }

                    double withdrawal = sc.nextDouble();

                    if (withdrawal <= 0) {
                        System.out.println(
                            "Amount must be greater than zero.");
                    } else if (withdrawal > balance) {
                        System.out.println(
                            "Transaction failed: Insufficient balance.");
                        System.out.printf(
                            "Current Balance: ₹%.2f%n", balance);
                    } else {
                        balance -= withdrawal;
                        System.out.println("Withdrawal successful.");
                        System.out.printf(
                            "Updated Balance: ₹%.2f%n", balance);
                    }
                    break;

                case 4:
                    System.out.println(
                        "Thank you for banking with us. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice. Select 1, 2, 3, or 4.");
            }
        }
    }
}
