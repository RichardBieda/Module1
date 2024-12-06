package extras.LargeNumber;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        LargeNumber con = new LargeNumber("54255724581422855764572784575645", 10);
        con.divide("5427548454241");
        System.out.println(con.getValue());
        BigInteger big1 = new BigInteger("54255724581422855764572784575645");
        BigInteger big2 = new BigInteger("5427548454241");
        System.out.println(big1.divide(big2));
    }
}
