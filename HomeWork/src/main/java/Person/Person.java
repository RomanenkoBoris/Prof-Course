package Person;

public class Person {
    private String fullName;
    private int age;


    public Person() {

    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void move() {
        System.out.println("Person " + fullName + " walks");
    }

    public void talk() {
        System.out.println("Person " + fullName + " talks");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 110) {
            this.age = age;
        }
    }
}
