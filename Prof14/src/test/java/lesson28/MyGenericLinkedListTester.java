package lesson28;

import lesson8.MyLinkedList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class MyGenericLinkedListTester {
    @Test
    public void generalWork() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertEquals(list.size(), 0);
        list.add("Brazil");
        list.add("Tunis");
        list.add("Guinea");

        assertEquals(list.size(), 3);
        assertTrue(list.contains("Brazil"));
        assertFalse(list.contains("France"));

        // assertEquals(list.removeFirst(), "Brazil");

        assertEquals(list.size(), 2);

    }
    @Test
    public void testException() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Brazil");
        try {
            String s = list.get(10);
        }
        catch (Exception e)
        {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }
}
