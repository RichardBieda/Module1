package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

class JacksonsTest2 {

    public static void main(String[] args) {

        Person p = new Person("Ron", 30);
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapper1 = new ObjectMapper();

        List<Person> list = List.of(new Person("Michael", 30), new Person("Milan", 31));
        String prettyJson;

        try {
            prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
            mapper.writeValue(new File("src\\Module2\\Serialization\\Jacksons\\person.json"), p);

            mapper1.writeValue(new File("src\\Module2\\Serialization\\Jacksons\\personList.json"), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(prettyJson);
    }
}
