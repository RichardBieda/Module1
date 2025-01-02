package Lesson17;

import java.util.*;

public class WordSuggestionApp {

    static {
        WordFinder.add(WordExample.LYRICS);
    }

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] x = WordFinder.getSuggest("b");
        System.out.println(Arrays.toString(x));
        System.out.println("--------------------------------------------");
        WordFinder.displayWordsAlphabetical();
    }
}
