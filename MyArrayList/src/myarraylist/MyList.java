/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;

/**The design guide
 * The common operations can be generalized in an interface or an abstract class. 
 * A good strategy is to combine the virtues of interfaces and abstract classes 
 * by providing both an interface and a convenience abstract class in the design 
 * so that the user can use either of them, whichever is convenient. 
 * The abstract class provides a skeletal implementation of the interface, 
 * which minimizes the effort required to implement the interface. 
 *
 * @author 汪无证
 */
public interface MyList<E> extends java.lang.Iterable<E> {
    // add a new element at the end of this list
    public void add(E e);
    // add a new element at the specified index in this list
    public void add(int index, E e);
    // clear the list
    public void clear();
    // return true if the list contains the element
    public boolean contains(E e);
    // return true if the list is empty
    public boolean isEmpty();
    // return the element from list at the specified index
    public E get(int index);
    // return the index of first matching element in the list
    public int indexOf(E e);
    // return the last index of first matching element in the list 
    public int lastIndexOf(E e);
    // remove the first matching element in the list return true if the element is removed
    public boolean remove(E e);
    // remove the index of element in the list return the removed element
    public E remove(int index);
    //  replace the element at the specified position in this list with specified element and return the old element
    public E set(int index,E e);
    // return the number of elements in this list
    public int size();
    
}
