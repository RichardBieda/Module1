package Lesson10;


public class Converter {

    private final static char[] values = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(155));
        System.out.println(intToBinaryString(155));
        System.out.println(hexToBinaryString("9b"));

    }

    static String intToBinaryString(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            result.append(value%2);
            value /= 2;
        }
        return result.reverse().toString();
    }

    static String hexToBinaryString(String value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int index = getIndex(value.charAt(i));
            StringBuilder tmpResult = new StringBuilder(intToBinaryString(index));
            setZeros(tmpResult);
            result.append(tmpResult);
        }
        return result.toString();
    }
//------------------------------------------------------
    //helper methods
    private static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static int getIndex(char c) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == c) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static void setZeros(StringBuilder sb) {
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
    }
}
