package abstractclasses;

public class AbstractClassRunner {

    public static void main(String[] args) {

        Animal snoopy = new Dog();
        snoopy.sound();

        Animal felix = new Cat();
        felix.sound();
    }
}
