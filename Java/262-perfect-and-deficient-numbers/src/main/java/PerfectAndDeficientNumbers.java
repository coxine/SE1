public class PerfectAndDeficientNumbers {

    public static boolean isPerfect(int posInt) {
        int sum = 0;
        for (int i = 1; i < posInt; i++) {
            if (posInt % i == 0) {
                sum += i;
            }
        }
        return sum == posInt;
    }

    public static boolean isDeficient(int posInt) {
        int sum = 0;
        for (int i = 1; i < posInt; i++) {
            if (posInt % i == 0) {
                sum += i;
            }
        }
        return sum < posInt;
    }
}
