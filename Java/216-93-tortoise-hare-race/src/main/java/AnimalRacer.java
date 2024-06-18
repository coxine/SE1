abstract class AnimalRacer {

    int speed;

    public abstract double race(int distance);

    public abstract void win();

    AnimalRacer(int s) {
        speed = s;
    }
}
