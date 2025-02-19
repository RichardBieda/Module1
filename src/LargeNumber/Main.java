package LargeNumber;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        LargeNumber l1 = new LargeNumber("f7a4", 16);
        l1.divide("b2");
        System.out.println(l1.getValue()); //164

        LargeNumber l2 = new LargeNumber("1234567891122334455667788995427845425157674845275194979445652762941576546459542652621975164516725649159167595495", 10);
        l2.divide("5427845425167889542512455");
        System.out.println(l2.getValue());
        BigInteger big1 = new BigInteger("1234567891122334455667788995427845425157674845275194979445652762941576546459542652621975164516725649159167595495");
        BigInteger big2 = new BigInteger("5427845425167889542512455");
        System.out.println(big1.divide(big2));
    }
}
