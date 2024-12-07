package extras.LargeNumber;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        LargeNumber con = new LargeNumber("4000", 10);
        con.divide("7");
        System.out.println(con.getValue());
        BigInteger big1 = new BigInteger("1234567891122334455667788995427845425157674845275194979445652762941576546459542652621975164516725649159167595495");
        BigInteger big2 = new BigInteger("5427845425167889542512455");
        System.out.println(big1.divide(big2));
    }
}
