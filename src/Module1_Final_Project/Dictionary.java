package Module1_Final_Project;

import java.io.IOException;
import java.util.*;

final class Dictionary {

    private final static String WORD_FILE = "File_Folder\\AutoCorrector\\dictWithCount";

    private Set<Character> alphabetSet;
    private final BFNode root;
    private final Statistic statistic;

    Dictionary() {
        alphabetSet = new HashSet<>();
        root = new BFNode(' ');
        try {
            loadDictionaryToNodes(new FileManager(WORD_FILE, true).readFileContent());
        } catch (IOException e) {
            throw new IsNotRegularFileException("could not load file path : " + WORD_FILE);
        }
        this.statistic = new Statistic();
    }

    void getStats() {
        System.out.println(statistic.getResults());
        System.out.println("suggests: " + statistic.getSuggests());
    }

    private void loadDictionaryToNodes(List<String> list) {
        for (String x : list) {
            String s = x.toLowerCase();
            if (!CaesarCipher.isValidString(s)) {
                System.out.println("invalid string");
                continue;
            }
            setNodes(s);
        }
    }

    private void setNodes(String text) {
        String[] strings = text.split(" {3}");
        char[] input = strings[0].toCharArray();
        int count;
        try {
            count = Integer.parseInt(strings[1]);
        } catch (NumberFormatException e) {
            count = 1000;
        }

        BFNode tmpNode = root;
        for (int i = 0; i < input.length; i++) {
            tmpNode.setChildrenIfAbsent();
            if (tmpNode.getChildren().containsKey(input[i])) {
                tmpNode = tmpNode.getChildren().get(input[i]);
            } else {
                tmpNode.getChildren().put(input[i], new BFNode(input[i]));
                tmpNode = tmpNode.getChildren().get(input[i]);
            }
            alphabetSet.add(input[i]);
        }
        tmpNode.setIsWord(true);
        tmpNode.setCount(count);
    }

    void checkMatch(char[] input, int range, int encryptedStringLength) {
        char[] result = new char[range];
        BFNode tmpNode = root;
        for (int i = 0; i < range; i++) {
            if (tmpNode.getChildren() != null && tmpNode.getChildren().containsKey(input[i])) {
                tmpNode = tmpNode.getChildren().get(input[i]);
                result[i] = tmpNode.getSign();
            } else {
                return;
            }
        }
        Stack<BFNode> nodeStack = new Stack<>();
        nodeStack.push(tmpNode);
        searchThroughLevels(result, nodeStack, encryptedStringLength);
    }

    void searchThroughLevels(char[] result, Stack<BFNode> nodes, int encryptedWordLength) {
        BFNode tmpNode = nodes.pop();
        if (tmpNode.isWord() && result.length == encryptedWordLength) {
            statistic.insertResult(result, tmpNode.getCount());
            tmpNode.setIsWord(false);
        }
        if (result.length > encryptedWordLength || tmpNode.getChildren() == null) {
            return;
        }
        for (Character c : tmpNode.getChildren().keySet()) {
            char[] tmpChar = Arrays.copyOf(result, result.length +1);
            tmpChar[tmpChar.length-1] = c;
            nodes.push(tmpNode.getChildren().get(c));
            searchThroughLevels(tmpChar, nodes, encryptedWordLength);
        }
    }

    Set<Character> getAlphabetSet() {
        return alphabetSet;
    }
}
