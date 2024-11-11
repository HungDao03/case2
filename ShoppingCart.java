import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<TeddyBear> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(TeddyBear bear) {
        items.add(bear);
        System.out.println(bear.getName() + " đã được thêm vào giỏ hàng.");
    }

    public void viewCart() {
        System.out.println("Giỏ hàng của bạn:");
        for (TeddyBear bear : items) {
            System.out.println(bear);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (TeddyBear bear : items) {
            total += bear.getPrice();
        }
        return total;
    }
}
