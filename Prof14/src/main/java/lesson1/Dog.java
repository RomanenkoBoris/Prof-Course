package lesson1;

public class Dog {
    private String breed;
    private String name;
    private int age;
    private String color;

    public Dog() {
    }

    public Dog(String breed, String name, int age, String color) {
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {

        return age;
    }

    public String getColor() {
        return color;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 50) {
            this.age = age;
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    // внутри класса доступ есть ко всем полям
    // независимо от уровня доступа - private, public etc
    public void bark() {
        System.out.println(name + " bark, bark!");
    }
}
