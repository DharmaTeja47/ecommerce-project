class Cart {

    CartItem[] items = new CartItem[50];
    int count = 0;

    void addToCart(Product product, int qty) {

        if (count == items.length) {
            System.out.println("\nCart is full");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (items[i].getProduct().getId() == product.getId()) {
                items[i].setQuantity(items[i].getQuantity() + qty);
                System.out.println("\nItem quantity updated in cart");
                return;
            }
        }

        items[count++] = new CartItem(product, qty);
        System.out.println("\nItem added to cart");
    }

    void removeItem(int id) {

        for (int i = 0; i < count; i++) {

            if (items[i].getProduct().getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }

                items[count - 1] = null;
                count--;

                System.out.println("Item removed from cart");
                return;
            }
        }

        System.out.println("Product not found in cart");
    }

    void viewCart() {

        if (count == 0) {
            System.out.println("\nCart is empty");
            return;
        }

        double total = 0;

        System.out.println("\nID    Product              Qty        Total");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < count; i++) {

            CartItem c = items[i];

            System.out.printf("%-5d %-20s %-10d Rs.%.2f%n",
                    c.getProduct().getId(),
                    c.getProduct().getName(),
                    c.getQuantity(),
                    c.getTotal());

            total += c.getTotal();
        }

        System.out.println("------------------------------------------------");
        System.out.println("Total Amount: Rs." + total);
    }

    double getTotalAmount() {

        double total = 0;

        for (int i = 0; i < count; i++) {
            total += items[i].getTotal();
        }

        return total;
    }

    void reduceStockAfterOrder() {
        for (int i = 0; i < count; i++) {
            CartItem c = items[i];
            c.getProduct().reduceStock(c.getQuantity());
        }
    }

    void printReceipt() {

        System.out.println("\n============= BILL RECEIPT =============");

        double total = 0;

        for (int i = 0; i < count; i++) {

            CartItem c = items[i];

            System.out.printf("%-20s x%-3d Rs.%.2f%n",
                    c.getProduct().getName(),
                    c.getQuantity(),
                    c.getTotal());

            total += c.getTotal();
        }

        System.out.println("----------------------------------------");
        System.out.println("TOTAL PAID: Rs." + total);
        System.out.println("========================================");
    }
}