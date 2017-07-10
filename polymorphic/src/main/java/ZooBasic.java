/**
 * Created by mengxin on 10/07/2017.
 */
public class ZooBasic {
    public Animal animal;

    public ZooBasic(Animal animal) {
        this.animal = animal;
    }

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
