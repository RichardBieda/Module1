package Module2.Annotationen.M1;

class Car {

    private String brand;

    @Deprecated
    public void drive() {
        System.out.println("car is driving");
    }

    @Override
    public String toString() {
        return brand;
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
    }
}
