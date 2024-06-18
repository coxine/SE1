import java.util.ArrayList;
import java.util.Optional;

public class PizzaShop extends Shop implements Nameable {
    String companyName;
    public static final double TAX_RATE = 0.15;
    public static final double BASE = 0.1;

    ArrayList<Item> foodOfferings = new ArrayList<Item>();

    public PizzaShop() {
        companyName = "Big Pizza";
        Item i1 = new Item("Pizza", 1.0);
        Item i2 = new Item("Spaghetti", 1.5);
        Item i3 = new Item("Garden Salad", 2.0);
        Item i4 = new Item("Antipasto", 2.5);
        Item i5 = new Item("Calzone", 3.0);

        foodOfferings.add(i1);
        foodOfferings.add(i2);
        foodOfferings.add(i3);
        foodOfferings.add(i4);
        foodOfferings.add(i5);

        super.calculator = new LinearTaxCalculator(TAX_RATE, BASE);

    }

    public ArrayList<Item> getInventory() {
        return foodOfferings;
    }

    public boolean buyInventory(String name) {
        Optional<Item> i = foodOfferings.stream().filter(item -> item.name == name).findFirst();
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
