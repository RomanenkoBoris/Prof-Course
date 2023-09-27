package lesson24;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E_Concordance {
    public static void main(String[] args) {
        // считайте строчки
        // превратите их в слова
        try (
                Reader fileReader = new FileReader("concordance.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
//            bufferedReader.lines()
//                    .flatMap(line -> Arrays.stream(line.split(" ")))
//                    .forEach(
//                            System.out::println
//                    );
            List<String> lines = Arrays.asList(bufferedReader.lines().toArray().toString());

            // создайте Map<String, List<Integer>> - номера строк в которых это слово встречалось
            // "this" -> [0, 1, 2]
            // "cool" -> [0, 3]
            System.out.println(
                    IntStream.range(0, lines.size()) // 0, 1, 2, 3
                            .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, lines.get(i))) // 3 -> "cool hate"
                            .flatMap( // this -> 0, ..., cool -> 3, hate -> 3
                                    p -> Arrays.stream(p.getValue().split(" "))
                                            .map(w -> new AbstractMap.SimpleEntry<>(w, p.getKey()))
                            ).collect(
                                    Collectors.groupingBy(
                                            pair -> pair.getKey(),
                                            Collectors.mapping(
                                                    pair -> pair.getValue(),
                                                    Collectors.toList()))));


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // создайте Map<String, List<Integer>>
        // List<Integer>> - номера строк в которых это слово встречалось
        // "this" -> [0, 1, 2]
        // "cool" -> [0, 3]

    }
    public static Map.Entry<String, List<Integer>> createMap (String fileName, String word) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int numberOfLine = 0;
        List<Integer> list = new ArrayList<>();
        Map.Entry<String, List<Integer>> result = new AbstractMap.SimpleEntry<>(word, list);
        while (scanner.hasNextLine()){
            if (scanner.nextLine().contains(word)){
                list.add(numberOfLine);
            }
            numberOfLine++;
        }
        scanner.close();
        return result;
    }
}
