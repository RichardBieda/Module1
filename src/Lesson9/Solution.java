package Lesson9;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        boolean isPalindrome = isPalindrome("Lagerregal");
        System.out.println("Is palindrome = " + isPalindrome);

        String test = "Hallo i am a string.";
        String reversedString = reverseWords(test);
        System.out.println(test + "\n" + reversedString);

        String[] prefix = {"apple", "application", "ape"};
        System.out.println("The longest common prefix is : " + getLongestPrefix(prefix));
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {                                    //Tests whether a string is empty or null
            return false;
        }

        String lowStr = str.toLowerCase();                                     //Converts all letters to lower letters
                                                                               //compares the first char+i  with the last char-i in a string.
        for (int i = 0; i < lowStr.length() /2; i++) {                         //compares the first char+i  with the last char-i in a string.
            char a = lowStr.charAt(i);
            char b = lowStr.charAt(lowStr.length() -1 -i);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    static String reverseWords(String string) {
        if (string == null || string.isEmpty()) {                  //Null and empty test
            return "";
        }

        String[] strArray = string.split(" ");               //Splits the string, and in the for loop it creates a new string in reversed order
        String result = "";
        for (int i = strArray.length -1; i >= 0 ; i--) {
            result += strArray[i] + " ";
        }
        return result;
    }

    static String getLongestPrefix(String[] array) {
        if (array == null || array.length == 0) {                    //Tests if the array is null or too short. Searching for a prefix from just one word makes no sence
            return "NullPointerOrEmptinessException";
        } else if (array.length == 1) {
            return array[0];
        }

        int index = 0;                                              //This loop searches for the shortest element for iteration. The common prefix can't be longer than the shortest word
        for (int i = 0; i < array.length; i++) {                    //index is the index of the shortest element
            if (array[i] == null || array[i].isEmpty()) {           //Tests the elements for null or emptiness
                return "NullPointerOrEmptinessException";
            }
            if (array[i].length() < array[index].length()) {
                index = i;
            }
        }

        String prefix = "";                                         //prefix is the result
        char[] shortestElement = array[index].toCharArray();        //creates a char[] for iteration and comparing
        boolean isStopped = false;                                  //isStopped stops the loop by the first negative comparison
        for (int i = 0; i < shortestElement.length; i++) {          //the first loop gives the char to compare
            char c = shortestElement[i];
            for (int j = 0; j < array.length; j++) {                //the second loop iterates the array elements
                if (array[j].charAt(i) != c) {
                    isStopped = true;
                }
            }
            if (isStopped) {
                break;
            }
            prefix += c;
        }
        return prefix;
    }
}
