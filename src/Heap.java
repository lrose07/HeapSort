/**
 * This class uses a heap data structure to sort a list of ints
 * The underlying data structure of teh heap is an array and
 * the recursively builds min-heaps to sort the numbers
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
class Heap {

    private int[] heap;
    private int end;
    private int heapEnd;

    /**
     * creates a new empty heap
     *
     * @param size the size to make the underlying array
     */
    public Heap(int size) {
        heap = new int[size];
        end = -1;
    }

    /**
     * adds the int i to the heap
     *
     * @param i the int to add to the heap
     */
    public void add(int i) {
        end++;
        heapEnd = end;
        heap[end] = i;
        heapify();
    }

    void printHeap() {
        System.out.println("Current heap: ");
        for (int j = 0; j <= end; j++) {
            System.out.print(heap[j] + "   ");
        }
        System.out.println();
    }

    /**
     * returns the smallest value in the heap (without changing the heap)
     */
    public int smallest() {
        heapify();
        return heap[0];
    }

    /**
     * removes the smallest value from the heap
     */
    public void remove() {
        heapify();
        swapTwoNodes(0, heapEnd);
        heapEnd--;
    }

    /**
     * returns the number of elements currently in the heap
     *
     * @return the size of the heap
     */
    public int size() {
        return heapEnd + 1;
    }

    /**
     * sorts the heap into a min-heap
     */
    public void heapify() {
        heapify(0);
    }

    private void heapify(int i) {

        int rightChildIndex = 2*i+2;
        int leftChildIndex = 2*i+1;

        if (i < heapEnd / 2) {
            if ((rightChildIndex) < heapEnd) {
                heapify(rightChildIndex);
            }
            if ((leftChildIndex) < heapEnd) {
                heapify(leftChildIndex);
            }

            int minChildIndex = ((rightChildIndex) > heapEnd) ? heap[leftChildIndex] :
                    heap[leftChildIndex] <= heap[rightChildIndex] ? leftChildIndex : rightChildIndex;

//            int minChildIndex = 0;
//
//            if ((2*i+2) > heapEnd) {
//                minChildIndex = 2*i+1;
//            } else {
//                if (heap[2*i+1] <= heap[2*i+2]) {
//                    minChildIndex = 2*i+1;
//                } else {
//                    minChildIndex = 2*i+2;
//                }
//            }

            if (heap[i] > heap[minChildIndex]) {
                swapTwoNodes(i, minChildIndex);
            }
        }
    }

    private void swapTwoNodes(int indexOne, int indexTwo) {
        int tempValue = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = tempValue;
    }

    void sortHeap() {
        heapify();
        for (int i = heapEnd; i >= 0; i--) {
            remove();
        }
        reverseHeap();
    }

    private void reverseHeap() {
        for(int i = 0; i < heap.length / 2; i++)
        {
            int temp = heap[i];
            heap[i] = heap[heap.length - i - 1];
            heap[heap.length - i - 1] = temp;
        }
    }
}