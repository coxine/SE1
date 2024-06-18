public class SimpleTaxCalculator implements TaxCalculator {
    double rate;

    public SimpleTaxCalculator(double r) {
        rate = r;
    }

    public double calculate(double income) {
        return income * rate;
    }
}
