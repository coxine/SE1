
import java.util.Scanner;

public class CurrencyCalculation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many euros are you exchanging?");
		double euro = in.nextDouble();
		System.out.println("What is the exchange rate?");
		double exchangeRate = in.nextDouble();
		System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euro, exchangeRate,
				euro * exchangeRate / 100);
		in.close();
	}
}
