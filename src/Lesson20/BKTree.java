package Lesson20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

//This is an implementation of a Burkhard Keller Tree, the first Node to be added is the root
//Nodes have a String word field
//Nodes have a Map of children, this map stores the edit-distance between root and child as key and the childNode itself as value
//Every childMap stores only one Node per key, if (edit-distance thus key) of a second Node is equal, then it become a child of the child.
//line 116 is important for the search results. Decreasing the range means to get faster results, but you will lose precision
class BKTree {

    private final static int STANDARD_TOLERANCE = 2;
    private final String dictionary;

    private final Set<String> newWords;

    private Node root;

    private final int tolerance;

    private int queries = 0;

    private int suggests = 0;

    private int wordCount = 0;

    private Duration time;

    BKTree(String dictionary) {
        this.dictionary = dictionary;
        this.newWords = new HashSet<>();
        this.tolerance = STANDARD_TOLERANCE;
        loadDictionary();
        System.out.println(wordCount + " Strings added to dictionary");
    }
    BKTree(String dictionary, int tolerance) {
        this.dictionary = dictionary;
        this.newWords = new HashSet<>();
        this.tolerance = tolerance;
        loadDictionary();
        System.out.println(wordCount + " Strings added to dictionary");
    }

    boolean add(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("The given input(word) is invalid");
        }
        String word = input.toLowerCase();
        if (root == null) {
            root = new Node(word);
            wordCount++;
            return true;
        }
        Node tmpNode = root;
        while (true) {
            int distance = EditingDistance.distance2(word, tmpNode.word);
            if (distance == 0) {
                return false;
            }
            if (tmpNode.children == null) {
                tmpNode.children = new HashMap<>();
                tmpNode.children.put(distance, new Node(word));
                wordCount++;
                return true;
            } else {
                if (tmpNode.children.containsKey(distance)) {
                    tmpNode = tmpNode.children.get(distance);
                } else {
                    tmpNode.children.put(distance, new Node(word));
                    wordCount++;
                    return true;
                }
            }
        }
    }

    Map<Integer, List<String>> getWordSuggests(String input) {
        String word = input.toLowerCase();
        Map<Integer, List<String>> results = new HashMap<>();
        if (root == null) return results;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        Instant start = Instant.now();
        searchWordsThroughLevels(results, nodeStack, word);
        Instant end = Instant.now();
        time = Duration.between(start, end);
        return results;
    }

    private void searchWordsThroughLevels(Map<Integer, List<String>> map, Stack<Node> stack, String word) {
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            int distance = EditingDistance.distance2(word, tmpNode.word);
            queries++;
            if (distance <= tolerance && distance > 0) {
                if (map.containsKey(distance)) {
                    map.get(distance).add(tmpNode.word);
                    suggests++;
                } else {
                    List<String> wordList = new ArrayList<>();
                    wordList.add(tmpNode.word);
                    suggests++;
                    map.put(distance, wordList);
                }
            }
            if (tmpNode.children != null) {
                int lowRange = distance - tolerance;
                int highRange = distance + tolerance;
                for (Integer edge : tmpNode.children.keySet()) {
                    if (edge >= lowRange && edge <= highRange) {
                        stack.push(tmpNode.children.get(edge));
                        searchWordsThroughLevels(map, stack, word);
                    }
                }
            }
        }
    }

    private void loadDictionary() {
        Path path = Path.of(dictionary);
        try {
            List<String> list = Files.readAllLines(path);
            for (String x : list) {
                add(x.trim());
            }
            System.out.println(list.size() + " Strings loaded from file");
        } catch (IOException e) {}
    }

    void addToNewWords(String word) {
        newWords.add(word);
    }

    void saveDictionary() {
        Path path = Path.of(dictionary);
        try {
            for (String s : newWords) {
                Files.writeString(path, "\n" + s, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        newWords.clear();
    }

    void getTreeInfos() {
        System.out.println(suggests + " suggests by " + queries + " queries in " + time.getSeconds() + "." + time.getNano() + " seconds");
        queries = 0;
        suggests = 0;
    }

    private class Node {
        private final String word;
        private Map<Integer, Node> children;

        private Node (String word) {
            this.word = word;
        }

        public String toString() {
            return word;
        }
    }
}
