import java.util.ArrayList;

public abstract class Shop {
    public double income;
    TaxCalculator calculator;

    public abstract ArrayList<Item> getInventory();

    public abstract boolean buyInventory(String item);

    public double calculateSalesTax() {
        return calculator.calculate(income);
    }

    public static void main(String args[]) {
        Shop shop = new DonutShop();

        ArrayList<Item> inventory = shop.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("Argument " + i + " = " + inventory.get(i));
        }

        shop.buyInventory("Donnut");
        shop.buyInventory("Donuts");
        shop.buyInventory("Tea");
        System.out.println(shop.calculateSalesTax());
    }
}
