package HomeWork9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWork9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a file name (names.txt):");
        findUniqueNames(scanner.nextLine());

        findTheLengthiestWord("text.txt");

        // посчитайте кастомным коллектором суммарную длину имен
        List<String> names = Arrays.asList("Max", "Lena", "Sveta", "Alexander");

        Collector<String, List<Integer>, Integer> myCustomCollector = new Collector<String, List<Integer>, Integer>() {
            @Override
            public Supplier<List<Integer>> supplier() {
                return () -> new ArrayList<Integer>();
            }

            @Override
            public BiConsumer<List<Integer>, String> accumulator() {
                return (integers, string) -> integers.add(string.length());
            }

            @Override
            public BinaryOperator<List<Integer>> combiner() {
                return ((list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                });
            }

            @Override
            public Function<List<Integer>, Integer> finisher() {
                return integers -> integers.stream()
                        .reduce(0, (a,b) -> Integer.sum(a,b));
            }

            @Override
            public Set<Characteristics> characteristics() {
                return new HashSet<>(Arrays.asList(Characteristics.UNORDERED));
            }
        };

        System.out.println(names.stream()
                .collect(myCustomCollector));


    }

    // Дан файл (names.txt) со списком имен на выбор, некоторые имена повторяются.
    // Написать метод, который вернет количество вхождений каждого из имен в файл.
    private static void findUniqueNames(String fileName) {
        Map <String, Integer> names = new HashMap<>();
        try (Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);){
            StringBuffer stringBuffer = new StringBuffer(bufferedReader.readLine());
            while (true){
                String temp = bufferedReader.readLine();
                if (temp == null){
                    break;
                } else {
                    stringBuffer.append(" " + temp);
                }
            }
            for(String s: stringBuffer.toString().split(" ")){
                if (!names.containsKey(s)){
                    names.put(s, 1);
                } else {
                    names.put(s, names.get(s).intValue()+1);
                }
            }
            System.out.println(names);
        } catch (IOException iOE){
            System.err.println("Exception: " + iOE.getLocalizedMessage());
        }

    }

    // Есть текстовой файл с произовльным текстом text.txt
    // Найдите самое длинное слово (слова отделяются между собой пробелами).
    public static String findTheLengthiestWord (String fileName){
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer(bufferedReader.readLine());
            String temp = bufferedReader.readLine();
            while (temp != null){
                stringBuffer.append(" " + temp);
                temp = bufferedReader.readLine();
            }
            Stream.of(stringBuffer.toString().split(" "))
                    .collect(Collectors.groupingBy(word -> word.length()))
                    .entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getKey))
                    .ifPresent(pair -> System.out.println(pair.getValue()));
        }catch (IOException iOE){
            System.err.println("Exception: " + iOE.getLocalizedMessage());
        }
        return null;
    }
}
