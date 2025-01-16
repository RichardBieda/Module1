package Lesson18;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayQueue<Integer> arrQ = new ArrayQueue<>(6);
        arrQ.add(1);
        arrQ.add(2);
        arrQ.add(3);
        arrQ.add(4);
        arrQ.add(5);
        arrQ.add(6);
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.remove();
        arrQ.remove();
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.add(1);
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.add(2);
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.poll();
        arrQ.add(3);
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.poll();
        arrQ.poll();
        arrQ.poll();
        arrQ.poll();
        arrQ.poll();
        System.out.println(arrQ + " " + arrQ.size());

        arrQ.add(4);
        arrQ.add(5);
        System.out.println(arrQ + " " + arrQ.size());
    }
}
