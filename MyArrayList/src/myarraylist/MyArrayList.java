/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;

/**
 * Arraylist
 *
 * @author Nichole(Jiayue) Yang
 */
public class MyArrayList<E> extends MyAbstractList<E> {

    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    //default constructor
    public MyArrayList() {
    }

    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

// enlarge arraylist capacity to ensure arraylist can store enough data
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 - 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // return true if the list contains the element
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // return the element from list at the specified index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    // check index is within the scope
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    // return the index of first matching element in the list
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // return the last index of first matching element in the list 
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // remove the index of element in the list return the removed element
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        // Shift data to the left 
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        // This element is now null
        data[size - 1] = null;
        // Decrement size 
        size--;
        return e;
    }

    // replace the element at the specified position in this list with specified element and return the old element
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }

    @Override
    /**
     * Override iterator() defined in Iterable The iterator() method defined in
     * the java.lang.Iterable interface is implemented to return an instance on
     * java.util.Iterator The ArrayListIterator class implements Iterator with
     * concrete methods for hasNext, next, and remove It uses current to denote
     * the current position of the element being traversed
     */
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {

        // Current index 

        private int current = 0;

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
