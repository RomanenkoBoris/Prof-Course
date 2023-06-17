package lesson1.japan;

public class SalaryTester {
    public static void main(String[] args) {
        JapaneseEmployee e1 = new JapaneseEmployee("Mitsuo Basyo", 150000, 10);
        JapaneseEmployee e2 = new JapaneseEmployee("Akira Kurosava", 200000, 2);

        System.out.println(e1.getName() + " salary " + e1.calculateSalary());
        System.out.println(e2.getName() + " salary " + e2.calculateSalary());
    }
}
