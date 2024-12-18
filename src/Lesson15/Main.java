package Lesson15;
import extras.LargeNumber.LargeNumber;
import extras.LargeNumber.LargeNumberValueException;

public class Main {

    public static void main(String[] args) throws LargeNumberValueException {

        MyLinkedList<String> list = new MyLinkedList<>();

        LargeNumber ln = new LargeNumber("2", 10);
        for (int i = 0; i < 100; i++) {
            list.add(ln.getValue());
            ln.multiply("2");
        }
        System.out.println(list);

        MyLinkedList<Character> cl = new MyLinkedList<>();
        cl.add('A');
        cl.add('B');
        cl.add('C');
        cl.add('D');
        cl.add('E');
        cl.add('F');
        cl.add('G');
        cl.add('H');
        cl.add('I');
        cl.add('J');
        System.out.println(cl);
        System.out.println(cl.getNthElementFromTail(3));
    }
}
