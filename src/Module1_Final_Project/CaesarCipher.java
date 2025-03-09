package Module1_Final_Project;

import java.util.*;

final class CaesarCipher {

    final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz !?,.':0123456789";
    private final static Character[] CRYPTO_ALPHABET = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','!','?',',','.','\'',':',';','-','+','*','/','%','(',')','0','1','2','3','4','5','6','7','8','9'};
    private final static Set<Character> CRYPTO_SET = new HashSet<>();
    private final static int LENGTH = CRYPTO_ALPHABET.length;

    static {
        Collections.addAll(CRYPTO_SET, CRYPTO_ALPHABET);
    }

    private final int KEY;
    private final List<String> INPUT_LIST;
    private final List<String> OUTPUT_LIST;

    CaesarCipher(int key, List<String> input) {
        key %= LENGTH;
        this.KEY = key;
        this.INPUT_LIST = new ArrayList<>(input);
        this.OUTPUT_LIST = new ArrayList<>();
    }

    List<String> doDecryption() {
        int i = 1;
        for (String s : INPUT_LIST) {
            if (!isValidString(s)) {
                System.out.printf("String %d, has not valid signs\n", i);
                i++;
                continue;
            }
            OUTPUT_LIST.add(decrypt(s));
            i++;
        }
        return OUTPUT_LIST;
    }

    private String decrypt(String text) {
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            int index = (getIndex(textArr[i]) + (LENGTH - KEY)) % LENGTH;
            textArr[i] = CRYPTO_ALPHABET[index];
        }
        return String.valueOf(textArr);
    }

    List<String> doEncryption() {
        int i = 1;
        for (String s : INPUT_LIST) {
            if (!isValidString(s)) {
                System.out.printf("String %d, has not valid signs\n", i);
                i++;
                continue;
            }
            OUTPUT_LIST.add(encrypt(s));
            i++;
        }
        return OUTPUT_LIST;
    }

    private String encrypt(String text) {
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            int index = (getIndex(textArr[i]) + KEY) % LENGTH;
            textArr[i] = CRYPTO_ALPHABET[index];
        }
        return String.valueOf(textArr);
    }

    static int getIndex(char c) {
        int result = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (c == CRYPTO_ALPHABET[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    static boolean isValidString(String input) {
        String text = input.toLowerCase();
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (!CRYPTO_SET.contains(textArray[i])) {
                return false;
            }
        }
        return true;
    }
}
