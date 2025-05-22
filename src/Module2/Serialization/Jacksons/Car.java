package Module2.Serialization.Jacksons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
class Car {

    @JsonProperty("manufacturer")
    private String name;
    private String model;

    private String engine;
    @JsonIgnore
    public int getUnnecessary() {
        return unnecessary;
    }

    Car(){}

    @JsonCreator
    Car(@JsonProperty("manufacturer") String manufacturer, String model) {
        this.name = manufacturer;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUnnecessary(int unnecessary) {
        this.unnecessary = unnecessary;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    private int unnecessary;

    public String toString() {
        return name + ", " + model;
    }
}
