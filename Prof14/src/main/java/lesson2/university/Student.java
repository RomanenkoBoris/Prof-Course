package lesson2.university;

public class Student extends Person{
    private int year;
    private String programm;

    public Student(String name, int age, int year, String programm) {
        super(name, age);
        this.year = year;
        this.programm = programm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProgramm() {
        return programm;
    }

    public void setProgramm(String programm) {
        this.programm = programm;
    }

    @Override
    public void introduce() {
        System.out.println("I'm a student " + getName() + " " + getProgramm() + " " + getYear());
    }
}
