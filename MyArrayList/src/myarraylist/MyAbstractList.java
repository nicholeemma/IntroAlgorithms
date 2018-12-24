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
public abstract class MyAbstractList<E> implements MyList<E> {

    // size of list
    protected int size = 0;

    // create default list ??
    
    protected MyAbstractList() {
    }

    
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
// add a new element at the end of this list
    public void add(E e) {
        add(size, e);
    }

    // return true if the list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    // return the number of elements in this list
    public int size() {
        return size;
    }

    // remove the first matching element in the list return true if the element is removed
@Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }
}
