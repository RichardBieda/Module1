package Module2.Streams;

import java.util.List;
import java.util.stream.Collectors;

class Lecture4 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 3, 10, 2, 5, 7, 2, 8);

        List<Integer> result =
                numbers.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(result);
    }
}
