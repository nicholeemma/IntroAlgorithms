/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 * define all common operations for trees 
 * @author 汪无证
 */
public interface Tree <E extends Comparable<E>> extends Iterable<E>{
    // return true if the element is in the tree
    public boolean search(E e);
    // return true if the element is inserted successfully
    public boolean insert(E e);
    // return true if the element is deleted successfully
    public boolean delete(E e);
    // inorder traversal from the root
    public void inorder();
    
    public void postorder();
    
    public void preorder();
    
    public int getSize();
    
    public boolean isEmpty();
    
    
}
