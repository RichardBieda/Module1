package Module2.Reflection;

public class Car {

    @Important(value = "brand is important")
    private String brand;
    @Important
    private int yearOfConstruction;

    private Car() {}
    Car(String brand, int yearOfConstruction) {
        this.brand = brand;
        this.yearOfConstruction = yearOfConstruction;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    private String info() {
        return "brand: " + brand + ", year of construction: " + yearOfConstruction;
    }

    @Override
    public String toString() {
        return info();
    }
}
