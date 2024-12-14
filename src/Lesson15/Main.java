package Lesson15;

import extras.LargeNumber.LargeNumber;
import extras.LargeNumber.LargeNumberValueException;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        MyArrayList<String> list = new MyArrayList<>();

        LargeNumber ln = new LargeNumber("2", 10);
        for (int i = 0; i < 1000; i++) {
            list.add(ln.getValue());
            ln.multiply("2");
        }

        System.out.println(list);
    }
}
