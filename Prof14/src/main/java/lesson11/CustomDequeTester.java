package lesson11;

public class CustomDequeTester {
    public static void main(String[] args) {
        CustomDeque c = new CustomDequeImpl();
        c.addFirst(3);
        c.addFirst(2);
        c.addFirst(1);
        System.out.println(c);
        c.addFirst(0);
        c.addFirst(-1);
        System.out.println(c);
        System.out.println(c.getFirst());
        System.out.println(c.removeFirst());
        System.out.println(c);
        System.out.println(c.getLast());
        c.addLast(4);
        System.out.println(c);
        System.out.println(c.removeLast());
        System.out.println(c);
    }
}
