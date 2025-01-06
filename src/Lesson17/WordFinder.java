package Lesson17;

import java.util.*;

final class WordFinder {

    final static Map<Character, Map<Integer, Set<String>>> suggestsMap = new TreeMap<>();

    static String[] getSuggest(String input) { //this method returns an array with 3 suggests
        if (input.isEmpty()) {
            return new String[3];
        }
        input = input.toLowerCase().trim();
        Character firstLetter = input.charAt(0);
        return findSuggests(firstLetter, input);
    }

    private static String[] findSuggests(Character firstLetter, String input) { //this method finds the suggests in the suggestsMap
        if (!suggestsMap.containsKey(firstLetter)) {
            return new String[3];
        }
        String[] result = new String[3];
        int count = 0;
        first:
        for (Map.Entry<Integer, Set<String>> pair : suggestsMap.get(firstLetter).entrySet()) {
                for (String x : pair.getValue()) {
                    if (x.startsWith(input)) {
                        result[count++] = x;
                        if (count > 2) {
                            return result;
                        }
                    }
                }
        }
        return result;
    }

    static void add(String text, Map<Character, Map<Integer, Set<String>>> mainMap) {//prepares text to work with them in addToWords
        String[] preparedText = prepareWords(text);
        for (String word : preparedText) {
            addToSuggestsMap(word, mainMap);
        }
    }

    private static void addToSuggestsMap(String input, Map<Character, Map<Integer, Set<String>>> mainMap) {//adds words the suggestsMap by its first letter and frequency
            input = input.toLowerCase().trim();
            Character firstLetter = input.charAt(0);
            if (mainMap.containsKey(firstLetter)) {
                for (Map.Entry<Integer, Set<String>> innerMap : mainMap.get(firstLetter).entrySet()) {
                    if (innerMap.getValue().contains(input)) {
                        mainMap.get(firstLetter).get(innerMap.getKey()).remove(input);
                        addWordToSet(firstLetter, input, innerMap.getKey(), mainMap);
                        if (innerMap.getValue().isEmpty()) {
                            mainMap.get(firstLetter).remove(innerMap.getKey());
                        }
                        return;
                    }
                }
                if (mainMap.get(firstLetter).containsKey(1)) {
                    mainMap.get(firstLetter).get(1).add(input);
                } else {
                    Set<String> tmpSet = new HashSet<>();
                    tmpSet.add(input);
                    mainMap.get(firstLetter).put(1, tmpSet);
                }
            } else {
                mainMap.put(firstLetter, new TreeMap<Integer, Set<String>>(Comparator.reverseOrder()));
                addToSuggestsMap(input, mainMap);
            }
    }

    private static void addWordToSet(Character letter, String word, Integer index, Map<Character, Map<Integer, Set<String>>> mainMap) {//prevents double counting and inserts words to the right sets
        if (mainMap.get(letter).containsKey(index +1)) {
            Set<String> tmpSet = mainMap.get(letter).get(index +1);
            tmpSet.add(word);
            mainMap.get(letter).put(index +1, tmpSet);
        } else {
            Set<String> tmpSet = new HashSet<>();
            tmpSet.add(word);
            mainMap.get(letter).put(index +1, tmpSet);
        }
    }

    static void displayWordsAlphabetical(Map<Character, Map<Integer, Set<String>>> mainMap) {
        for (Map.Entry<Character, Map<Integer, Set<String>>> words : mainMap.entrySet()) {
            System.out.println(words.getKey() + "--------------------");
            for (Map.Entry<Integer, Set<String>> pair : words.getValue().entrySet()) {
                System.out.print(pair.getKey() + " ");
                for (String x : pair.getValue()) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }

    static void displayWords(Map<Character, Map<Integer, Set<String>>> mainMap) {
        Map<Integer, Set<String>> map = new TreeMap<Integer, Set<String>>(Comparator.reverseOrder());
        for (Map.Entry<Character, Map<Integer, Set<String>>> words : mainMap.entrySet()) {
            for (Map.Entry<Integer, Set<String>> pair : words.getValue().entrySet()) {
                if (map.containsKey(pair.getKey())) {
                    Set<String> tmp = map.get(pair.getKey());
                    tmp.addAll(pair.getValue());
                    map.put(pair.getKey(), tmp);
                } else {
                    map.put(pair.getKey(), pair.getValue());
                }
            }
        }
        for (Map.Entry<Integer, Set<String>> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " ---------");
            for (String s : pair.getValue()) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String[] prepareWords(String input) {
        String text = input.replaceAll("\\n", " ").replaceAll("( + )", " ");
        String text2 = text.replaceAll("[\\W&&[^' ]]", "").replaceAll("(\\W')|('\\W)", " ");
        //String text2 = text.replaceAll("[”“’‘′]", "").replaceAll("[\\p{Punct}&&[^']]", "").replaceAll("(\\W')|('\\W)", " ");
        return text2.split(" ");
    }
}
