package lesson15;

import java.util.*;

/*
контейнер Map хранит в себе набор пар из ключа и значения
HashMap - основана на хэшировании ключа для ускорения хранения и поиска
LinkedHashMap - все то же самое + гарантируется порядок обхода - в порядке вставки
TreeMap - хранит все элементы в порядке заданном компаратором для ключа
 */
public class Lesson15 {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Hungary", "Budapest"); // добавление пары в Map
        capitals.put("Poland", "Warsaw");
        capitals.put("Estonia", "Tallinn");
        capitals.put("Austria", "Vena");
        capitals.put("France", "Paris");
        capitals.put("Finland", "Helsinki");
        System.out.println(capitals.size());
        capitals.put("France", "Paris"); // при совпадении ключа, его значение перезаписывается
        System.out.println("Size: " + capitals.size());
        System.out.println("Capital of Poland: " + capitals.get("Poland"));
        System.out.println("Capital of England: " + capitals.get("England")); // null - при отсутствии элемента
        System.out.println("Содержится ли запись с ключом Estonia: " + capitals.containsKey("Estonia"));
        System.out.println("Содержится ли запись со значением London: " + capitals.containsValue("London"));

        // получение и итерация по всем ключам
        for (String key : capitals.keySet()) {
            System.out.println("key is: " + key);
        }
        List<String> countries = new ArrayList<>(capitals.keySet());

        // capitals.values() значения - распечатайте все столицы в которых есть i
        for (String value : capitals.values()) {
            if (value.contains("i"))
                System.out.println("value is: " + value);
        }

        capitals.remove("Austria"); // удаление пары по ключу
        System.out.println(capitals.size());

        System.out.println(capitals);

        // создайте на базе списка countries Map где по ключу-названию страны хранилась бы длина строки-названия
        Map<String, Integer> contriesLength = new HashMap<>();
        for (String s : capitals.keySet()) {
            contriesLength.put(s, s.length());
        }
        System.out.println(contriesLength);

        Map<String, Integer> calories = new HashMap<>();
        calories.put("Ananias", 50);
        calories.put("Banana", 89);
        calories.put("Kiwi", 61);
        calories.put("Apple", 52);
        calories.put("Lemon", 29);
        calories.put("Orange", 47);
        System.out.println(calories);

        System.out.println(findMax(calories));

        for (Map.Entry<String, Integer> entry : calories.entrySet()) {
            System.out.println("ключ: " + entry.getKey() + " значение: " + entry.getValue());
        }

        // итерация по парам
        // Map.Entry<> - интерфейс для пары
        // AbstractMap.SimpleEntry<> - реализация
        for(Map.Entry<String, Integer> entry : calories.entrySet())
        {
            System.out.println("ключ: " + entry.getKey() + " значение: " + entry.getValue());
        }

        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("Germany", "Berlin");

        List<Integer> number = Arrays.asList(1,2,1,4,4,5,4,7,1);
        Map<Integer, Integer> numbersCounter = new HashMap<>();
        for(Integer n: number)
        {
            // нужно найти в numbersCounter значение по числу
            Integer value = numbersCounter.get(n);
            if(value != null) {
                // если значение есть, сохранить пару увеличив значение на 1
                numbersCounter.put(n, value + 1);
            } else {
                numbersCounter.put(n, 1);
            }
        }
        // распечатать
        System.out.println(numbersCounter);
    }

    // напишите функцию которая вернет самый калорийный фрукт из calories
    public static String findMax(Map<String, Integer> calories) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(calories.entrySet());

        return Collections.max(list, (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).getKey();

/*
        String max = null;
        int c = 0;
        for (String s : calories.keySet()) {
            if (max == null) {
                max = s;
                c = calories.get(max);
            } else if (calories.get(s) > c) {
                c = calories.get(s);
                max = s;
            }
        }
        return max;
*/
    }
}
