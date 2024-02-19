package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correctAList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        correctAList.addLast(4);
        buggyAList.addLast(4);
        correctAList.addLast(5);
        buggyAList.addLast(5);
        correctAList.addLast(6);
        buggyAList.addLast(6);

        correctAList.removeLast();
        buggyAList.removeLast();
        for (int i = 0; i < correctAList.size(); i++) {
            assertEquals(correctAList.get(i), buggyAList.get(i));
        }

        correctAList.removeLast();
        buggyAList.removeLast();
        for (int i = 0; i < correctAList.size(); i++) {
            assertEquals(correctAList.get(i), buggyAList.get(i));
        }

        correctAList.removeLast();
        buggyAList.removeLast();
        for (int i = 0; i < correctAList.size(); i++) {
            assertEquals(correctAList.get(i), buggyAList.get(i));
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                buggy.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else {
                if (L.size() > 0) {
                    System.out.println("getLast: " + L.getLast());
                    L.removeLast();
                    System.out.println(buggy.getLast());
                    buggy.getLast();
                }
            }
        }

    }
}
