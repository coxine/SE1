public class LinearTaxCalculator implements TaxCalculator {
    double rate;
    double base;

    public LinearTaxCalculator(double r, double b) {
        rate = r;
        base = b;
    }

    public double calculate(double income) {
        return income == 0 ? income : income * rate + base;
    }

}
