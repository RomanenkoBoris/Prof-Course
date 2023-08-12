package lesson8;

public class MyLinkedListTester {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(12);
        list.add(5);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.contains(33)); // false
        System.out.println(list.contains(12)); // true

        list.add(1, 22);
        System.out.println(list); // 1, 22, 12, 5
        System.out.println(list.size()); // 4

        list.add(4, -2);
        System.out.println(list); // 1, 22, 12, 5, -2
        System.out.println(list.size()); // 5

        list.remove(3);
        list.remove(1);
        System.out.println(list); // 1 12 -2
        System.out.println(list.size()); // 3

        list.removeFirst();
        System.out.println(list); // 12 -2

        list.addFirst(33);
        System.out.println(list); // 33 12 -2
        System.out.println(list.size()); // 3
    }
}
