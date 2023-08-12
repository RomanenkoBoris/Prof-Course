package lesson10;

/*
    Set - интерфейс - служит базой для коллекций содержащих уникальные элементы
    применения
        поиск дубликатов
        поиск уникальных элементов

    реализации
        HashSet - набор хранится в виде оптимизированном для поиска
            предполагается что операции поиска O(1)
            при этом расходуется память на поддержание внутренней структуры
            порядок обхода не гарантируется
        LinkedHashSet - гарантирует что при обходе элементы возвращаются в
            порядке вставки
        TreeSet - хранит и возвращает элементы при обходе в порядке сортировки
            заданным для типа либо заданным через компаратор

 */

import java.util.*;

public class SetTester {
    public static void main(String[] args) {
        Set<String> groups = new HashSet<>(Arrays.asList("Abba", "Beatles", "Rolling Stones"));
        groups.add("Deep Purple");
        groups.add("Led Zeppelin");
        // хранит и выводит данные согласно присвоенному хэш-коду - поэтому-то и нет первоначального порядка, поэтому то
        // и все быстро находитс и поэтому же все удаляется - эврика!!!
        System.out.println(groups);

        System.out.println(groups.contains("Eurythmics")); // есть такой элемент?
        System.out.println(groups.size()); // размер

        groups.add("Abba"); // добавление повторных элементов бесполезно, т.к. хранятся только уникальные элементны
        System.out.println(groups.size());
        System.out.println(groups);

        // обход по итератору для сета имеет смысл делать только
        // если в процессе обхода потребуется что-то удалять
        Iterator<String> groupsIterator = groups.iterator();
        while (groupsIterator.hasNext())
            System.out.println("group is: " + groupsIterator.next());

        // во всех остальных случаях
        for (String s : groups) {
            System.out.println("for each group " + s);
        }
        // Set не дает доступ по индексу - поэтому, чтобы каким-то образом обратиться и взаимодействовать с элементами
        // примененяем - contains или обход по итератору или for-each

        groups.remove("Abba"); // удаление элемента
        System.out.println(groups);

        // Некоторые полезные ОБЩИЕ функции ВСЕХ коллекций, с помощью которых, можно оптимизировать работу не только
        // внутри одного потомка Collections, но и взаимодействовать между ними - переводить один тип в другой и т.д.
        // Collection.addAll(Collection c) - добавление элементов из другой коллекции
        // Collection.containsAll(Collection c) - true если c содержится полностью
        // Collection.removeAll(Collection c) - удаление всех элементов содержащихся в с
        // Collection.retainAll(Collection c) - в коллекции останутся только только общие элементы

        // Set<String> groups = new HashSet<>(Arrays.asList("Abba", "Beatles", "Rolling Stones"));
        List<String> britishGroups = Arrays.asList("Blur", "Oasis", "Rolling Stones", "Beatles");
        // удалите из groups все британские группы
        groups.removeAll(britishGroups);
        System.out.println(groups); //[Led Zeppelin, Deep Purple]

        // TreeSet - хранит элементы в порядке сортировки (в данном случае по алфавиту)
        TreeSet<String> britishGroupsTreeSet = new TreeSet<>(britishGroups);
        // ВАЖНО - если хотим пользоваться возможностями, присущими только конкретному типу, важно не сужать (расширять)
        // его до прородителя - Set, а прописывать сам тип
        System.out.println(britishGroupsTreeSet);

        // headSet - все элементы "до"
        System.out.println(britishGroupsTreeSet.headSet("Guns and Roses")); // Beatles, Blur

        // subSet - все элементы в диапазоне "от" и "до"
        System.out.println(britishGroupsTreeSet.subSet("Guns and Roses", "ZZ Top")); // Oasis, Rolling Stones

        // tailSet - все элементы "после"
    }

    // напишите функцию которая принимает на вход коллекцию и два значения - "от" и "до"
    // и возвращает Set с элементами коллекции, лежащими в этом диапазоне
    public static Set<Integer> filterCollection(Collection<Integer> c, int from, int to) {
        // желательно обойтись без циклов
//        TreeSet<Integer> numbers = new TreeSet<>(c);
//        return numbers.subSet(from, to);
        return new TreeSet<>(c).subSet(from, to);
    }

    // напишите функцию которая возвращает список дубликатов из строки
    public static Set<String> getDoubles(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
        Set<String> unique = new HashSet<>(list);
        list.removeAll(unique);
        Set<String> duplicate = new HashSet<>(list);

        return duplicate;

//        Set<String> words = new HashSet<>();
//        Set<String> doubles = new HashSet<>();
//        for(String w : s.split(" "))
//        {
//            if(words.contains(w))
//                doubles.add(w);
//            words.add(w);
//        }
//        return doubles;
    }

    // напишите функцию которая возвращает набор уникальных букв из строки
    // в порядке их следования в строке
    // "hello lake mid" -> helo akmid
    public static Set<String> uniqueLetters(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        Set<String> set = new LinkedHashSet<>(list);
        return set;

        // return new new LinkedHashSet<>(Arrays.asList(s.split("")));
    }

    // считается что устрицы можно есть только в месяцы в которых есть буква "r"
    // верните те месяцы когда устриц можно есть в порядке следования
    public static Set<String> filterMonth(List<String> m){
        Set<String> result = new LinkedHashSet<>();
        Iterator <String> iterator = m.iterator();
        while (iterator.hasNext()){
           String tmp = iterator.next();
            if (tmp.contains("r")){
                result.add(tmp);
            }
        }
        return result;
    }
}

