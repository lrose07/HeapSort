import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class demonstrates the accompanying Heap.java class
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
 *
 * Test data: 4 3 9 2 5 1 8 6 0 7 -1
 */
public class HeapSorter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> initialInput = new ArrayList<>();

        int tempValue = 0;

        while(tempValue != -1) {
            tempValue = scan.nextInt();
            if (tempValue != -1) {
                initialInput.add(tempValue);
            }
        }

        Heap heap = new Heap(initialInput.size());

        for (int value : initialInput) {
            heap.add(value);
        }

        heap.heapify();
        heap.sortHeap();
        heap.printHeap();
    }
}