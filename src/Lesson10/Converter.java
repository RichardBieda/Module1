package Lesson10;


public class Converter {

    private final static char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(155));//Test output
        System.out.println(intToBinaryString(155));
        System.out.println(hexToBinaryString("9b"));
        System.out.println("---------------------------");
        System.out.println(Integer.toHexString(155));//Test output
        System.out.println(intToHexString(155));
        System.out.println(binaryToHexString("10011011"));
        System.out.println("---------------------------");
        System.out.println(0x9b);//Test output
        System.out.println(binaryStringToInt("10011011"));
        System.out.println(hexStringToInt("9b"));
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

    static String intToHexString(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            int index = value %16;
            result.append(hexValues[index]);
            value /= 16;
        }
        return result.reverse().toString();
    }

    static String binaryToHexString(String value) {
        StringBuilder stValue = new StringBuilder(value);
        setZeros(stValue);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stValue.length(); i = i+4) {
            int index = binaryStringToInt(stValue.substring(i, i+4));
            result.append(hexValues[index]);
        }
        return result.toString();
    }

    static int binaryStringToInt(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            int digit = getIndex(value.charAt(value.length()-1 -i));
            result += digit * power(2, i);
        }
        return result;
    }
    //I know the binaryToInt and the hexToString methods are almost the same.
    //They could be merged together.
    static int hexStringToInt(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            int digit = getIndex(value.charAt(value.length()-1 -i));
            result += digit * power(16, i);
        }
        return result;
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
        for (int i = 0; i < hexValues.length; i++) {
            if (hexValues[i] == c) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static void setZeros(StringBuilder sb) {
        while (sb.length() %4 != 0) {
            sb.insert(0, '0');
        }
    }
}
