package AutoCorrector;

import java.util.Scanner;

public class AutoCorrector {

    private final Scanner scanner = new Scanner(System.in);
    private final BKTree tree;

    public AutoCorrector(String dictionary) {
        tree = new BKTree(dictionary);
        startSpellings();
    }
    public AutoCorrector(String dictionary, int tolerance) {
        tree = new BKTree(dictionary, tolerance);
        startSpellings();
    }

    private void startSpellings() {
        String word = "";
        while (true) {
            word = scanner.nextLine();
            if (word.equalsIgnoreCase("end;")) {
                tree.saveDictionary();
                break;
            } else if (word.charAt(word.length()-1) == ';') {
                String newWord = word.substring(0, word.length()-1);
                boolean isAdded = tree.add(newWord);
                if (isAdded) {
                    tree.addToNewWords(newWord);
                    System.out.println(newWord + " is added to dictionary");
                } else {
                    System.out.println(newWord + " was already in dictionary");
                }
                continue;
            }
            System.out.println(tree.getWordSuggests(word));
            tree.getTreeInfos();
        }
    }
}
