package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKm;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKm = fuelCostForOneKm;
        this.distanceTraveled = 0;
    }

    public boolean fuelCheck(int amountOfKms) {
        double result = this.fuelAmount - (amountOfKms * this.fuelCostForOneKm);
        return result >= 0;
    }

    public void setFuel(int amountOfKms) {
        this.fuelAmount -= (amountOfKms * this.fuelCostForOneKm);
    }

    public void setDistanceTraveled(int amountOfKms) {
        this.distanceTraveled += amountOfKms;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}