package Lesson14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray("1", "2");

        System.out.println(myArray.getSize() + "   " + myArray);
        myArray.add("3");
        myArray.add("4");
        myArray.add("5");
        myArray.add("6");
        myArray.add("7");
        myArray.add("8");
        myArray.add("9");
        myArray.add("10");
        myArray.add("11");
        myArray.add("12");
        myArray.add("13");
        System.out.println(myArray.getSize() + "   " + myArray);
        myArray.trimToSize();
        System.out.println(myArray.getSize() + "   " + myArray);
        myArray.remove("12");
        System.out.println(myArray.getSize() + "   " + myArray);
        myArray.set(11, "133");
        System.out.println(myArray.getSize() + "   " + myArray);
        System.out.println(myArray.get(11));
    }
}
