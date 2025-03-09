package Module1_Final_Project.BruteForce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class Dictionary {

    private final static Set<Character> CRYPTO_ALPHABET = new HashSet();
    static {
        Collections.addAll(CRYPTO_ALPHABET, 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','!','?',',','.','\'',':',';','-','+','*','/','%','(',')','0','1','2','3','4','5','6','7','8','9');
    }
    private final BFNode root;
    private final String DICTIONARY_PATH;
    Dictionary(String dictionaryPath) {
        root = new BFNode(' ');
        DICTIONARY_PATH = dictionaryPath;
        loadDictionaryToNodes(readDictionaryFile());
    }

    private List<String> readDictionaryFile() {
        List<String> resultList = new ArrayList<>();
        try {
            resultList = Files.readAllLines(Path.of(DICTIONARY_PATH));
        } catch (IOException e) {
            //implement exception handling
        }
        return resultList;
    }

    private void loadDictionaryToNodes(List<String> list) {
        for (String s : list) {
            if (!isValidString(s)) {
                System.out.println("invalid string");
                continue;
            }
            char[] tmpArray = s.toCharArray();
            setNodes(tmpArray);
        }
    }

    private void setNodes(char[] input) {
        BFNode tmpNode = root;
        for (int i = 0; i < input.length; i++) {
            tmpNode.setChildrenIfAbsent();
            if (tmpNode.getChildren().containsKey(input[i])) {
                tmpNode = tmpNode.getChildren().get(input[i]);
            } else {
                tmpNode.getChildren().put(input[i], new BFNode(input[i]));
                tmpNode = tmpNode.getChildren().get(input[i]);
            }
        }
        tmpNode.setIsWord(true);
    }

    private boolean isValidString(String input) {
        String text = input.toLowerCase();
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (!CRYPTO_ALPHABET.contains(textArray[i])) {
                return false;
            }
        }
        return true;
    }
}
