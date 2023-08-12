package Lesson13;

import java.util.*;

public class Lesson13 {
    public static void main(String[] args) {
        String s1 = new String("value");
        String s2 = new String("value");
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s1); // true
        System.out.println(s2 == s2); // true

        Cat c1 = new Cat("Barsik", 4);
        Cat c2 = new Cat("Barsik", 4);
        System.out.println(c1.equals(c2));

        List<String> groups = new ArrayList<>(Arrays.asList("Guns and Roses", "Aetosmith", "Led Zeppelin",
                "Pearl Jam", "Beatles", "Cranberries"));
        Collections.sort(groups);
        System.out.println(groups);

        List<Cat> cats = new ArrayList<>(Arrays.asList(c1, c2));
        Collections.sort(cats);
        Cat c3 = new Cat("Baun", 12);
        Cat c4 = new Cat("Masha", 5);
        cats.add(c3);
        cats.add(c4);
        Collections.sort(cats);
        System.out.println(cats);

        Collections.sort(cats, new CatNameComparator());
        System.out.println(cats);

        Comparator<String> thirdLetterComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(2,3).compareTo(o2.substring(2,3));
            }
        };
        Collections.sort(groups, thirdLetterComparator);
        System.out.println(groups);
        Collections.sort(groups, thirdLetterComparator.reversed());
        System.out.println(groups);

        // отсортируйте группы по длине строки
        // постарайтесь использовать лямбду
        Collections.sort(
                groups,
                (r1, r2) -> Integer.compare(r1.length(), r2.length())
        );
        System.out.println(groups);
    }
}
