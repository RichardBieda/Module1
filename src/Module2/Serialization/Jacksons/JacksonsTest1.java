package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class JacksonsTest1 {

    public static void main(String[] args) {
        Person person = new Person("Richard", 39);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String json;
        try {
            json = mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);

        ObjectMapper mapper1 = new ObjectMapper();
        Person person1;
        try {
            person1 = mapper1.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person1);
    }
}
