/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackqueue;

/**
 *
 * @author Jiayue(nichole) Yang
 */
//<E extends Comparable<E>> depends on Class Heap 
public class PriorityQueue<E extends Comparable<E>> {

    private Heap<E > heap = new Heap<>();

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }

}
