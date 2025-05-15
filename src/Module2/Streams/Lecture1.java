package Module2.Streams;

import java.util.List;
import java.util.stream.Stream;

class Lecture1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);
    }
}
