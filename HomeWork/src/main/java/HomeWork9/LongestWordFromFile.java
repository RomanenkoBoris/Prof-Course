package HomeWork9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFromFile {
    public static void main(String[] args) {

        // Есть текстовой файл с произовльным текстом text.txt
        // Найдите самое длинное слово (слова отделяются между собой пробелами).
        try (
                Reader fileReader = new FileReader("text.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            bufferedReader.lines() // line
                    .flatMap(line -> Arrays.stream(line.split(" "))) // word
                    .max(Comparator.comparing(String::length)) // Optional<String>
                    .ifPresent(System.out::println);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
