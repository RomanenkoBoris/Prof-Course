package lesson4.Animals;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woof");
    }

    public void greets(Dog dog) {
        System.out.println("Woooof");
    }
}
