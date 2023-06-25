package lesson2.university;

public class University {
    public static void main(String[] args) {
        Person p1 = new Student("Max", 21, 3, "politics");
        Stuff s1 = new Stuff("Semen", 46, 50_000);

        Person [] people = {p1, s1};

        for (int i = 0; i < people.length; i++){
            people[i].introduce();
        }
    }

}
