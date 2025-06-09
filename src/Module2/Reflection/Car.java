package Module2.Reflection;

public class Car {

    private String brand;
    private int yearOfConstruction;

    private Car() {}
    Car(String brand, int yearOfConstruction) {
        this.brand = brand;
        this.yearOfConstruction = yearOfConstruction;
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", year of construction: " + yearOfConstruction;
    }
}
