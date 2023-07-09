package lesson7;

import lesson6.list.MyArrayList;
import lesson6.list.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTester {
    public static void main(String[] args) {

        // итератор - механизм перебора элементов любого контейнера
        List<String> capitals = new ArrayList<>(Arrays.asList("Bogota", "Brazilia", "Buenos-Aires", "Santiago"));
        Iterator<String> capitalsIterator = capitals.iterator();
        // прежде чем обращаться к итератору за элементом
        // нужно спросить у него, а есть ли он
        while (capitalsIterator.hasNext())
        {
            System.out.println("element is: " + capitalsIterator.next());
        }
        List<Integer> integerList = new ArrayList<>(Arrays.asList(-2, 1,2,3,4,5,6,7));
        Iterator<Integer> integerIterator = integerList.iterator();

        while (integerIterator.hasNext()){
            System.out.println("element is: " + integerIterator.next());
        }

        MyList myList = new MyArrayList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        Iterator<Integer> myListIterator = myList.iterator();

        while (myListIterator.hasNext()) {
            System.out.println("my list element: " + myListIterator.next());
        }

        List<String> rivers = new ArrayList<>();
        rivers.add("Rein");
        rivers.add("Vistula");
        rivers.add("Oder");
        rivers.add("Danube");
        rivers.add("Sena");
        rivers.add("Ruhr");

        for(int i = 0; i < rivers.size(); i++){
            System.out.println("standard for: " + rivers.get(i));
        }

        for(String r :  rivers){
            System.out.println("foreach: " + r);
        }

        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        for (Integer r: intList){
            System.out.println("element " + r);
        }

        for(Integer i: myList)
        {
            System.out.println("myList for-each element: " + i);
        }
    }
}
