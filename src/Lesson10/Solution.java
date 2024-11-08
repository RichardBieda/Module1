package Lesson10;
//        1. Find and return the most common letter in a given string.
//        2. Check if 2 strings are anagrams of each other (below - elbow, end - ned, apple - ppale)
//        3. Compress a string using the following rule: aaabccc = a3bc3
public class Solution {

    public static void main(String[] args) {
        char mostCommonLetter = getMostCommonLetter("What is the most common letter here?");
        System.out.println(mostCommonLetter);
    }

    //This method returns the letter that is most frequently in the given string. If several letters occur equally often,
    //then the first in order will return
    static char getMostCommonLetter(String str) {
        if (str == null || str.isEmpty()) {
            return '0';
        }

        String str1 = str.replaceAll("[\\d]", "").replaceAll("[\\p{Space}]", "").replaceAll("[\\p{Punct}]", "");
        if (str1.isEmpty()) {
            return '0';
        }

        String tmp = str1.toLowerCase();
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
}
