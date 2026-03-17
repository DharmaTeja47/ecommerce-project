class User {

    private String username;
    private String password;
    private String role;

    User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getRole() {
        return role;
    }

    void setPassword(String password) {
        this.password = password;
    }
}