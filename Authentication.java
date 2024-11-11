import java.util.ArrayList;

public class Authentication {
    private ArrayList<User> users;

    public Authentication() {
        users = new ArrayList<>();
    }

    public boolean register(String username, String password, boolean isAdmin) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Tên đăng nhập đã tồn tại.");
                return false;
            }
        }
        users.add(new User(username, password, isAdmin));
        System.out.println("Đăng ký thành công.");
        return true;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                System.out.println("Đăng nhập thành công.");
                return user;
            }
        }
        System.out.println("Tên đăng nhập hoặc mật khẩu không đúng.");
        return null;
    }
}
