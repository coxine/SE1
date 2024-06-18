import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Literal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in.close();

        if (Pattern.matches("\\d+", string)) {
            System.out.println("integer");
        } else if (Pattern.matches("\\d+L", string)) {
            System.out.println("long");
        } else if (Pattern.matches("\\d+\\.\\d+f", string)) {
            System.out.println("float");
        } else if (Pattern.matches("\\d+\\.\\d", string)) {
            System.out.println("double");
        } else if (Pattern.matches("'.'", string)) {
            System.out.println("char");
        } else if (Pattern.matches("true", string) || Pattern.matches("false", string)) {
            System.out.println("boolean");
        }
    }
}
