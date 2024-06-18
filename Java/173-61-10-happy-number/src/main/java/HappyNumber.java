
public class HappyNumber {

    public static boolean isHappy(int n) {
        n = calcHappy(n);
        for (int i = 1; i <= 1000; i++) {
            if (n == 1) {
                return true;
            }
            n = calcHappy(n);
        }
        return false;
    }

    private static int calcHappy(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (int) (Math.pow(n % 10, 2));
            n /= 10;
        }
        return ans;
    }
}
