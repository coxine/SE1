import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Asteroid {
    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> aster = Arrays.stream(asteroids).boxed().collect(Collectors.toList());

        int i = 0;
        while (i < aster.size() - 1) {
            if (aster.get(i) > 0 && aster.get(i + 1) < 0) {
                if (Math.abs(aster.get(i)) == Math.abs(aster.get(i + 1))) {
                    aster.remove(i);
                    aster.remove(i);
                    if (i > 0) {
                        i--;
                    }
                } else if (Math.abs(aster.get(i)) > Math.abs(aster.get(i + 1))) {
                    aster.remove(i + 1);
                } else {
                    aster.remove(i);
                    if (i > 0) {
                        i--;
                    }
                }
            } else {
                i++;
            }
        }
        return aster.stream().mapToInt(j -> j).toArray();
    }

}
