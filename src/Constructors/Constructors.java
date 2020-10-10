package Constructors;

public class Constructors {
    public String brand;
    public String model;
    public int horsePower;

    public Constructors(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;
    }

    public Constructors(String brand, String model) {
        this(brand);
        this.model = model;
    }

    public Constructors(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getCar() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.model != null ? this.getModel() : "unknown",
                this.getHorsePower() != 0 ? this.getHorsePower() : -1);
    }
}
