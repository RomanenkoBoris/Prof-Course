package HomeWork9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NamesCounter {
    public static void main(String[] args) {

        // Дан файл (names.txt) со списком имен на выбор, некоторые имена повторяются.
        // Написать метод, который вернет количество вхождений каждого из имен в файл.
        try (
                Reader fileReader = new FileReader("names.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            System.out.println(
                    bufferedReader.lines() // запускает поток из строк - метод класса BufferedReader
                            .flatMap(line -> Arrays.stream(line.split(" "))) // name
                            .collect(Collectors.groupingBy(name -> name, Collectors.counting())));
            //.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
