public class Order {
    private User user;
    private ShoppingCart cart;

    // Constructor
    public Order(User user, ShoppingCart cart) {
        this.user = user;
        this.cart = cart;
    }

    // Getter cho user
    public User getUser() {
        return user;
    }

    // Getter cho cart
    public ShoppingCart getCart() {
        return cart;
    }

    public void checkout() {
        double total = cart.calculateTotal();
        System.out.println("Tổng tiền thanh toán: $" + total);
        System.out.println("Thanh toán thành công cho người dùng: " + user.getUsername());
    }
}
