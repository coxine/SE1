import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class AsteroidTest {
    private final Asteroid asteroid = new Asteroid();

    @Test
    public void test1() {
        assertEquals(Arrays.toString(asteroid.asteroidCollision(new int[] {})),
                Arrays.toString(new int[] {}));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.toString(asteroid.asteroidCollision(new int[] { 8, -8, 8, -8 })),
                Arrays.toString(new int[] {}));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.toString(asteroid.asteroidCollision(new int[] { 10, 2, -5, -3 })),
                Arrays.toString(new int[] { 10 }));
    }

}
