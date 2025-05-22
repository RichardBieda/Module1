package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JacksonsTest4 {

    public static void main(String[] args) {

        Car car = new Car("Audi", "A6");
        ObjectMapper mapper = new ObjectMapper();

        String prettyJson;
        try {
            prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(prettyJson);
    }
}
