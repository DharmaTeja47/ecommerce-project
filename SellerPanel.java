import java.util.Scanner;

class SellerPanel {

    static Scanner sc = new Scanner(System.in);
    static int productIdCounter = 1;

    static void sellerMenu() {

        while (true) {

            ConsoleUI.printLine();
            System.out.println("SELLER PANEL");
            ConsoleUI.printLine();

            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Logout");

            ConsoleUI.printLine();
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    Shop.displayProducts();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void addProduct() {

        System.out.print("\nEnter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();
        sc.nextLine();

        if (price < 0 || stock < 0) {
            System.out.println("Price and stock cannot be negative");
            return;
        }

        Product p = new Product(productIdCounter++, name, price, category, stock);

        Shop.addProduct(p);
    }
}