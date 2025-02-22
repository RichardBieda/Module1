package Module1_Final_Project;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '!', '?', ',', '.','0','1','2','3','4','5','6','7','8','9'));
    static int length = alphabet.size();

    public static void main(String[] args) {

        System.out.println(encrypt("bb", 1));
    }

    static String encrypt(String input, int code) {
        if (code == 0) {
            return input;
        }
        if (code < 0) {
            code = ~code+1;
        }
        while (code > length) {
            code %= length;
        }

        char[] wordChar = input.toCharArray();

        for (int i = 0; i < wordChar.length; i++) {
            int oldValue = alphabet.indexOf(wordChar[i]);
            int index = (oldValue + code + i) % length;
            wordChar[i] = alphabet.get(index);
        }
        String result = new String(wordChar);
        return result;
    }

    static void decrypt(String input) {
        char[] suggest = input.toCharArray();
        int[] counter = new int[input.length()];

        while (counter[counter.length-1] < length && counter[0] < length) {

            System.out.println(suggest);
        }
    }

}
