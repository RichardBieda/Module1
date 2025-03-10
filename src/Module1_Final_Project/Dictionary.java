package Module1_Final_Project;

import java.io.IOException;
import java.util.*;

final class Dictionary {

    private final static String WORD_FILE = "File_Folder\\AutoCorrector\\dictWithCount";
    private final BFNode root;
    Dictionary() {
        root = new BFNode(' ');
        try {
            loadDictionaryToNodes(new FileManager(WORD_FILE, true).readFileContent());
        } catch (IOException e) {
            throw new IsNotRegularFileException("could not load file path : " + WORD_FILE);
        }
    }

    BFNode getRoot() {
        return root;
    }

    private void loadDictionaryToNodes(List<String> list) {
        for (String s : list) {
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
        int count = Integer.parseInt(strings[1]);

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
        tmpNode.setCount(count);
    }

    void checkMatch(int range) {

    }
}
