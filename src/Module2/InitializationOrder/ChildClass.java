package Module2.InitializationOrder;

public class ChildClass extends BaseClass {

    static String staticVariable = "child class static variable";

    static {
        System.out.println("child class static init block");
        System.out.println(staticVariable);
    }
    ChildClass() {
        System.out.println("child class constructor");
    }

    {
        System.out.println("child class constructor init block");
    }
}
