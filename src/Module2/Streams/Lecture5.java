package Module2.Streams;

import java.util.List;
import java.util.stream.Collectors;

class Lecture5 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70, 80);

        List<Integer> result =
                numbers.stream().skip(2).limit(4).map(x -> x * 2).collect(Collectors.toList());

        System.out.println(result);
    }
}
