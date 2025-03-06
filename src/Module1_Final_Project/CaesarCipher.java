package Module1_Final_Project;

import java.util.*;

final class CaesarCipher {

    final static String ALPHABET = "abcdefghijklmnopqrstuvmxyz !?,.':0123456789";
    private final static Character[] CRYPTO_ALPHABET = new Character[] {',','j','p','8','h',':','!','c','y','t','4',' ','m','2','v','e','.','a','g','6','0','k','r','z','d','o','\'','w','b','f','q','7','?','n','u','3','s','i','1','x','9','l','5'};
    private static final Set<Character> CRYPTO_SET = new HashSet<>();
    final static int LENGTH = CRYPTO_ALPHABET.length;

    static {
        Collections.addAll(CRYPTO_SET, CRYPTO_ALPHABET);
    }

    private final int KEY;
    private final List<String> INPUT_LIST;
    private final List<String> OUTPUT_LIST;

    CaesarCipher(int key, List<String> input) {
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
            OUTPUT_LIST.add(decryptFile(s));
            i++;
        }
        return OUTPUT_LIST;
    }

    private String decryptFile(String text) {
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
            OUTPUT_LIST.add(encryptFile(s));
            i++;
        }
        return OUTPUT_LIST;
    }

    private String encryptFile(String text) {
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            int index = (getIndex(textArr[i]) + KEY) % LENGTH;
            textArr[i] = CRYPTO_ALPHABET[index];
        }
        return String.valueOf(textArr);
    }

    private int getIndex(char c) {
        int result = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (c == CRYPTO_ALPHABET[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean isValidString(String text) {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (!CRYPTO_SET.contains(textArray[i])) {
                return false;
            }
        }
        return true;
    }
}
