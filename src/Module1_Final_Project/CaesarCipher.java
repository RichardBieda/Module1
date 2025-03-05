package Module1_Final_Project;

import java.util.ArrayList;
import java.util.List;

final class CaesarCipher {

    static List<String> doDecryption(List<String> list, int key) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(decrypt(s, key));
        }
        return result;
    }

    static String decrypt(String text, int key) {
        return null;
    }

}
