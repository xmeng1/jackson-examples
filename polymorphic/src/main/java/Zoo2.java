import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * User:    mengxin
 * Date:    10/07/2017
 * Project: jackson-examples
 * Package: ${PACKAGE_NAME}
 * Description: ${NAME}.
 * @author mengxin
 * @version 1.0
 */

public class Zoo2 {
    public Animal animal;

    public Zoo2(Animal animal) {
        this.animal = animal;
    }

    //@JsonTypeInfo(use = Id.NAME, include = As.WRAPPER_OBJECT, property = "type")
    @JsonTypeInfo(use = Id.NAME, include = As.WRAPPER_ARRAY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")})
    public static class Animal {

        public String name;

        public Animal() {
        }

        public Animal(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {

        boolean likesCream;

        public int lives;
    }

}
