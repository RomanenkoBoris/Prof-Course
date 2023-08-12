package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(l);
        removeAllGreater(l, 4);
        System.out.println(l);

        List<String> strings = new ArrayList<>(Arrays.asList(
                "hello", "max", "world", "is", "world", "max", "masha"
        ));
        removeDuplicates(strings);
        System.out.println(strings); // hello, max, world, is, masha

    }
    // напишите функцию которая удалит из списка целых
    // все целые больше заданого
    // до 19:08
    public static void removeAllGreater(List<Integer> l, int value){
        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()){
            int tmp = iterator.next();
            if (tmp > value){
                iterator.remove();
            }
        }
//        List<Integer> toRemove = new ArrayList<>();
//        for(int i: l)
//        {
//            if(i > value)
//                toRemove.add(i);
//        }
//        l.removeAll(toRemove);

    }

    // напишите функцию удаляющую из списка строк дубликаты
    List<String> strings = new ArrayList<>(Arrays.asList(
            "hello", "max", "world", "is", "world", "max", "masha"
    ));
    public static void removeDuplicates(List<String> s)
    {
        List<String> seenSoFar = new ArrayList<>(); // ранее встречавшиеся
        Iterator<String> iter = s.iterator();
        while (iter.hasNext())
        {
            String element = iter.next();
            if(seenSoFar.contains(element))
                iter.remove();
            seenSoFar.add(element);
        }
    }

//    public static void removeDuplicates(List<String> s) {
//        boolean isItremoved = false;
//        while (!isItremoved){
//            isItremoved = true;
//            String tmp = "";
//            for (int i = 0; i < s.size(); i++){
//                for (int j = i+1; j<s.size(); j++){
//                    if (s.get(i).equals(s.get(j))){
//                        tmp = s.get(i);
//                        isItremoved = false;
//                    }
//                }
//            }
//            s.remove(tmp);
//        }
//
//    }
}
