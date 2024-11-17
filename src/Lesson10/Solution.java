package Lesson10;

import java.util.Arrays;

//        1. Find and return the most common letter in a given string.
//        2. Check if 2 strings are anagrams of each other (below - elbow, end - ned, apple - ppale)
//        3. Compress a string using the following rule: aaabccc = a3bc3
public class Solution {

    public static void main(String[] args) {
        char mostCommonLetter = getMostCommonLetter("aaattcccdad");
        System.out.println(mostCommonLetter);

        boolean isAnagram = isAnagram("apple", "ppale");
        System.out.println(isAnagram);

        String compress = compress("aaabcccaaa");
        System.out.println(compress);
    }

    //This method returns the letter that is most frequently in the given string. If several letters occur equally often,
    //then the first in order will return
    static char getMostCommonLetter(String str) {
        if (str == null || str.isEmpty()) {
            return '0';
        }

        String tmp = replaceUnimportantSigns(str).toLowerCase();
        if (tmp.isEmpty()) {
            return '0';
        }

        char result = '0';
        int maxCount = 0;
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            int count = 0;
            for (int j = 0; j < tmp.length(); j++) {
                if (c == tmp.charAt(j)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                result = c;
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
        char[] a = str1.toLowerCase().toCharArray();
        char[] b = str2.toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return "0";
        }
        String str1 = replaceUnimportantSigns(str).toLowerCase();
        char[] tmp = str1.toCharArray();
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tmp.length;) {
            int count = 0;
            for (int j = i; j < tmp.length; j++) {
                if (tmp[j] == tmp[i]) {
                    count++;
                }
            }
            if (count == 1) {
                sb.append("" + tmp[i]);
            } else if (count > 1) {
                sb.append("" + tmp[i] + count);
            }
            i = i + count;
        }


        return sb.toString();
    }

    static String replaceUnimportantSigns(String str) {
        String result =str.replaceAll("[\\p{Digit}]", "").replaceAll("[\\p{Space}]", "").replaceAll("[\\p{Punct}]", "");
        return result;
    }
}
