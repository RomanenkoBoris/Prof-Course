package lesson15;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        String words = "hello hell exactly eye robot hi";
        System.out.println(mapFirstLetterToList(words));

        Map<String, String> brandToModel = new HashMap<>();
        brandToModel.put("BMW", "Z3");
        brandToModel.put("Peugeot", "407");
        brandToModel.put("Renault", "Logan");
        System.out.println(brandToModel);

        // создайте и распечатайте мапу из
        // модели в марку
        Map<String, String> modelToBrand = new HashMap<>();
        for (String brand : brandToModel.keySet()) {
            String model = brandToModel.get(brand);
            modelToBrand.put(model, brand);
        }
        System.out.println(modelToBrand);
        System.out.println(frequency("один раз это один раз"));

        System.out.println(getWordLengthFrequency(Arrays.asList("Max", "Daria", "Masha", "Alex", "Ron")));

        Map<String, String> tickets = new HashMap<>();
        tickets.put("Berlin", "London");
        tickets.put("Tokyo", "Seoul");
        tickets.put("Mumbai", "Berlin");
        tickets.put("Oslo", "Paris");
        tickets.put("Seoul", "Mumbai");
        findRoute("Tokyo", "London", tickets);

        // LinkedHashMap - гарантирует что элементы при обходе будут возвращаться в
        // порядке вставки

        // TreeSet - элементы при обходе будут возвращаться в порядке
        // определяемом компаратором для ключу

        System.out.println(tickets);
        TreeMap<String, String> orderedTickets = new TreeMap<>(tickets);
        System.out.println(orderedTickets);

        TreeMap<String, String> orderedByKeyLengthTickets = new TreeMap<>(Comparator.comparingInt(String::length));
        orderedByKeyLengthTickets.putAll(tickets);
        System.out.println(orderedByKeyLengthTickets); // works not correct

    } // main

    // написать функцию для подбора сложного маршрута
    public static  void findRoute(String from, String to, Map<String, String> tickets) {
        String first = from;
        while (first != null && !first.equals(to)) {
            String second = tickets.get(first);
            System.out.println(first + " -> "+ second);
            first = second;
        }
    }

    // напишите функцию которая подсчитывает статистику распределения слов
    // по длине
    // ключ - длина слова, значение - количество слов такой длины
    // [Max, Daria, Masha, Alex, Ron] -> {3:2, 4:1, 5:2}
    public static Map<Integer, Integer> getWordLengthFrequency(List<String> words)
    {
        Map<Integer, Integer> statistics = new HashMap<>();
        for(String name: words)
        {
            int key = name.length();
            Integer value = statistics.get(key);
            if(value == null)
                statistics.put(key, 1);
            else
                statistics.put(key, value + 1);
        }
        return statistics;
    }

    // написать функцию которая создаст Map<String, List<String>>
    // где ключом будет первая буква слова а значением список слов в котором
    // эта буква первая
    // { h:{hello, hell, hi}, e:{exactly, eye}, r:{robot}}
    public static Map<String, List<String>> mapFirstLetterToList(String words) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word : words.split(" ")) {
            String letter = word.substring(0, 1);
            // получим из мапы значение по первой букве слова
            List<String> value = result.get(letter);
            if (value == null) {
                // если списка нет, создаем его и добавляем туда слово
                value = new ArrayList<>();
            }
            // если получаем список, просто добавляем в него слово
            value.add(word);
            // сохраняем в мапу по ключу обновленный список
            result.put(letter, value);

        }
        return result;
    }

    // напишите функцию которая посчитывает количество вхождений слова в строку
    // "один раз это один раз" -> {один:2, раз:2, это:1}
    public static Map<String, Integer> frequency(String words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words.split(" ")) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word).intValue() + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
}
