class Shop {

    static final int MAX_PRODUCTS = 100;
    static Product[] products = new Product[MAX_PRODUCTS];
    static int productCount = 0;

    static void addProduct(Product p) {
        if (p == null) {
            System.out.println("\nCannot add null product");
            return;
        }

        if (productCount >= MAX_PRODUCTS) {
            System.out.println("\nShop is full. Cannot add more products");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId() == p.getId()) {
                System.out.println("\nProduct with this ID already exists");
                return;
            }
        }

        products[productCount++] = p;
        System.out.println("\nProduct added successfully");
    }

    static void displayProducts() {
        if (productCount == 0) {
            System.out.println("\nNo products available");
            return;
        }

        System.out.println("\nID    Name                 Category        Price     Stock");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < productCount; i++) {
            products[i].display();
        }
    }

    static void searchProduct(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("\nPlease enter a valid keyword");
            return;
        }

        boolean found = false;
        keyword = keyword.toLowerCase();

        System.out.println("\nSearch Results:");
        System.out.println("ID    Name                 Category        Price     Stock");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < productCount; i++) {
            String name = products[i].getName().toLowerCase();

            if (name.contains(keyword)) {
                products[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching products found");
        }
    }
}