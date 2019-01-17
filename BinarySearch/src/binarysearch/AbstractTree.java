/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author 汪无证
 * @param <E>
 */
public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {

    /**
     *
     */
    public void inorder() {
    }

    /**
     *
     */
    public void postorder() {
    }

    /**
     *
     */
    public void preorder() {
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }
;

}
