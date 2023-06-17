package lesson1.japan;

public class JapaneseEmployee {
    private String name;
    private final double baseSalary;

    private int years;

    public JapaneseEmployee(String name, double baseSalary, int years) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.years = years;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double calculateSalary(){
        return baseSalary + coefficient * years;
    }

    public static final int coefficient = 50_000;
}
