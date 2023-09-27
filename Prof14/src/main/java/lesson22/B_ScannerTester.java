package lesson22;

import java.util.Scanner;

public class B_ScannerTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число и нажмите ввод");
        int n = scanner.nextInt();
        System.out.println("Введите целое число и нажмите ввод");
        int k = scanner.nextInt();
        System.out.println("результат сложения " + (n+k));

        System.out.println("Введите double и нажмите ввод");
        double d = scanner.nextDouble();
        System.out.println("число " + d);

        // scanner.nextLine() - для считывания строк
    }
}
