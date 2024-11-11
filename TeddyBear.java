public class TeddyBear {
    private String id;
    private String name;
    private String color;
    private String size;
    private double price;

    public TeddyBear(String id, String name, String color, String size, double price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    // Phương thức getId() để lấy id
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - Color: " + color + ", Size: " + size + ", Price: $" + price;
    }

    public double getPrice() {
        return price;
    }
}
