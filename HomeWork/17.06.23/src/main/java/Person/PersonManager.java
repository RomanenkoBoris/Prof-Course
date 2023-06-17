package Person;

public class PersonManager {
    public static void main(String[] args) {

        Person john = new Person();
        john.setFullName("John Johnson");
        john.setAge(35);

        Person adam = new Person("Adam Adamson", 41);

        john.move();
        john.talk();

        adam.move();
        adam.talk();
    }
}
