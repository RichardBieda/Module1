package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

class JacksonsTest3 {

    public static void main(String[] args) {

        ObjectMapper mapper1 = new ObjectMapper();
        Person p;
        ObjectMapper mapper2 = new ObjectMapper();
        List<Person> list;
        try {
            p = mapper1.readValue(new File("src\\Module2\\Serialization\\Jacksons\\person.json"), Person.class);

            list = mapper2.readValue(new File("src\\Module2\\Serialization\\Jacksons\\personList.json"), new TypeReference<List<Person>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(p);
        list.forEach(System.out::println);
    }
}
