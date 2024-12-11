package Lesson14;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray("7", "2");

        System.out.println(myArray.size() + "   " + myArray);
        myArray.add("9");
        myArray.add("4");
        myArray.add("5");
        myArray.add("1");
        myArray.add("6");
        myArray.add("8");
        myArray.add("3");
        myArray.add("10");
        System.out.println(myArray.size() + "   " + myArray);
        myArray.add(9, "11");
        myArray.remove("10");
        System.out.println(myArray.size() + "   " + myArray);
    }
}
