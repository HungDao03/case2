public class AdminNotifier {
    public void notifyAdmin(Order order) {
        System.out.println("Thông báo cho Admin: Đơn hàng mới của người dùng " + order.getUser().getUsername());
        System.out.println("Chi tiết đơn hàng: ");
        order.getCart().viewCart();
    }
}
