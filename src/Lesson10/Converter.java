package Lesson10;

public class Converter {

    public final static char[] values = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        System.out.println(toBinary(4513));
    }

    static String toBinary(int value) {
        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            sb.append(value%2);
            value /= 2;
        }
        return sb.reverse().toString();
    }

    static long power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
