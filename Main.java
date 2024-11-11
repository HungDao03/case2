import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        Store store = Store.getInstance();
        AdminNotifier adminNotifier = new AdminNotifier();

        // Sản phẩm mẫu cho cửa hàng
        store.addBear(new TeddyBear("1", "Gấu Teddy Cổ Điển", "Nâu", "Trung bình", 25.0));
        store.addBear(new TeddyBear("2", "Gấu Teddy Hồng", "Hồng", "Nhỏ", 15.0));
        store.addBear(new TeddyBear("3", "Gấu Teddy Khổng Lồ", "Trắng", "Lớn", 50.0));

        User currentUser = null;

        while (true) {
            System.out.println("\n---- Cửa Hàng Gấu Bông ----");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Xem sản phẩm");
            System.out.println("4. Thêm vào giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("6. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên đăng nhập: ");
                    String username = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String password = scanner.nextLine();
                    boolean isAdmin = false;  // Điều chỉnh dựa trên vai trò (ở đây mặc định là khách hàng)
                    auth.register(username, password, isAdmin);
                    break;

                case 2:
                    System.out.print("Nhập tên đăng nhập: ");
                    username = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = scanner.nextLine();
                    currentUser = auth.login(username, password);
                    break;

                case 3:
                    System.out.println("Danh sách Gấu Bông có sẵn:");
                    store.showAllBears();
                    break;

                case 4:
                    if (currentUser == null) {
                        System.out.println("Vui lòng đăng nhập trước!");
                        break;
                    }

                    System.out.print("Nhập ID của Gấu Bông muốn thêm vào giỏ hàng: ");
                    String id = scanner.nextLine();
                    TeddyBear bear = store.getBearById(id);
                    if (bear != null) {
                        currentUser.getShoppingCart().addItem(bear);
                    } else {
                        System.out.println("Không tìm thấy Gấu Bông.");
                    }
                    break;

                case 5:
                    if (currentUser == null) {
                        System.out.println("Vui lòng đăng nhập trước!");
                        break;
                    }

                    System.out.println("Đang thanh toán...");
                    Order order = new Order(currentUser, currentUser.getShoppingCart());
                    order.checkout();
                    adminNotifier.notifyAdmin(order);
                    break;

                case 6:
                    System.out.println("Đang thoát...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
