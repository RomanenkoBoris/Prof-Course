package HomeWork7;

import java.util.*;

public class Homework7 {
    public static void main(String[] args) {

        System.out.println(theOftestElement(Arrays.asList(1, 66, 4, 5, 2, 4, 8, 2, 4, 5, 6, 2, 4, 8, 6, 5, 8, 5, 6, 1, 5, 5)));

        System.out.println(findEvenCountedElements(Arrays.asList(1, 66, 4, 5, 2, 4, 8, 2, 4, 5, 6, 2, 4, 8, 6, 5, 8, 5, 6, 1, 5, 5)));

        String [] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};

        System.out.println(wordsWithEqualSymbols(words));

    }

    // Напишите функцию, которая вернет самый часто встречающийся элемент в списке
    public static Object theOftestElement(List<Object> objectList) {
        Map<Object, Integer> countElements = new HashMap();
        Map.Entry<Object, Integer> element = new AbstractMap.SimpleEntry<>(null, 0);
        for (Object current : objectList) {
            if (countElements.get(current) == null) {
                countElements.put(current, 1);
            } else {
                Integer value = countElements.get(current);
                countElements.put(current, value += 1);
                if (value > element.getValue()) {
                    element = new AbstractMap.SimpleEntry<>(current, value);
                }
            }
        }
        return element.getKey();
    }

    public static String getFrequent(List<String> list) {
        // поместить все элементы в Map<String, Integer>
        // отсортировать все Entry<String, Integer> по значениям
        Map<String, Integer> frequencies = new HashMap<>();
        for (String s : list) {
            Integer count = frequencies.get(s);
            if (count == null)
                frequencies.put(s, 1);
            else frequencies.put(s, count + 1);
        }

        Map.Entry<String, Integer> max = Collections.max(
                frequencies.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)
        );

        return max.getKey();
    }

    // Напишите функцию, которая вернет все элементы списка, которые встретились четное число раз
    public static Set<Object> findEvenCountedElements (List<Object> objectList){
        Map<Object, Integer> countElements = new HashMap();
        Set<Object> elements = new HashSet<>();
        for (Object current : objectList) {
            if (countElements.get(current) == null) {
                countElements.put(current, 1);
            } else {
                Integer value = countElements.get(current);
                countElements.put(current, value += 1);
                if (value % 2 ==0) {
                    elements.add(current);
                }else {
                    elements.remove(current);
                }
            }
        }
        return elements;
    }

    /* Сгруппируйте слова с одинаковым набором символов
    Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов. */

    public static Set<List<String>> wordsWithEqualSymbols (String [] words){
        Map<TreeSet<String>, List<String>> wordsMap = new HashMap<>();
        TreeSet<String> current;
        for (String s: words){
            current = new TreeSet<>(Arrays.asList(s.split("")));
            if (!wordsMap.containsKey(current)){
                wordsMap.put(current, new ArrayList<>(Arrays.asList(s)));
            } else {
                List <String> temp = wordsMap.get(current);
                temp.add(s);
                wordsMap.put(current, temp);
            }
        }
        return new HashSet<>(wordsMap.values());
    }
}
