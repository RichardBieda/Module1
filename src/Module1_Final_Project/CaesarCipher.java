package Module1_Final_Project;

import java.util.*;

final class CaesarCipher {

    private final static Character[] CRYPTO_ALPHABET = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '!', '?', ',', '.', '\'', ':','0','1','2','3','4','5','6','7','8','9'};
    private static final Set<Character> CRYPTO_SET = new HashSet<>();
    private final static int LENGTH = CRYPTO_ALPHABET.length;

    static {
        Collections.addAll(CRYPTO_SET, CRYPTO_ALPHABET);
    }

    static List<String> doDecryption(List<String> list, int key) {
        List<String> result = new ArrayList<>();
        int i = 1;
        for (String s : list) {
            if (!isValidString(s)) {
                System.out.printf("String %d, has not valid signs\n", i);
                continue;
            }
            result.add(decrypt(s, key));
        }
        return result;
    }

    static String decrypt(String text, int key) {
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {

        }
        return null;
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
