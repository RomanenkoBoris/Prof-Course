package HomeWork6;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    private int id;

    private int age;
    private String name;
    private double salary;
    public static Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };
    public static Comparator<Employee> nameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
    public static Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getSalary);

    public Employee(int id, int age, String name, double salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getId(),o.getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
