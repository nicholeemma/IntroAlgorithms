/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;

/**
 *
 * @author Nichole(Jiayue) Yang
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

    /**
     * Create a default list
     */
    public MyLinkedList() {
    }

    /**
     * Create a list from an array of objects
     */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /**
     * Return the head element in the list
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /**
     * Add an element to the beginning of the list
     */
    public void addFirst(E e) {
        //create a node
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        // increase the size
        size++;
        // the new node is the only node in the list
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Add an element to the end of the list
     */
    public void addLast(E e) {

        Node<E> newNode = new Node<>(e);
        // if new node is the only node in the list
        if (tail == null) {
            head = tail = newNode;
        } else {
            // link the newnode with last node
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    /**
     * Add a new element at the specified index in this list. The index of the
     * head element is 0
     */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            // locate the current node
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> tmp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = tmp;
            size++;
        }

    }

    /**
     * Remove the head node and * return the object that is contained in the
     * removed node. *
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> tmp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return tmp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> tmp = head;
            head = tail = null;
            size = 0;
            return tmp.element;
        } else {
            Node<E> current = head;
            //locate the node before last node
            for (int i = 1; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> tmp = tail;
            tail = current;
            tail.next = null;
            size--;
            return tmp.element;

        }

    }

    @Override
    /**
     * Remove the element at the specified position in this62 * list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        } else {
            Node<E> previous = head;
            //locate previous
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;

            if (current != null) {
                result.append(", "); // Separate two elements with a comma      
            } else {
                result.append("]"); // Insert the closing ] in the string     
            }
        }
        return result.toString();
    }

    @Override
    /**
     * Clear the list
     */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    /**
     * Return true if this list contains the element e
     */
    public boolean contains(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> tmp = head;
        for (int i = 1; i < size; i++) {
            tmp = tmp.next;
            if (e.equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * Return the element at the specified index
     */
    public E get(int index) {

        Node<E> tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.element;
    }

    @Override
    /**
     * Return the index of the head matching element  in this list. 
     * Return -1 if no match.
     */
    public int indexOf(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> tmp = head;
        for (int i = 1; i < size; i++) {
            tmp = tmp.next;
            if (e==(tmp.element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the index of the last matching element in this list. 
     * Return -1 if no match.
     */
    @Override
    public int lastIndexOf(E e) {
        int index1=-1;
      
        Node<E> tmp = head;
        for (int i = 1; i < size; i++) {
            tmp = tmp.next;
            if (e==(tmp.element)) {
                index1=i;
            }
        }
        return index1;
       
    }

    @Override
    /**
     * Replace the element at the specified position  in this list with the
     * specified element.
     */
    public E set(int index, E e) {
        if (index < 0 || index > size) {
            return null;
        }
        Node<E> newNode = new Node<>(e);
        Node<E> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.next = newNode;

        return current.element;
    }

    @Override
    /**
     * Override iterator() defined in Iterable
     */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();

    }

    private class LinkedListIterator implements java.util.Iterator<E> {

        private Node<E> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

   //     @Override
  //      public void remove() {

    //    }
    }

    /* 
    This class is only used in LinkedList, so it is private. 
    This class does not need to access any 
    instance members of LinkedList, so it is defined static. 
    */
    
    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
