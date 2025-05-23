package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;

class jacksonsTest7 {

    public static void main(String[] args) {

        Fish fish = new Fish("Nemo", 2);
        ObjectMapper mapper = new ObjectMapper();

//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Fish.class, new FishSerializer());
//        simpleModule.addDeserializer(Fish.class, new FishDeserializer());
//
//        mapper.registerModule(simpleModule);

        try {
            mapper.writeValue(new File("src\\Module2\\Serialization\\Jacksons\\fish.json"), fish);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class FishSerializer extends JsonSerializer<Fish> {

        @Override
        public void serialize(Fish fish, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("name", fish.getName());
            gen.writeNumberField("age", fish.getAge());
            gen.writeEndObject();
        }
    }

    static class FishDeserializer extends JsonDeserializer<Fish> {

        @Override
        public Fish deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JacksonException {
            JsonNode node = parser.getCodec().readTree(parser);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return new Fish(name, age);
        }
    }
}
