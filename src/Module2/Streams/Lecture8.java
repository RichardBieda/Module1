package Module2.Streams;

import java.util.List;

public class Lecture8 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 15, 20, 25);

        List<Integer> result = numbers.stream().filter(x -> x > 10).peek(x -> System.out.println("original: " + x))
                .map(x -> x * 2).peek(x -> System.out.println("filtered: " + x)).toList();
    }
}
