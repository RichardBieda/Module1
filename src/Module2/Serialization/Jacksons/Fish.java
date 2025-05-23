package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = jacksonsTest7.FishSerializer.class)
@JsonDeserialize(using = jacksonsTest7.FishDeserializer.class)
public class Fish {

    private String name;
    private int age;

    Fish() {}

    Fish(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
