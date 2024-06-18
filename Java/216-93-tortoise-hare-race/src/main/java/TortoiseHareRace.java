public class TortoiseHareRace {
    public void game(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance) {
        Tortoise tortoise = new Tortoise(tortoiseSpeed);
        Hare hare = new Hare(hareSpeed, hareSleepDuration);
        if (tortoise.race(distance) > hare.race(distance)) {
            hare.win();
        } else if (tortoise.race(distance) < hare.race(distance)) {
            tortoise.win();
        } else {
            draw();
        }
    }

    public void draw() {
        System.out.print("Draw!");
    }
}
