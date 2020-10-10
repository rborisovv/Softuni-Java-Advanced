package RawData;

public class Tires {
    private double firstTirePressure;
    private int firstTireAge;
    private double secondTirePressure;
    private int secondTireAge;
    private double thirdTirePressure;
    private int thirdTireAge;
    private double fourthTirePressure;
    private int fourthTireAge;

    public Tires(double firstTirePressure, int firstTireAge,
                 double secondTirePressure, int secondTireAge,
                 double thirdTirePressure, int thirdTireAge,
                 double fourthTirePressure, int fourthTireAge) {
        this.firstTirePressure = firstTirePressure;
        this.firstTireAge = firstTireAge;
        this.secondTirePressure = secondTirePressure;
        this.secondTireAge = secondTireAge;
        this.thirdTirePressure = thirdTirePressure;
        this.thirdTireAge = thirdTireAge;
        this.fourthTirePressure = fourthTirePressure;
        this.fourthTireAge = fourthTireAge;
    }

    public double getFirstTirePressure() {
        return firstTirePressure;
    }

    public double getSecondTirePressure() {
        return secondTirePressure;
    }

    public double getThirdTirePressure() {
        return thirdTirePressure;
    }

    public double getFourthTirePressure() {
        return fourthTirePressure;
    }
}