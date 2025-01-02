package Lesson17;

import java.util.*;

class WordFinder {

    final static Map<Character, Map<Integer, Set<String>>> words = new HashMap<>();

    static String[] getSuggest(String input) {
        input = input.toLowerCase().trim();
        Character firstLetter = input.charAt(0);
        String[] result = findSuggests(firstLetter, input);
        return result;
    }

    private static String[] findSuggests(Character firstLetter, String input) {
        Map<Integer, Set<String>> set = words.get(firstLetter);
        String[] result = new String[3];
        int count = 0;
        first:
        for (Map.Entry<Integer, Set<String>> pair : set.entrySet()) {
                for (String x : pair.getValue()) {
                    if (x.contains(input)) {
                        result[count++] = x;
                        if (count > 2) break first;
                    }
                }
        }
        return result;
    }

    static void add(String text) {
        String[] preparedText = prepareText(text);
        for (String word : preparedText) {
            addToWords(word);
        }
    }

    private static void addToWords(String input) {
            input = input.toLowerCase().trim();
            Character firstLetter = input.charAt(0);
            if (words.containsKey(firstLetter)) {
                for (Map.Entry<Integer, Set<String>> innerMap : words.get(firstLetter).entrySet()) {
                    if (innerMap.getValue().contains(input)) {
                        words.get(firstLetter).get(innerMap.getKey()).remove(input);
                        addWordToSet(firstLetter, input, innerMap.getKey());
                        if (innerMap.getValue().isEmpty()) {
                            words.get(firstLetter).remove(innerMap.getKey());
                        }
                        return;
                    }
                }
                if (words.get(firstLetter).containsKey(1)) {
                    words.get(firstLetter).get(1).add(input);
                } else {
                    Set<String> tmpSet = new HashSet<>();
                    tmpSet.add(input);
                    words.get(firstLetter).put(1, tmpSet);
                }
            } else {
                words.put(firstLetter, createOuterMapElements());
                addToWords(input);
            }
    }

    private static void addWordToSet(Character letter, String word, Integer index) {
        if (words.get(letter).containsKey(index +1)) {
            Set<String> tmpSet = words.get(letter).get(index +1);
            tmpSet.add(word);
            words.get(letter).put(index +1, tmpSet);
        } else {
            Set<String> tmpSet = new HashSet<>();
            tmpSet.add(word);
            words.get(letter).put(index +1, tmpSet);
        }
    }

    private static Map<Integer, Set<String>> createOuterMapElements() {
        Map<Integer, Set<String>> tmpMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        return tmpMap;
    }

    public static void displayWordsAlphabetical() {
        for (Map.Entry<Character, Map<Integer, Set<String>>> words : words.entrySet()) {
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

    public static void displayWords() {
        Map<Integer, Set<String>> map = createOuterMapElements();
        for (Map.Entry<Character, Map<Integer, Set<String>>> words : words.entrySet()) {
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

    private static String[] prepareText(String input) {
        String text = input.replaceAll("\\n", " ").replaceAll("( + )", " ");
        String text2 = text.replaceAll("′", "").replaceAll("[\\p{Punct}&&[^']]", "").replaceAll("(\\W')|('\\W)", " ");
        return text2.split(" ");
    }
}
