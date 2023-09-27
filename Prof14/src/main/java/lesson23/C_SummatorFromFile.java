package lesson23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C_SummatorFromFile {
    public static void main(String[] args) {
        // Посчитайте сумму чисел из файла digits.txt
        try (
                Reader reader = new FileReader("digits.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            bufferedReader.lines()
                    .map(s -> Integer.parseInt(s))
                    .reduce(0, (total, element) -> total + element);

            bufferedReader.lines()
                    .mapToInt(line -> Integer.parseInt(line)) // int
                    .sum(); // sum есть только в int

        } catch (IOException e) {
            System.out.println("Exeption " + e.getLocalizedMessage());
        }
    }
}
