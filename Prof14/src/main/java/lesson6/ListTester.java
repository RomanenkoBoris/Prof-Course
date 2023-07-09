package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        // Коллекции работают только с объектами, а НЕ с примитивами - для них используются обертки
        // List - динамически расширяемый список элементов
        //      ArrayList - основан на масиве
        //      LinkedList - каждый из элементов хранит ссылку на следующий и предыдущих
        // Set - набор уникальных элементов
        // Map - хранит пары из уникального ключа и значения - "примитивная мини БД"

        // инициализация
        List<String> capitals = new ArrayList<>(Arrays.asList("Vienna", "Prague"));

        System.out.println(capitals + " size: " + capitals.size());
        capitals.add("Berlin"); // добавление элемента в конец
        System.out.println(capitals + " size: " + capitals.size());

        // добавлние коллекции в конец
        capitals.addAll(Arrays.asList("London", "Paris"));
        System.out.println(capitals + " size: " + capitals.size());

        // добавлние коллекции с определенного индекса
        capitals.addAll(4, Arrays.asList("Moscow", "Washington"));
        System.out.println(capitals + " size: " + capitals.size());

        System.out.println(capitals.get(3)); // обращение по индексу

        // изменение по индексу
        capitals.set(0, "Bratislava");
        System.out.println(capitals);

        // удаление элемента
        capitals.remove(6); // capitals.remove("Paris");
        // разница между подходами - в первом случае удалится только конкретный элемент, во втором
        // удалятся все парижи (при наличии нескольких)
        System.out.println(capitals);

        // можно добавить в список коллекцию
        // capitals.addAll(Collection); - название коллекции к добавлению
        // можно удалить из списка все элементы, входящие в другую коллекцию
        // capitals.removeAll(Collection); - название коллекции к удалению

        // Все контейнеры/коллеции явы могут содержать ТОЛЬКО ссылочные типы

        // ArrayList - основан на массивеб поэтому все операции доступа по индексу - O(1)
        // операции же добавления в начало (в середину) - O(N)
        // усли же производим поиск/обращение по индексу - О(1), если по значению, то O(N), т.к.
        // идет перебор всех элементов списка и ищется указанное значение - для этих целей лучше
        // применять set коллекции - там доступ по значени О(1).
        //clear() - Removes all of the elements from this list.
        //contains(Object o) - Returns true if this list contains the specified element.
        // containsAll(Collection<?> c) - Returns true if this list contains all of the elements
        // of the specified collection.
        // sort(Comparator<? super E> c) -Sorts this list according to the order induced by the specified Comparator
        // subList(int fromIndex, int toIndex) -Returns a view of the portion of this list between the
        // specified fromIndex, inclusive, and toIndex, exclusive.
        // toArray() -Returns an array containing all of the elements in this list in proper
        // sequence (from first to last element).
        // https://docs.oracle.com/javase/8/docs/api/java/util/List.html

        System.out.println(filterOnlyOdd(Arrays.asList(1,2,6,8,15,3)));





    }

    // напишите функцию которая конкатенирует два списка
    public static List<String> concat (List<String>s1, List<String>s2){
        List<String>result = new ArrayList<>();
        result.addAll(s1);
        result.addAll(s2);
        return result;
    }

    // напишите функцию которая принимает на вход два списка целых
    // и возвращает true если все элементы попарно одинаковы
    public static boolean compare(List<Integer> i1, List<Integer> i2)
    {
        if(i1.size() != i2.size())
            return false;
        for (int i = 0; i < i1.size(); i++){
            if (i1.get(i).equals(i2.get(i))){
                return false;
            }
        }
        return true;
    }

    // напишите функцию которая принимает список целых и возвращает из него только четные
    public static List<Integer> filterOnlyOdd (List<Integer> list){
        List<Integer>result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i)%2 == 0){
                result.add(list.get(i));
            }
        }
        return result;
    }
}
