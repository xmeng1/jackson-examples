import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * User:    mengxin
 * Date:    10/07/2017
 * Project: jackson-examples
 * Package: ${PACKAGE_NAME}
 * Description: ${NAME}.
 * @author mengxin
 * @version 1.0
 */

public class Zoo1 {
    public Animal animal;

    public Zoo1(Animal animal) {
        this.animal = animal;
    }

    //@JsonTypeInfo(use = Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonTypeInfo(use = Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
    public static class Animal {

        public String name;

        public Animal() {
        }

        public Animal(String name) {
            this.name = name;
        }
    }

    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {

        boolean likesCream;

        public int lives;
    }

}
