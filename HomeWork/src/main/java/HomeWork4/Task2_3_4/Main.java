package HomeWork4.Task2_3_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 12));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 2, 3, 3, 0));

        System.out.println(compareLists(list1, list2));

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(list3);
        System.out.println(listReflect(list3));

        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 3, 4, 2));

        System.out.println(secondLarge(list4));


    }

    public static List<String> compareLists(List<Integer> list1, List<Integer> list2) {
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        List<String> result = new ArrayList<>();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (iterator1.next().equals(iterator2.next())) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }


    public static List<Integer> listReflect(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        Iterator<Integer> iterator = list.iterator();
        int pointer = list.size()-1;
        while (iterator.hasNext()) {
            result.set(pointer, iterator.next());
            pointer--;
        }
        // list = result; Вопрос - сначала я хотел сделать метод, который ничего не возвращал бы, а также создавал бы
        // список и наполнял бы его элементами исходного списка в обратном порядке, а вконце менял перенаправлял бы
        // ссылку исходного списка на вноь созданный, но это не вышло - почему?
        return result;
    }

    public static int secondLarge (List<Integer> list){
        Integer[] array = new Integer[ list.size()];
        list.toArray(array);
        Arrays.sort(array);
        int pointer = array.length-2;
        while (array[pointer] == array[array.length-1]){
            pointer--;
        }
        return array[pointer];
    }
}
