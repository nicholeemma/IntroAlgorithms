/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author 汪无证
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearch<E> {
    /**create an AVL tree **/
    public AVLTree(){}
    /**create an AVL tree from an array of objects**/
    public AVLTree(E[] objects){
    super(objects);}
    @Override
    protected AVLTreeNode<E> createNewNode(E e){
    return new AVLTreeNode<E>(e);}
}
