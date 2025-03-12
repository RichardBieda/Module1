package Module1_Final_Project;

import java.util.*;

class Statistic {

    private final Map<Integer, String> results;
    private int suggests;

    Statistic() {
        this.results = new HashMap<>();
    }

    void insertResult(char[] result, int count) {
        if (results.containsKey(count)) {
            String newValue = results.get(count) + " ; " + String.valueOf(result);
            results.put(count, newValue);
            ++suggests;
        } else {
            results.put(count, String.valueOf(result));
            ++suggests;
        }
    }

    Map<Integer, String> getResults() {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.putAll(results);
        return map;
    }

    int getSuggests() {
        return suggests;
    }
}
