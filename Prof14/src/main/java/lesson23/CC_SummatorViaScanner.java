package lesson23;

import java.io.FileInputStream;
import java.util.Scanner;

public class CC_SummatorViaScanner {
    public static void main(String[] args) {
        // Посчитайте сумму чисел из файла digits.txt
        int sum = 0;
        try (
                FileInputStream fis = new FileInputStream("digits.txt")
        ) {
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                sum += i;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(sum);


    }
}
