import java.util.Scanner;

class AuthSystem {

    static Scanner sc = new Scanner(System.in);

    static User register(String role) {

        System.out.print("\nEnter username: ");
        String username = sc.next();

        if (UserDatabase.userExists(username)) {
            System.out.println("Username already exists");
            return null;
        }

        System.out.print("Enter password: ");
        String password = sc.next();

        User u;

        if (role.equals("customer")) {
            u = new Customer(username, password);
        } else {
            u = new Seller(username, password);
        }

        UserDatabase.registerUser(u);

        return u;
    }

    static User login(String role) {

        System.out.print("\nEnter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        User u = UserDatabase.login(username, password);

        if (u == null) {
            System.out.println("Invalid credentials");
            return null;
        }

        if (!u.getRole().equals(role)) {
            System.out.println("Access denied for this role");
            return null;
        }

        System.out.println("\nLogin successful");
        return u;
    }
}