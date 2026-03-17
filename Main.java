import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            ConsoleUI.printLine();
            ConsoleUI.printCentered("WELCOME TO ECOMMERCE APPLICATION");
            ConsoleUI.printLine();

            System.out.println("1. Customer");
            System.out.println("2. Seller");
            System.out.println("3. Exit");

            ConsoleUI.printLine();
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customerAuth();
                    break;

                case 2:
                    sellerAuth();
                    break;

                case 3:
                    System.out.println("Thank you for using the application!");
                    return;
            }
        }
    }

    static void customerAuth() {

        System.out.println("\n1. Login");
        System.out.println("2. Register");

        int ch = sc.nextInt();

        User user = null;

        if (ch == 1)
            user = AuthSystem.login("customer");
        else
            user = AuthSystem.register("customer");

        if (user != null)
            CustomerPanel.customerMenu();
    }

    static void sellerAuth() {

        System.out.println("\n1. Login");
        System.out.println("2. Register");

        int ch = sc.nextInt();

        User user = null;

        if (ch == 1)
            user = AuthSystem.login("seller");
        else
            user = AuthSystem.register("seller");

        if (user != null)
            SellerPanel.sellerMenu();
    }
}
