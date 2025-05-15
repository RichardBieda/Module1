package Module2.Streams;

import java.util.List;

class Lecture6 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 15, 20, 25, 30);

        boolean greater25 = numbers.stream().anyMatch(x -> x > 25);
        boolean dividableBy5 = numbers.stream().allMatch(x -> x % 5 == 0);
        boolean nonSmaller0 = numbers.stream().noneMatch(x -> x < 0);

        System.out.println(greater25);
        System.out.println(dividableBy5);
        System.out.println(nonSmaller0);
    }
}
