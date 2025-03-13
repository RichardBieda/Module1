package Module1_Final_Project;

import java.util.Arrays;

final class BruteForce {

    private final Dictionary DICTIONARY;
    private final char[] ALPHA;
    private final int LENGTH;
    private int range;
    private String encryptedString;

   BruteForce() {
        this.DICTIONARY = new Dictionary();
        ALPHA = getAlphaArray();
        LENGTH = ALPHA.length;
    }

    void setRange(int range) {
       this.range = range;
    }

    void setEncryptedString(String encryptedString) {
       this.encryptedString = encryptedString;
    }

    String getAlpha() {
       return String.valueOf(ALPHA);
    }

    void doBruteForce() {
        char[] input = encryptedString.toCharArray();
        range = Math.min(range, input.length);
        int[] combination = getIndexInAlpha(input);
        char[] finish = Arrays.copyOf(input, input.length);

            do {
                for (int i = 0; i < LENGTH; i++) {
                    DICTIONARY.checkMatch(input, range, encryptedString.length());
                    input[0] = ALPHA[(++combination[0]) % LENGTH];
                }
                combination[0] -= LENGTH;
                for (int i = 1; i < range; i++) {
                    input[i] = ALPHA[++combination[i] % LENGTH];
                    if (input[i] != encryptedString.charAt(i)) {
                        break;
                    }
                    combination[i] -= LENGTH;
                }
            } while (!Arrays.equals(input, finish));
            show();
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

    private char[] getAlphaArray() {
        char[] result = new char[DICTIONARY.getAlphabetSet().size()];
        int i = 0;
        for (char c : DICTIONARY.getAlphabetSet()) {
            result[i++] = c;
        }
        return result;
    }

    private void show() {
        DICTIONARY.getStats();
    }

    boolean isValidString(String input) {
        char[] textArray = input.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (!DICTIONARY.getAlphabetSet().contains(textArray[i])) {
                return false;
            }
        }
        return true;
    }
}
