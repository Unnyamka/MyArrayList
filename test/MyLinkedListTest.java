import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class MyLinkedListTest {

    @Test
    void testAddAndGet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemove() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String removedElement = list.remove(1);
        assertEquals("two", removedElement);
        assertEquals(2, list.size());
        assertEquals("three", list.get(1));
    }

    @Test
    void testAddAll() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        List<Integer> additionalList = Arrays.asList(4, 5, 6);
        list.addAll(additionalList);

        assertEquals(3, list.size());
        assertEquals(4, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(6, list.get(2));
    }

    @Test
    void testBubbleSort() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        MyLinkedList.bubbleSort(list);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testConstructorWithCollection() {
        List<String> initialList = Arrays.asList("a", "b", "c");
        MyLinkedList<String> list = new MyLinkedList<>(initialList);

        assertEquals(3, list.size());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }
}
