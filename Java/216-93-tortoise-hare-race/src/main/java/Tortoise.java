public class Tortoise extends AnimalRacer {

    Tortoise(int s) {
        super(s);
    }

    // add codes here
    public double race(int distance) {
        return distance * 1.0 / speed;
    }

    // add codes here
    public void win() {
        System.out.print("Tortoise Win!");
    }
}
