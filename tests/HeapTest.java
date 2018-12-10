import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for the heap object
 *
 * @author Lauren Rose
 * @version 9 December 2018
 *
 * ITEC 324 - Principles of Computer Science III
 * Radford University, Department of Information Technology
 *
 * All code herein is for use only by the author. Author has
 * taken necessary measures to protect this code from being
 * accessible to other students, and therefore is not
 * responsible for any unauthorized use.
 */
class HeapTest {

    private Heap testHeap;

    @BeforeEach
    void init() {
        testHeap = new Heap(10);
        int[] testData = {4, 3, 8, 2 ,5, 1, 9, 6, 0, 7};

        for (int number : testData) {
            testHeap.add(number);
        }
    }

    @Test
    void add() {
        int expectedSize = 10;
        assertEquals(expectedSize, testHeap.size());
    }

    @Test
    void smallest() {
        int expectedSmallest = 0;
        assertEquals(expectedSmallest, testHeap.smallest());
    }

    @Test
    void remove() {
        int expectedSize = 9;
        testHeap.remove();
        assertEquals(expectedSize, testHeap.size());
    }

    @Test
    void size() {
        int expectedSize = 10;
        assertEquals(expectedSize, testHeap.size());
    }
}