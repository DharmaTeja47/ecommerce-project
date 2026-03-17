import java.util.Scanner;

class CustomerPanel {

    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();

    static void customerMenu() {

        while (true) {

            ConsoleUI.printLine();
            System.out.println("CUSTOMER PANEL");
            ConsoleUI.printLine();

            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Add To Cart");
            System.out.println("4. Remove From Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Logout");

            ConsoleUI.printLine();
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Shop.displayProducts();
                    break;

                case 2:
                    searchProduct();
                    break;

                case 3:
                    addToCart();
                    break;

                case 4:
                    removeItem();
                    break;

                case 5:
                    cart.viewCart();
                    break;

                case 6:
                    checkout();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void searchProduct() {
        System.out.print("\nEnter product name to search: ");
        String keyword = sc.nextLine();
        Shop.searchProduct(keyword);
    }

    static void addToCart() {

        System.out.print("\nEnter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("Quantity must be greater than 0");
            return;
        }

        for (int i = 0; i < Shop.productCount; i++) {

            Product p = Shop.products[i];

            if (p.getId() == id) {

                if (p.getStock() == 0) {
                    System.out.println("Product Out Of Stock");
                    return;
                }

                if (qty > p.getStock()) {
                    System.out.println("Only " + p.getStock() + " items available");
                    return;
                }

                cart.addToCart(p, qty);
                System.out.println("Product added to cart");
                return;
            }
        }

        System.out.println("Product not found");
    }

    static void removeItem() {
        System.out.print("\nEnter Product ID to remove: ");
        int id = sc.nextInt();
        cart.removeItem(id);
    }

    static void checkout() {

        double total = cart.getTotalAmount();

        if (total == 0) {
            System.out.println("\nCart is empty");
            return;
        }

        System.out.println("\nTotal Amount: Rs." + total);

        boolean success = PaymentScreen.processPayment(total);

        if (success) {
            cart.printReceipt();
            System.out.println("\nOrder placed successfully");
            cart = new Cart();
        } else {
            System.out.println("\nPayment cancelled");
        }
    }
}