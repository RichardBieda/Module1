package Module2.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lecture9 {

    public static void main(String[] args) {
        List<String> sentences = List.of("Hallo world", "Java is coll", "streams are awesome");

        List<String> result = sentences.stream()
                .flatMap(sentence -> Stream.of(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
