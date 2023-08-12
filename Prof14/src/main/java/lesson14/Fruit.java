package lesson14;

public class Fruit implements Comparable<Fruit>{
    private String name;
    private int calories;


    public Fruit(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "F{" +
                "n='" + name + '\'' +
                ", c=" + calories +
                '}';
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(o.getCalories(), getCalories()); //o.getCalories()-getCalories();
    }
}