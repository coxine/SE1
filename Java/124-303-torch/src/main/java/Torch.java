public class Torch {
    // add attributes for torch
    Battery battery;

    public Torch(Battery battery) {
        this.battery = battery;
    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours) {
        return battery.useBattery(hours * battery.getConsumptionRate());
    }

    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours) {
        battery.chargeBattery(hours * battery.getProductionRate());
    }

}
