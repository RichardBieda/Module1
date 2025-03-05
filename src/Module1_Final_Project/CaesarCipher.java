package Module1_Final_Project;

import java.util.*;

final class CaesarCipher {

    private final static Character[] CRYPTO_ALPHABET = new Character[] {',','j','p','8','h',':','!','c','y','t','4',' ','m','2','v','e','.','a','g','6','0','k','r','z','d','o','\'','w','b','f','q','7','?','n','u','3','s','i','1','x','9','l','5'};
    private static final Set<Character> CRYPTO_SET = new HashSet<>();
    private final static int LENGTH = CRYPTO_ALPHABET.length;

    static {
        Collections.addAll(CRYPTO_SET, CRYPTO_ALPHABET);
    }

    static List<String> doDecryption(List<String> list, int key) {
        key = key % LENGTH;
        List<String> result = new ArrayList<>();
        int i = 1;
        for (String s : list) {
            if (!isValidString(s)) {
                System.out.printf("String %d, has not valid signs\n", i);
                i++;
                continue;
            }
            result.add(decryptFile(s, key));
            i++;
        }
        return result;
    }

    private static String decryptFile(String text, int key) {
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            int index = (getIndex(textArr[i]) + (LENGTH - key)) % LENGTH;
            textArr[i] = CRYPTO_ALPHABET[index];
        }
        return String.valueOf(textArr);
    }

    private static int getIndex(char c) {
        int result = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (c == CRYPTO_ALPHABET[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    static boolean isValidString(String text) {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (!CRYPTO_SET.contains(textArray[i])) {
                return false;
            }
        }
        return true;
    }
}
