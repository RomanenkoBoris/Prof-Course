package linkedList;

import lesson8.MyLinkedList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void sizeTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("Test of size method", 3, list.size());
    }

    @Test
    public void containsTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("Test of contains method", true, list.contains("one"));
        assertEquals("Test of contains method", false, list.contains("four"));
    }

    @Test
    public void setTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.set(1, "test");

        assertEquals("Test of set method", "test", list.get(1));
    }

    @Test
    public void addTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("Test of add method", "one", list.get(0));
        assertEquals("Test of add method", "two", list.get(1));
        assertEquals("Test of add method", "three", list.get(2));
    }

    @Test
    public void getTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("Test of get method", "two", list.get(1));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void getExceptionTest(){
        exception.expect(IndexOutOfBoundsException.class);
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.get(3);
    }

    @Test
    public void removeTest(){
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.remove(2);

        assertEquals("Test of remove method", 2, list.size());
    }



}
