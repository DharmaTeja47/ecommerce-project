import java.util.Scanner;

class PaymentScreen {

    static Scanner sc = new Scanner(System.in);

    static boolean processPayment(double amount) {

        ConsoleUI.printLine();
        System.out.println("PAYMENT PAGE");
        ConsoleUI.printLine();

        System.out.println("1. UPI Payment");
        System.out.println("2. Card Payment");
        System.out.println("3. Cancel");

        ConsoleUI.printLine();
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        Payment payment = null;

        switch (choice) {

            case 1:
                payment = new UPIPayment();
                break;

            case 2:
                payment = new CardPayment();
                break;

            case 3:
                return false;

            default:
                System.out.println("Invalid option");
                return false;
        }

        return payment.pay(amount);
    }
}