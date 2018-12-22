/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author 汪无证
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        //create a heap of integers
        Heap<E> heap = new Heap<>();
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        for (int i = list.length - 1; i >= 0; i--) {
            heap.remove();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] list = {3, 2, 5, 3, 12, 21, 33, 14, 26};
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");
        }
    }

}
