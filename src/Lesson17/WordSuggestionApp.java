package Lesson17;

import java.util.*;

final class WordSuggestionApp {
    /*
    * At first, you will be asked to add a dictionary to the app. if you want that then press 1, if not press any other key.
    * start typing and press enter, so you get to the suggests and settings menu. If you want to use suggests or settings press the number keys, if not press enter or any other key.
    * and so on.
    *
    * In the suggests and settings menu:
    * numbers 1, 2, 3 are for the suggests, if available.
    * 4 adds your sentence to an arraylist (this is your course), simultaneously the words are added and counted in the dictionary.
    * 5 loads and displays the word count of lorem ipsum.
    * 6 closes this application.
    * 7 inserts your dictionary, if it would not inserted at the beginning.
    */

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> sentences = new ArrayList<>();
    private static String sentence = "";
    private static boolean isAppOpen = true;
    private static boolean isDictionaryAdded = false;

    public static void main(String[] args) {

        startText();
        while (isAppOpen) {
            sentence += scanner.nextLine();
            if (sentence.isEmpty() || sentence.endsWith(" ")) {
                System.out.print(sentence);
                continue;
            }
            sentence = setSuggests(sentence);
            System.out.print(sentence);
        }
        scanner.close();
        System.out.println("\nyour char course\n----------------");
        for (String s : sentences) {
            System.out.println(s);
        }
    }

    private static void displaySuggests(String[] suggests) {
        for (int i = 0; i < suggests.length; i++) {
            if (suggests[i] != null) {
                System.out.printf("[ %d ] %s ",i+1 , suggests[i]);
            } else {
                System.out.printf("[ %d ] no suggests found ",i+1);
            }
        }
        String addDictionary = isDictionaryAdded ? "" : " [ 7 ] add dictionary";
        System.out.printf("\n[ 4 ] send message [ 5 ] display word count of lorem ipsum [ 6 ] close%s\n", addDictionary);
    }

    private static String setSuggests(String text) {
        String assigningPart = text.replaceAll(".+ ", "");
        String leftPart = text.replaceAll("( \\w+)$|(^\\w+)$", "");
        String preText = leftPart.isEmpty() ? "" : leftPart + " ";
        String[] suggests = WordFinder.getSuggest(assigningPart);
        displaySuggests(suggests);
        String settings = scanner.nextLine();
        if (settings.equals("1") && suggests[0] != null) {
            return preText + suggests[0];
        } else if (settings.equals("2") && suggests[1] != null) {
            return preText + suggests[1];
        } else if (settings.equals("3") && suggests[2] != null) {
            return preText + suggests[2];
        } else if (settings.equals("4")) {
            WordFinder.add(text, WordFinder.suggestsMap);
            sentences.add(text);
            sentence = "";
            return "";
        } else if (settings.equals("5")) {
            getLoremIpsum();
            return text;
        } else if (settings.equals("6")) {
            isAppOpen = false;
            return text;
        } else if (settings.equals("7") && !isDictionaryAdded) {
            WordFinder.add(WordExample.DICTIONARY, WordFinder.suggestsMap);
            isDictionaryAdded = true;
            return text;
        } else {
            return text;
        }
    }

    private static void startText() {
        System.out.println("Do you want to insert a dictionary?\n" +
                "Press [ 1 ] for YES, or just [ enter ] for NO");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            WordFinder.add(WordExample.DICTIONARY, WordFinder.suggestsMap);
            isDictionaryAdded = true;
        }
        System.out.println("Start typing");
    }

    private static void getLoremIpsum() {
        Map<Character, Map<Integer, Set<String>>> loremIpsumMap = new HashMap<>();
        WordFinder.add(WordExample.LOREM_IPSUM, loremIpsumMap);
        WordFinder.displayWords(loremIpsumMap);
    }
}
