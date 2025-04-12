package Module2.FunctionalProgramming;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {


        Calculable cal = new Calculable() {
            @Override
            public double calculate(int a, int b) {
                return a + b;
            }
        };
        Calculable cal1 = (a, b) -> 1.0*a/b;
        System.out.println(cal.calculate(10, 5));
        System.out.println(cal1.calculate(10, 5));

        Map<Integer, String> map = new TreeMap<>((a,b)->b-a);
        map.put(1, "h");
        map.put(2, "hh");
        map.put(3, "hhh");

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
