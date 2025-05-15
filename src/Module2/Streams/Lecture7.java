package Module2.Streams;

import java.util.List;
import java.util.stream.Stream;

public class Lecture7 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);

        int sum = numbers.stream().reduce(0, Integer::sum);
        int product = numbers.stream().reduce(1 ,(a,b) -> a * b);


        System.out.println(sum);
        System.out.println(product);
    }
}
