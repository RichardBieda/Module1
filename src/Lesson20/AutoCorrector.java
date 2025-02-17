package Lesson20;

import java.util.Scanner;
//If you type a semicolon (;) on the end of your word e.g hallo; this word will be added to the dictionary
//If you type (end;) then the application will close and all inserted words will load to a dictionary file
//this tree structure works better with longer words or sentences
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
                }
                continue;
            }
            System.out.println(tree.getWordSuggests(word));
            tree.getTreeInfos();
        }
    }
}
