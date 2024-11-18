package Lesson11;

import java.util.Arrays;

public class Solution {

    private static final int ASCII_START = 97;

    public static void main(String[] args) {
        char[] mostCommonLetter = getMostCommonLetters("abccdeffghii");
        System.out.println(Arrays.toString(mostCommonLetter));

        boolean isAnagram = isAnagram("appXle", "ppaCle");
        System.out.println(isAnagram);

        String compress = compress("banana");
        System.out.println(compress);
    }

    static char[] getMostCommonLetters(String str) {
        if (str == null || str.isEmpty()) {
            return new char[0];
        }
        String tmp = replaceUnimportantSigns(str);
        if (tmp.isEmpty()) {
            return new char[0];
        }
        //tmp1 is the valid string in lower cases
        String tmp1 = makeAllLettersLow(tmp);
        //countsOfLetters is an intArray with 26 elements ,for example index[0] = 5 means 5 times a. index[25] = 2 means 5 times z
        //because 'a' in the ascii table is 97. 'z' is 25 + 97 = 122
        int[] countsOfLetters = getLettersNumber(tmp1);
        //highestCount is the highest value inside the countOfLetters array
        int highestCount = countsOfLetters[0];
        for (int i = 1; i < countsOfLetters.length; i++) {
            if (countsOfLetters[i] > highestCount) {
                highestCount = countsOfLetters[i];
            }
        }
        //If an element stores the highest value, then it creates a char array via the addElements method
        char[] result = new char[0];
        for (int i = 0; i < countsOfLetters.length; i++) {
            if (countsOfLetters[i] == highestCount) {
                result = addElement(result, (char) (ASCII_START + i));
            }
        }
        return result;
    }

    static boolean isAnagram(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) || (str2 == null || str2.isEmpty())) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equalsIgnoreCase(str2)) {
            return false;
        }
        //Both given strings are valid and in lower cases
        String ana1 = makeAllLettersLow(replaceUnimportantSigns(str1));
        String ana2 = makeAllLettersLow(replaceUnimportantSigns(str2));
        //These two int arrays stores the values of letters
        int[] anagramArray = getLettersNumber(ana1);
        int[] compareArray = getLettersNumber(ana2);
        //This loop compares the elements for unequality
        for (int i = 0; i < anagramArray.length; i++) {
            if (anagramArray[i] != compareArray[i]) {
                return false;
            }
        }
        return true;
    }

    static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return "0";
        }
        StringBuilder toCompressString = new StringBuilder(makeAllLettersLow(replaceUnimportantSigns(str)));
        toCompressString.append("!");
        StringBuilder result = new StringBuilder();
        char c = toCompressString.charAt(0);
        int count = 1;
        for (int i = 1; i < toCompressString.length(); i++) {
            if (toCompressString.charAt(i) == c) {
                count++;
            } else {
                if (count == 1) {
                    result.append(c);
                } else {
                    result.append(c);
                    result.append(count);
                }
                c = toCompressString.charAt(i);
                count = 1;
            }
        }
        return result.toString();
    }

    private static String makeAllLettersLow(String string) {

        char[] result = string.toCharArray();
        for (int i = 0; i < result.length; i++) {
            int value = result[i];
            if (value < ASCII_START) {
                value = value + 32;
                result[i] = (char) value;
            }
        }
        return new String(result);
    }

    private static int[] getLettersNumber(String string) {
        int[] result = new int[26];
        for (int i = 0; i < string.length(); i++) {
            int charValue = string.charAt(i);
            result[charValue - ASCII_START]++;
        }
        return result;
    }

    private static String replaceUnimportantSigns(String str) {
        String result =str.replaceAll("[\\p{Digit}]", "").replaceAll("[\\p{Space}]", "").replaceAll("[\\p{Punct}]", "");
        return result;
    }

    private static char[] addElement(char[] array, char element) {
        char[] tmp = new char[array.length+1];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        tmp[tmp.length-1] = element;
        return tmp;
    }
}
