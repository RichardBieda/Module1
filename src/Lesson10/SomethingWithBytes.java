package Lesson10;

public class SomethingWithBytes {

    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE: " + 0b01111111_11111111_11111111_11111111); //Max int
        System.out.println("Integer.MIN_VALUE: " + 0b10000000_00000000_00000000_00000000); //Min int
        System.out.println("               -1: " + 0b11111111_11111111_11111111_11111111); //-1
        System.out.println("                0: " + 0b00000000_00000000_00000000_00000000); //0
        System.out.println("                1: " + 0b00000000_00000000_00000000_00000001); //1
        System.out.println(2 << 2); //2 = 0b10 becomes 8 = 0b1000
        System.out.println("-------------------------------");
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
        System.out.println("-------------------------------");
        int a = 0b11111111_11111111_11111111_11111100;
        System.out.println(a);
        int b = a >>> 1;
        System.out.println(b);
        System.out.println(Converter.intToBinaryString(b));
    }
}
