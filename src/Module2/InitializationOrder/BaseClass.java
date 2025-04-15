package Module2.InitializationOrder;

public class BaseClass {

    static String staticVariable = "Base class static variable";

    static {
        System.out.println("Base class static init block");
        System.out.println(staticVariable);
    }

    BaseClass() {
        System.out.println("Base class constructor");
    }

    {
        System.out.println("Base class constructor init block");
    }
}
