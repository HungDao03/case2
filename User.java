public class User {
    private String username;
    private String password;
    private boolean isAdmin;
    private ShoppingCart shoppingCart;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.shoppingCart = new ShoppingCart(); // Khởi tạo giỏ hàng khi tạo User
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
