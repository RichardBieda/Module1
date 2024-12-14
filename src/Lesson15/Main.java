package Lesson15;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1d);
        list.add(2d);
        list.add(3d);
        list.add(4d);
        System.out.println(list);
        list.add(3, 999d);
        System.out.println(list);
        System.out.println(list.size());
    }
}
