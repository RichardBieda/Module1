package Module2.Streams;

import java.util.List;
import java.util.stream.Stream;

class Lecture2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> stream = numbers.stream();
        stream.filter(x -> x % 2 != 0).map(x -> x * 10).forEach(System.out::println);
    }
}
