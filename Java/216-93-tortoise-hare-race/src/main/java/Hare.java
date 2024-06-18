public class Hare extends AnimalRacer {
    int sleepDuration;

    Hare(int speed, int duration) {
        super(speed);
        this.sleepDuration = duration;
    }

    // add codes here
    public double race(int distance) {
        return sleepDuration + distance * 1.0 / speed;
    }

    // add codes here
    public void win() {
        System.out.print("Hare Win!");
    }
}
