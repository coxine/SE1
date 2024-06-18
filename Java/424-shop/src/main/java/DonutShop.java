import java.util.ArrayList;
import java.util.Optional;

public class DonutShop extends Shop implements Nameable {
    String companyName;
    public static final double TAX_RATE = 0.15;

    public DonutShop() {

        companyName = "Sweat Donut";
        Item i1 = new Item("Donuts", 1.0);
        Item i2 = new Item("Muffins", 1.5);
        Item i3 = new Item("Danish", 2.0);
        Item i4 = new Item("Coffee", 2.5);
        Item i5 = new Item("Tea", 3.0);

        menuItems.add(i1);
        menuItems.add(i2);
        menuItems.add(i3);
        menuItems.add(i4);
        menuItems.add(i5);
        calculator = new SimpleTaxCalculator(TAX_RATE);

    }

    ArrayList<Item> menuItems = new ArrayList<Item>();

    public void addItem(Item i) {
        menuItems.add(i);
    }

    public ArrayList<Item> getInventory() {
        return menuItems;
    }

    public boolean buyInventory(String name) {
        Optional<Item> i = menuItems.stream().filter(item -> item.name == name).findFirst();
        if (i.isPresent() == false) {
            return false;
        }
        income += i.get().price;
        return true;
    }

    public String getName() {
        return companyName;
    }

    public void setName(String name) {
        companyName = name;
    }
}
