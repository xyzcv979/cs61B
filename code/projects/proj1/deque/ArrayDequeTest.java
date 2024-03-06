package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Adds items and checks isEmpty() and size() methods */
    public void addIsEmptySizeTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        myAD.addFirst(1);
        assertFalse(myAD.isEmpty());
    }

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        myAD.addFirst(1);
        assertFalse(myAD.isEmpty());

        myAD.addFirst(2);
        assertEquals(2, myAD.size());

        myAD.printDeque();
    }

    @Test
    public void addFirstWrapAroundTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        myAD.addFirst(1);
        assertFalse(myAD.isEmpty());

        myAD.addFirst(2);
        assertEquals(2, myAD.size());

        myAD.addFirst(3);
        assertEquals(3, myAD.size());

        myAD.addFirst(4);
        assertEquals(4, myAD.size());

        myAD.addFirst(5);
        assertEquals(5, myAD.size());

        myAD.addFirst(6);
        assertEquals(6, myAD.size());

        myAD.addFirst(7);
        assertEquals(7, myAD.size());

        myAD.printDeque();
    }

    @Test
    public void addLastTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addLast(1);
        assertFalse(myAD.isEmpty());

        myAD.addLast(2);
        assertEquals(2, myAD.size());

        myAD.printDeque();
    }

    @Test
    public void addLastWrapAroundTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addLast(1);
        assertFalse(myAD.isEmpty());

        myAD.addLast(2);
        assertEquals(2, myAD.size());

        myAD.addLast(3);
        assertEquals(3, myAD.size());

        myAD.addLast(4);
        assertEquals(4, myAD.size());

        myAD.addLast(5);
        assertEquals(5, myAD.size());

        myAD.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveFirstTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", myAD.isEmpty());

        myAD.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", myAD.isEmpty());

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveLastTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", myAD.isEmpty());

        myAD.removeLast();
        // should be empty
        assertTrue("lld1 should be empty after removal", myAD.isEmpty());

    }

    @Test
    public void removeFirstManyTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", myAD.isEmpty());

        myAD.addFirst(20);
        assertEquals(2, myAD.size());

        myAD.addFirst(30);
        assertEquals(3, myAD.size());

        myAD.removeFirst();
        assertEquals(2, myAD.size());

        myAD.removeFirst();
        assertEquals(1, myAD.size());

        myAD.removeFirst();
        assertEquals(0, myAD.size());
    }

    @Test
    public void rearWrapsToFrontTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());

        myAD.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", myAD.isEmpty());

        myAD.addFirst(20);
        assertEquals(2, myAD.size());


        assertEquals(20, (int)myAD.removeFirst());

        assertEquals(10, (int) myAD.removeFirst());

        assertNull(myAD.removeFirst());

        myAD.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", myAD.isEmpty());

    }

    @Test
    public void addFirstAndResizeTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        for (int i = 1; i <= 8; i++) {
            myAD.addFirst(i);
            assertEquals(i, myAD.size());
        }
        myAD.printDeque();
        // Resize
        myAD.addFirst(9);
        assertEquals(9, myAD.size());
        myAD.printDeque();
    }

    @Test
    public void addLastAndResizeTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        for (int i = 1; i <= 8; i++) {
            myAD.addLast(i);
            assertEquals(i, myAD.size());
        }
        myAD.printDeque();
        // Resize
        myAD.addLast(9);
        assertEquals(9, myAD.size());
        myAD.printDeque();
    }

    @Test
    public void addFirstAndLastAndResizeTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        assertTrue(myAD.isEmpty());
        for (int i = 1; i <= 9; i++) {
            myAD.addLast(i);
            myAD.addFirst(i);
        }
        myAD.printDeque();
        assertEquals(16, myAD.size());

    }
//
//    @Test
//    /* Tests removing from an empty deque */
//    public void removeEmptyTest() {
//        ArrayDeque<Integer> myAD = new ArrayDeque<>();
//        lld1.addFirst(3);
//
//        lld1.removeLast();
//        lld1.removeFirst();
//        lld1.removeLast();
//        lld1.removeFirst();
//
//        int size = lld1.size();
//        String errorMsg = "  Bad size returned when removing from empty deque.\n";
//        errorMsg += "  student size() returned " + size + "\n";
//        errorMsg += "  actual size() returned 0\n";
//
//        assertEquals(errorMsg, 0, size);
//    }
//
//    @Test
//    /* Check if you can create LinkedListDeques with different parameterized types*/
//    public void multipleParamTest() {
//        ArrayDeque<Integer> myAD1 = new ArrayDeque<>();
//        ArrayDeque<Integer> myAD2 = new ArrayDeque<>();
//        ArrayDeque<Integer> myAD3 = new ArrayDeque<>();
//
//        lld1.addFirst("string");
//        lld2.addFirst(3.14159);
//        lld3.addFirst(true);
//
//        String s = lld1.removeFirst();
//        double d = lld2.removeFirst();
//        boolean b = lld3.removeFirst();
//    }
//
//    @Test
//    /* check if null is return when removing from an empty LinkedListDeque. */
//    public void emptyNullReturnTest() {
//        ArrayDeque<Integer> myAD = new ArrayDeque<>();
//
//        boolean passed1 = false;
//        boolean passed2 = false;
//        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
//        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
//    }
//
//    @Test
//    /* Add large number of elements to deque; check if order is correct. */
//    public void bigLLDequeTest() {
//        ArrayDeque<Integer> myAD = new ArrayDeque<>();
//        for (int i = 0; i < 1000000; i++) {
//            lld1.addLast(i);
//        }
//
//        for (double i = 0; i < 500000; i++) {
//            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
//        }
//
//        for (double i = 999999; i > 500000; i--) {
//            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
//        }
//    }
//
    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> myAD = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                System.out.println("addLast(" + randVal + ")");
                myAD.addLast(randVal);
            } else if (operationNumber == 1) {
                int size = myAD.size();
                System.out.println("size: " + size);
            } else {
                if (myAD.size() > 0) {
                    System.out.println("getLast: " + myAD.removeLast());
                }
            }
        }

    }
//
//
//    @Test
//    public void equalsTest() {
//        ArrayDeque<Integer> myAD1 = new ArrayDeque<>();
//        ArrayDeque<Integer> myAD2 = new ArrayDeque<>();
//        // should be empty
//        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());
//        assertTrue("lld2 should be empty upon initialization", lld2.isEmpty());
//
//        for (int i = 0; i < 1000; i++) {
//            lld1.addLast(i);
//            lld2.addLast(i);
//        }
//        // should not be empty
//        assertFalse("lld1 should contain 1 item", lld1.isEmpty());
//        assertFalse("lld1 should contain 1 item", lld2.isEmpty());
//
//        // should be empty
//        assertTrue("lld1 and lld2 should be equal", lld1.equals(lld2));
//    }
//
//    @Test
//    public void iteratorTest() {
//        ArrayDeque<Integer> myAD = new ArrayDeque<>();
//        for (int i = 0; i < 1000; i++) {
//            myAD.addLast(i);
//        }
//        int i = 0;
//        for (int x : myAD) {
//            assertEquals("lld1 enhanced for loop should match i value", i, x);
//            i++;
//        }
//        assertEquals("i index should have incremented until 1000", 1000, i);
//    }
}
