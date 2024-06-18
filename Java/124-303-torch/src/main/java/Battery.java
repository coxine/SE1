public class Battery {

    // add the attributes for class Battery
    double cRate;
    double rRate;
    double powerAmount;

    // No Parameter Constructor
    // set the attributes with default value
    public Battery() {
        this.cRate = 0.1;
        this.rRate = 0.2;
    }

    public Battery(double cRate, double rRate) {
        this.cRate = cRate;
        this.rRate = rRate;
    }

    public double getConsumptionRate() {
        return cRate;

    }

    public double getProductionRate() {
        return rRate;
    }

    // 充 p 电量
    // charge power which amount is p
    public void chargeBattery(double p) {
        powerAmount += p;
        if (powerAmount >= 1) {
            powerAmount = 1;
        }
    }

    // 如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    // if the remaining power amount is larger than p, consume the p power and
    // return true;
    // else the remaining power become 0 and return false;
    public boolean useBattery(double p) {
        if (powerAmount >= p) {
            powerAmount -= p;
            return true;
        }

        powerAmount = 0;
        return false;
    }

}
