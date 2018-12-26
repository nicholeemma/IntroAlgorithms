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
public class GenericStack<E> {

    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeLast();
    }

    @Override
    public String toString() {
        return "Stack:" + list.toString();
    }
    
}
