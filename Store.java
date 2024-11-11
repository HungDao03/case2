import java.util.ArrayList;

public class Store implements StoreManagement {
    private ArrayList<TeddyBear> bears;

    // Singleton instance
    private static Store instance;

    private Store() {
        bears = new ArrayList<>();
    }

    // Đảm bảo Store chỉ có một thể hiện duy nhất (Singleton)
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    // Thêm một TeddyBear vào danh sách
    @Override
    public void addBear(TeddyBear teddyBear) {
        bears.add(teddyBear);
    }

    // Hiển thị tất cả các TeddyBear
    @Override
    public void showAllBears() {
        for (TeddyBear bear : bears) {
            System.out.println(bear);
        }
    }

    // Tìm TeddyBear theo ID
    @Override
    public TeddyBear getBearById(String id) {
        for (TeddyBear bear : bears) {
            if (bear.getId().equals(id)) {
                return bear;
            }
        }
        return null; // Trả về null nếu không tìm thấy TeddyBear với ID này
    }
}
