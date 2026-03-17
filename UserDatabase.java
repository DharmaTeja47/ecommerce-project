class UserDatabase {

    static User[] users = new User[100];
    static int count = 0;

    static void registerUser(User u) {

        if (u == null) {
            System.out.println("\nInvalid user");
            return;
        }

        if (count == users.length) {
            System.out.println("\nUser database is full");
            return;
        }

        users[count++] = u;
        System.out.println("\nRegistration successful");
    }

    static User login(String username, String password) {

        for (int i = 0; i < count; i++) {

            if (users[i].getUsername().equals(username)
                    && users[i].getPassword().equals(password)) {

                return users[i];
            }
        }

        return null;
    }

    static boolean userExists(String username) {

        for (int i = 0; i < count; i++) {

            if (users[i].getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }
}