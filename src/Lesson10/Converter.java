package Lesson10;


public class Converter {

    private final static char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        int test = -10;
        String testHex = "fffffff6";
        String testBinary = "11111111111111111111111111110110";
        System.out.println(Integer.toBinaryString(test));//Test output
        System.out.println(intToBinaryString(test));
        System.out.println(hexToBinaryString(testHex));
        System.out.println("--------------------------------");
        System.out.println(Integer.toHexString(test));//Test output
        System.out.println(intToHexString(test));
        System.out.println(binaryToHexString(testBinary));
        System.out.println("--------------------------------");
        System.out.println(0xfffffff6);//Test output
        System.out.println(binaryStringToInt(testBinary));
        System.out.println(hexStringToInt(testHex));
    }


    static String intToBinaryString(int value) {
        StringBuilder result = new StringBuilder();
        if (value > -1) {
            result.append(positiveBinaryString(value));
        } else {
            value = (-value) -1;
            StringBuilder tmp = new StringBuilder(positiveBinaryString(value));
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    tmp.setCharAt(i, '1');
                } else {
                    tmp.setCharAt(i, '0');
                }
            }
            while (tmp.length() < 32) {
                tmp.insert(0, '1');
            }
            result = tmp;
        }
        return result.toString();
    }


    static String hexToBinaryString(String value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int index = getIndex(value.charAt(i));
            StringBuilder tmpResult = new StringBuilder(positiveBinaryString(index));
            if (i > 0) {
                setZeros(tmpResult);
            }
            result.append(tmpResult);
        }
        return result.toString();
    }


    static String intToHexString(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if (value > 0) {
            while (value > 0) {
                int index = value % 16;
                result.append(hexValues[index]);
                value /= 16;
            }
            return result.reverse().toString();
        } else {
            StringBuilder tmp = new StringBuilder("ffffffff");
            value = (-value) -1;
            String minus = intToHexString(value);
            int difference = tmp.length() - minus.length();
            for (int i = minus.length()-1; i >= 0; i--) {
                int minusInt = getIndex(minus.charAt(i));
                tmp.setCharAt(difference + i, hexValues[hexValues.length-1 - minusInt]);
            }
            result = tmp;
            return result.toString();
        }
    }


    static String binaryToHexString(String value) {
        StringBuilder stValue = new StringBuilder(value);
        if (stValue.length() < 32) {
            setZeros(stValue);
        }
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
//--------------------------------------------------------------------------
    //helper methods
    private static String positiveBinaryString(int value) {
        if (value == 0) {
           return "0";
        }
        StringBuilder result = new StringBuilder();
        while (value > 0) {
              result.append(value%2);
              value /= 2;
     }
        return result.reverse().toString();
    }


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
