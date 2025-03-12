package Module1_Final_Project;

import java.util.Arrays;
import java.util.Objects;

final class BruteForce {

    //private static final char[] ALPHA = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','m','x','y','z',' ','!','?',',','.','\'',':','0','1','2','3','4','5','6','7','8','9'};
    private final Dictionary DICTIONARY;
    private final char[] ALPHA;
    private final int LENGTH;
    private int range;
    private final String ENCRYPTED_STRING;

   BruteForce(String encryptedString, int range) {
        this.DICTIONARY = new Dictionary();
        ALPHA = getALPHAArray();
        LENGTH = ALPHA.length;
        this.range = range;
        ENCRYPTED_STRING = encryptedString;
        doBruteForce();
        show();
    }

    private void doBruteForce() {
        char[] finish = ENCRYPTED_STRING.toCharArray();
        char[] input = ENCRYPTED_STRING.toCharArray();
        range = Math.min(range, input.length);
        int[] combination = getIndexInAlpha(input);

            do {
                for (int i = 0; i < LENGTH; i++) {
                    DICTIONARY.checkMatch(input, range, ENCRYPTED_STRING.length());
                    input[0] = ALPHA[(++combination[0]) % LENGTH];
                }
                combination[0] -= LENGTH;
                for (int i = 1; i < range; i++) {
                    input[i] = ALPHA[++combination[i] % LENGTH];
                    if (input[i] != ENCRYPTED_STRING.charAt(i)) {
                        break;
                    }
                    combination[i] -= LENGTH;
                }
            } while (!Arrays.equals(input, finish));
    }

    private int[] getIndexInAlpha(char[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = getIndex(input[i]);
        }
        return result;
    }

    int getIndex(char c) {
        int result = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (c == ALPHA[i]) {
                result = i;
                break;
            }
        }
        return result;
   }

    private char[] getALPHAArray() {
        char[] result = new char[DICTIONARY.getAlphabetSet().size()];
        int i = 0;
        for (char c : DICTIONARY.getAlphabetSet()) {
            result[i++] = c;
        }
        System.out.println(result);
        return result;
    }

    private void show() {
        DICTIONARY.getStats();
    }

}
