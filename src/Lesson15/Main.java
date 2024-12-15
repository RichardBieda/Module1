package Lesson15;

import extras.LargeNumber.LargeNumber;
import extras.LargeNumber.LargeNumberValueException;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        MyArrayList<String> list = new MyArrayList<>();

        LargeNumber ln = new LargeNumber("2", 10);
        for (int i = 0; i < 100; i++) {
            list.add(ln.getValue());
            ln.multiply("2");
        }
        System.out.println(list);

        MyArrayList<Character> cl = new MyArrayList<>();
        cl.add('A');
        cl.add('B');
        cl.add('C');
        cl.add('D');
        cl.add('E');
        System.out.println(cl);
        cl.set(0, 'Z');
        System.out.println(cl + " " + cl.size());
    }
}
