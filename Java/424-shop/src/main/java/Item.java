public class Item implements Nameable {
    String name;
    double price;

    public Item(String n, double p) {
        name = n;
        price = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }
}
