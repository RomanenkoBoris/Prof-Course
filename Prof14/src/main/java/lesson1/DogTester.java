package lesson1;

public class DogTester {
    public static void main(String[] args) {
        Dog trezor = new Dog();
        trezor.setName("Trezor");
        trezor.setBreed("ovcharka");
        trezor.setAge(5);

        Dog eleonora = new Dog();
        eleonora.setName("Eleonora");
        eleonora.setBreed("bolonka");
        eleonora.setAge(7);

        Dog max = new Dog("Max", "pitbul", 8, "gray");


        System.out.println("Eleonora breed is " + eleonora.getBreed());
        printDog(trezor);
        printDog(eleonora);
        printDog(max);

        max.bark();
        eleonora.bark();
        max.bark();
    }

    public static void printDog(Dog d) {
        System.out.println("Собака "
                + d.getName() + " породы "
                + d.getBreed() + " возраста "
                + d.getAge()
        );
    }
}
