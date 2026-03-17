class Product {

    private int id;
    private String name;
    private double price;
    private String category;
    private int stock;

    Product(int id, String name, double price, String category, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    String getCategory() {
        return category;
    }

    int getStock() {
        return stock;
    }

    void reduceStock(int qty) {
        stock -= qty;
    }

    void display() {

        String status = stock == 0 ? "Out Of Stock" : String.valueOf(stock);

        System.out.printf("%-5d %-20s %-15s Rs.%-8.2f %-10s%n",
        id, name, category, price, status);
    }
}
