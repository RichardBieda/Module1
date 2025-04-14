package Module2.Streams;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> l1 = new LinkedList<>();
        Collections.addAll(l1, "Hello", "I'm", "here");
        Stream<String> stream1 = l1.stream().filter(a -> a.contains("e"));
        stream1.forEach(System.out::println);
    }
}
