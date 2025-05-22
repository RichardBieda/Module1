package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.core.*;

import java.io.File;
import java.io.IOException;

class JacksonsTest6 {

    public static void main(String[] args) {

        JsonFactory factory = new JsonFactory();
        try (JsonGenerator generator = factory.createGenerator(new File("src\\Module2\\Serialization\\Jacksons\\arrayOutput.json"), JsonEncoding.UTF8)){
            generator.writeStartArray();

            generator.writeStartObject();
            generator.writeStringField("name", "Anna");
            generator.writeNumberField("age", 25);
            generator.writeEndObject();

            generator.writeStartObject();
            generator.writeStringField("name", "Sofia");
            generator.writeNumberField("age", 5);
            generator.writeEndObject();
            generator.writeEndArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonFactory fac = new JsonFactory();
        try (JsonParser parser = fac.createParser(new File("src\\Module2\\Serialization\\Jacksons\\arrayOutput.json"))) {
            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (JsonToken.FIELD_NAME.equals(token)) {
                    String fieldName = parser.getCurrentName();
                    //parser.nextToken();
                    System.out.println(parser.nextToken() + ", " + fieldName + ", " + parser.getText());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
