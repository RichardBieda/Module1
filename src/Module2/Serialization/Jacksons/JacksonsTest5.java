package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

class JacksonsTest5 {

    public static void main(String[] args) {

        String json = "{\n" +
                "  \"name\" : \"Ron\",\n" +
                "  \"age\" : 30\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(root.get("name").asText());

        if (root.has("age")) System.out.println("there is an age");

        ObjectNode objectNode = (ObjectNode) root;
        objectNode.put("city", "New York");
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
