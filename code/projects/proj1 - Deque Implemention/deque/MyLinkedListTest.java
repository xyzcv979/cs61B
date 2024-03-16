package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {

    @Test
    public void testSize() {
        MyLinkedList<Integer> llist = new MyLinkedList<>(0);
        assertEquals(1, llist.size());
    }

    @Test
    public void testisEmpty() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        assertEquals(0, llist.size());
    }

    @Test
    public void testAddLast() {
        MyLinkedList<String> llist = new MyLinkedList<>();
        assertEquals(0, llist.size());
        llist.addLast("1");
        assertEquals(1, llist.size());
        llist.addLast("2");
        assertEquals(2, llist.size());
    }

    @Test
    public void testGet() {
        MyLinkedList<String> llist = new MyLinkedList<>();
        String item = "1";
        llist.addLast(item);
        assertEquals(1, llist.size());
        String getItem = llist.get(llist.size()-1);
        assertEquals(item, getItem);
    }

    @Test
    public void testInsert() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        int item = 1;
        llist.insert(item, 0);
        assertEquals(1, llist.size());
        assertEquals((Integer) item, (Integer) llist.get(0));
    }

    @Test
    public void testManyInserts() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        for (int i = 0; i < 50; i++) {
            llist.insert(i, i);
        }
        assertEquals(50, llist.size());
        assertEquals((Integer) 49, llist.getLast());
    }


    @Test
    public void testAddFirst() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addFirst(1);
        assertEquals((Integer) 1, llist.get(0));
        llist.addFirst(2);
        assertEquals((Integer) 2, llist.get(0));
        llist.addFirst(3);
        assertEquals((Integer) 3, llist.get(0));
    }

    @Test
    public void testGetFirst() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(3);
        assertEquals((Integer) 3, llist.get(0));
    }

    @Test
    public void testRemoveLast() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addLast(1);
        llist.addLast(2);
        llist.addLast(3);
        assertEquals((Integer) 3, llist.get(llist.size()-1));
        assertEquals(3, llist.size());
        assertEquals((Integer) 3, llist.removeLast());
        assertEquals(2, llist.size());
    }

    @Test
    public void testGetLast() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(3);
        assertEquals((Integer) 1, llist.get(llist.size()-1));
    }

    @Test
    public void testRemoveFirst() {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addLast(1);
        llist.addLast(2);
        llist.addLast(3);
        assertEquals(3, llist.size());
        assertEquals((Integer) 1, llist.removeFirst());
        assertEquals(2, llist.size());
    }
}
