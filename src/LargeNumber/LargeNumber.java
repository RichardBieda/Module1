package LargeNumber;

import java.util.Objects;

public class LargeNumber implements Comparable {

    private final static char[] HEX_VALUES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final static String[] BYTE_VALUES = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    public final static int MIN_RADIX = 2;
    public final static int MAX_RADIX = 16;
    private String value;
    private int radix;
    private boolean isNegative;

    public LargeNumber() {}
    public LargeNumber(String value, int radix) throws LargeNumberValueException {
        if (!isValidRadix(radix)) {
            throw new LargeNumberValueException("Radix is out of bounds");
        } else if (!isValidValue(value, radix)) {
            throw new LargeNumberValueException("Value parameter has illegal signs or null");
        }
        this.value = value;
        this.radix = radix;
        this.isNegative = value.charAt(0) == '-';
    }
    public LargeNumber(LargeNumber largeNumber) {
        value = largeNumber.value;
        radix = largeNumber.radix;
        isNegative = largeNumber.isNegative;
    }

//    public String toRadix(int newRadix) throws LargeNumberValueException {
//
//        return "";
//    }


    public String getValue() {
        return value;
    }

    public int getRadix() {
        return radix;
    }

    public void setValue(String value, int radix) throws LargeNumberValueException {
        if (!isValidRadix(radix)) {
            throw new LargeNumberValueException("Radix is out of bounds");
        } else if (!isValidValue(value, radix)) {
            throw new LargeNumberValueException("Value parameter has illegal signs or null");
        }
        this.isNegative = value.charAt(0) == '-';
        this.value = value;
        this.radix = radix;
    }

    public void add(String summand) throws LargeNumberValueException {
        if (summand.equals("0")) {
            return;
        } else if (!isValidValue(summand, radix)) {
            throw new LargeNumberValueException("Summand is invalid");
        }
        boolean isSummandNegative = false;
        if (summand.charAt(0) == '-') {
            isSummandNegative = true;
            summand = summand.replace("-", "");
        }
        if (isNegative) {
            value = value.replace("-", "");
        }
        if (this.isNegative && isSummandNegative) {
            value = "-" + LargeNumber.add(new StringBuilder(value), new StringBuilder(summand), radix);
            return;
        }
        if (!this.isNegative && !isSummandNegative) {
            value = LargeNumber.add(new StringBuilder(value), new StringBuilder(summand), radix);
            return;
        }
        if (this.isNegative && !isSummandNegative) {
            if (isBigger(summand, value)) {
                value = LargeNumber.subtract(new StringBuilder(value), new StringBuilder(summand), radix);
                return;
            } else {
                value = "-" + LargeNumber.subtract(new StringBuilder(value), new StringBuilder(summand), radix);
                return;
            }
        }
        if (!this.isNegative && isSummandNegative) {
            if (isBigger(value, summand)) {
                value = LargeNumber.subtract(new StringBuilder(value), new StringBuilder(summand), radix);
            } else {
                value = "-" + LargeNumber.subtract(new StringBuilder(value), new StringBuilder(summand), radix);
            }
        }
    }

    public void subtract(String subtrahend) throws LargeNumberValueException {
        if (subtrahend.equals("0")) {
            return;
        } else if (!isValidValue(subtrahend, radix)) {
            throw new LargeNumberValueException("subtrahend is invalid");
        }
        boolean isSubtrahendNegative = false;
        if (subtrahend.charAt(0) == '-') {
            isSubtrahendNegative = true;
            subtrahend = subtrahend.replace("-", "");
        }
        if (isNegative) {
            value = value.replace("-", "");
        }
        if (!this.isNegative && isSubtrahendNegative) {
            value = LargeNumber.add(new StringBuilder(value), new StringBuilder(subtrahend), radix);
            return;
        }
        if (this.isNegative && !isSubtrahendNegative) {
            value = "-" + LargeNumber.add(new StringBuilder(value), new StringBuilder(subtrahend), radix);
            return;
        }
        if (this.isNegative && isSubtrahendNegative) {
            if (isBigger(subtrahend, value)) {
                value =  LargeNumber.subtract(new StringBuilder(value), new StringBuilder(subtrahend), radix);
                return;
            } else {
                value = "-" + LargeNumber.subtract(new StringBuilder(value), new StringBuilder(subtrahend), radix);
                return;
            }
        }
        if (!this.isNegative && !isSubtrahendNegative) {
            if (isBigger(value, subtrahend)) {
                value =  LargeNumber.subtract(new StringBuilder(value), new StringBuilder(subtrahend), radix);
            } else {
                value = "-" + LargeNumber.subtract(new StringBuilder(value), new StringBuilder(subtrahend), radix);
            }
        }
    }

    public void multiply(String multiplicator) throws LargeNumberValueException {
        if (!isValidValue(multiplicator, radix)) {
            throw new LargeNumberValueException("Multiplicator is invalid");
        }
        if (multiplicator.equals("0")) {
            value = "0";
            return;
        }
        boolean isMultiplicatorNegative = false;
        if (multiplicator.charAt(0) == '-') {
            isMultiplicatorNegative = true;
            multiplicator = multiplicator.replace("-", "");
        }
        if (isNegative) {
            value = value.replace("-", "");
        }
        if ((isNegative && isMultiplicatorNegative) || (!isNegative && ! isMultiplicatorNegative)) {
            value = LargeNumber.multiply(value, multiplicator, radix);
            return;
        }
        value = "-" + LargeNumber.multiply(value, multiplicator, radix);

    }

    public void divide(String divisor) throws LargeNumberValueException {
        if (!isValidValue(divisor, radix)) {
            throw new LargeNumberValueException("Divisor is invalid");
        }
        boolean isDivisorNegative = false;
        if (divisor.charAt(0) == '-') {
            isDivisorNegative = true;
            divisor = divisor.replace("-", "");
        }
        if (isNegative) {
            value = value.replace("-", "");
        }
        if ((isNegative && isDivisorNegative) || !isNegative && !isDivisorNegative) {
            value = divide(value, divisor, radix);
            return;
        }
        value = "-" + divide(value, divisor, radix);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof LargeNumber)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        LargeNumber other = (LargeNumber) o;
        return this.value.equals(other.value) && this.radix == other.radix && this.isNegative == other.isNegative;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, radix, isNegative);
    }

    private static String subtract(StringBuilder value, StringBuilder minus, int radix) {
        StringBuilder minuend = isBigger(value.toString(), minus.toString()) ? value : minus;
        StringBuilder subtrahend = isBigger(value.toString(), minus.toString()) ? minus : value;
        while (minuend.length() < subtrahend.length()) {
            minuend.insert(0, '0');
        }
        while (subtrahend.length() < minuend.length()) {
            subtrahend.insert(0, '0');
        }
        int inMind = 0;
        for (int i = subtrahend.length()-1; i >= 0; i--) {
            int x = getHexIndex(minuend.charAt(i)) - inMind - getHexIndex(subtrahend.charAt(i));
            char c = HEX_VALUES[(x + radix) % radix];
            inMind = x < 0 ? 1 : 0;
            value.setCharAt(i, c);

        }
        while (value.charAt(0) == '0' && value.length() > 1) {
            value.deleteCharAt(0);
        }
        return value.toString();
    }


    private static String multiply(String value, String multiplicator,int radix) {
        int countZeros = 0;
        for (int i = multiplicator.length()-1; i > 0; i--) {
            if (multiplicator.charAt(i) == '0') {
                countZeros++;
            } else {
                break;
            }
        }
        multiplicator = multiplicator.substring(0, multiplicator.length() - countZeros);
        StringBuilder result = new StringBuilder();
        for (int i = multiplicator.length()-1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            int inMind = 0;
            for (int j = value.length()-1; j >= 0; j--) {
                int x = getHexIndex(multiplicator.charAt(i)) * getHexIndex(value.charAt(j)) + inMind;
                char c = HEX_VALUES[x % radix];
                tmp.insert(0, c);
                inMind = x / radix;
            }
            if (inMind > 0) {
                tmp.insert(0, HEX_VALUES[inMind]);
            }
            int places = multiplicator.length()-1;
            while (places > i) {
                tmp.append('0');
                places--;
            }
            StringBuilder addingTerms = new StringBuilder(LargeNumber.add(result, tmp, radix));
            result = new StringBuilder(addingTerms);
        }
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < countZeros; i++) {
            zeros.append('0');
        }
        return result.append(zeros).toString();
    }

    private static String divide(String value, String divisor, int radix) throws LargeNumberValueException {
        if (divisor.equals(value)) {
            return "1";
        }
        if (divisor.equals("0") || isBigger(divisor, value)) {
            return "0";
        }
        if (divisor.equals("1")) {
            return value;
        }
        String quotient = "1";
        String newDivisor = divisor;
        while (newDivisor.length() < value.length()-1) {
                newDivisor = newDivisor + "0";
                quotient = quotient + "0";
        }
        String tmpQuotient = quotient;
        while (true) {
            if (isBigger(value, add(new StringBuilder(newDivisor), new StringBuilder(multiply(divisor, tmpQuotient, radix)),radix))) {
                newDivisor = add(new StringBuilder(newDivisor), new StringBuilder(multiply(divisor, tmpQuotient, radix)), radix);
                quotient = add(new StringBuilder(quotient), new StringBuilder(tmpQuotient), radix);
            } else {
                tmpQuotient = tmpQuotient.substring(0, tmpQuotient.length()-1);
            }
            if (tmpQuotient.length() < 2|| newDivisor.equals(value)) {
                break;
            }
        }
        while (isBigger(value, add(new StringBuilder(newDivisor), new StringBuilder(divisor), radix))) {
            newDivisor =  add(new StringBuilder(newDivisor), new StringBuilder(divisor), radix);
            quotient =  add(new StringBuilder(quotient), new StringBuilder("1"), radix);
        }
        return quotient.toString();
    }

    private static String add(StringBuilder value, StringBuilder plus, int radix) {
        while (value.length() < plus.length()) {
            value.insert(0, '0');
        }
        while (plus.length() < value.length()) {
            plus.insert(0, '0');
        }
        int inMind = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
        int x = inMind + getHexIndex(value.charAt(i)) + getHexIndex(plus.charAt(i));
        char c = HEX_VALUES[x % radix];
             value.setCharAt(i, c);
             inMind = x / radix;
        }
        if (inMind > 0) {
            value.insert(0, HEX_VALUES[inMind]);
        }
        return value.toString();
    }

    private static boolean isValidRadix(int radix) {
        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            return false;
        }
        return true;
    }

    private static boolean isValidValue(String value, int radix) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        int x = value.charAt(0) == '-' ? 1 : 0;
        for (int i = x; i < value.length(); i++) {
            if (!isHexIndex(value.charAt(i), radix)) {
                return false;
            }
        }
        return true;
    }
    private static boolean isHexIndex(char c, int radix) {
        for (int i = 0; i < radix; i++) {
            if (c == HEX_VALUES[i]) {
                return true;
            }
        }
        return false;
    }

    private static int getHexIndex(char c) {
        for (int i = 0; i < HEX_VALUES.length; i++) {
            if (c == HEX_VALUES[i]) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isBigger(String value, String other) {
        if (value.length() > other.length()) {
            return true;
        } else if (value.length() < other.length()) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) > other.charAt(i)) {
                return true;
            } else if (value.charAt(i) < other.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        LargeNumber other = (LargeNumber) o;
        return this.value.compareTo(other.value);
    }
}
