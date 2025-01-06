package Lesson17;

import java.util.*;

final class WordSuggestionApp {
    /*
    * At first, you will be asked to add a dictionary to the app. if you want that then press 1, if not press any other key.
    * start typing and press enter, so you get to the suggests and settings menu. If you want to use suggests or settings press the number keys, if not press enter or any other key.
    * and so on.
    *
    * In the suggests menu:
    * numbers 1, 2, 3 are for the suggests, if available.
    * 4 adds your sentence to an arraylist (this is your course), simultaneously the words are added and counted in the dictionary.
    * 5 removes your last char.
    * 6 clears your present line.
    * 7 shows your course.
    * 8 opens the settings menu.
    *
    * inside the settings menu:
    * 1 deletes or inserts the dictionary.
    * 2 shows the word count of Lorem Ipsum.
    * 3 shows your present dictionary in alphabetical order.
    * 4 closes the application.
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
            sentence = setSuggests(sentence);
            System.out.print("write : " + sentence);
        }
        scanner.close();
        System.out.println("\nyour chat course\n----------------");
        getCourse();
    }

    private static void displaySuggests(String[] suggests) {
        for (int i = 0; i < suggests.length; i++) {
            if (suggests[i] != null) {
                System.out.printf("[ %d ] %s ",i+1 , suggests[i]);
            } else {
                System.out.printf("[ %d ] no suggests found ",i+1);
            }
        }
        System.out.println("\n[ 4 ] send message [ 5 ] remove [ 6 ] clear [ 7 ] course [ 8 ] settings");
    }

    private static String setSuggests(String text) {
        String assigningPart = text.replaceAll(".+ ", "");
        String leftPart = text.replaceAll("( \\w+)$|(^\\w+)$", "");
        String preText = leftPart.isEmpty() ? "" : leftPart + " ";
        String[] suggests = WordFinder.getSuggest(assigningPart);
        displaySuggests(suggests);
        System.out.print("choose: ");
        String settings = scanner.nextLine();
        if (settings.equals("1") && suggests[0] != null) {
            return preText + suggests[0];
        } else if (settings.equals("2") && suggests[1] != null) {
            return preText + suggests[1];
        } else if (settings.equals("3") && suggests[2] != null) {
            return preText + suggests[2];
        } else if (settings.equals("4")) {
            if (!text.isEmpty()) {
                WordFinder.add(text, WordFinder.suggestsMap);
            }
            sentences.add(text);
            return "";
        } else if (settings.equals("5")) {
            return text.substring(0, text.length() -1);
        } else if (settings.equals("6")) {
            return "";
        } else if (settings.equals("7")) {
            getCourse();
            return text;
        } else if (settings.equals("8")) {
            getSettings();
            return text;
        } else {
            return text;
        }
    }

    private static void getSettings() {
        String dict = isDictionaryAdded ? "delete dictionary" : "insert dictionary";
        System.out.printf("Settings menu:\n[ 1 ] %s [ 2 ] display Lorem Ipsum [ 3 ] show dictionary [ 4 ] close App\n",dict);
        String settings = scanner.nextLine();
        if (settings.equals("1")) {
            if (isDictionaryAdded) {
                WordFinder.suggestsMap.clear();
                isDictionaryAdded = false;
            } else {
                WordFinder.add(WordExample.DICTIONARY, WordFinder.suggestsMap);
                isDictionaryAdded = true;
            }
        } else if (settings.equals("2")) {
            getLoremIpsum();
        } else if (settings.equals("3")) {
            WordFinder.displayWordsAlphabetical(WordFinder.suggestsMap);
        } else if (settings.equals("4")) {
            isAppOpen = false;
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
        System.out.print("write: ");
    }

    private static void getCourse() {
        for (String s : sentences) {
            System.out.println(s);
        }
    }

    private static void getLoremIpsum() {
        Map<Character, Map<Integer, Set<String>>> loremIpsumMap = new HashMap<>();
        WordFinder.add(WordExample.LOREM_IPSUM, loremIpsumMap);
        WordFinder.displayWords(loremIpsumMap);
    }
}
