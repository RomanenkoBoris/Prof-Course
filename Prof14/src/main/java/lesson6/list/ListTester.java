package lesson6.list;

public class ListTester {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList);
        System.out.println(arrayList.get(4));
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
