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
public class BinarySearch<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearch() {
    }

    public BinarySearch(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    public boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        // if the tree is empty, create a root node with new element
        if (root == null) {
            root = createNewNode(e);
        } else {
            //locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    //keep the parent
                    parent = current;
                    // go left
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    // duplicate node not inserted
                    return false;
                }
            }
            // create a new node for e and attach it to parent
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }

        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    // with inorder traversal, the left subtree of the current node is visited first recursively, 
    // then the current node, and 
    // the finally right subtree of the current node recursively
    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    // the left subtree of the current node is visited recursively first
    // the recursively the right subtree of the current node
    // finally the current node itself
    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    // the current node is visited first
    // then recursively the left subtree of the current node 
    /// finally the right subtree of the current node
    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);

    }

    /**
     * inner class for node *
     */
    public static class TreeNode<E extends Comparable<E>> {

        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return list;
    }

    /* delete an element from the binary search tree
     * return true if the element is deleted successfully
     * false if the element is not in the tree
     */
    public boolean delete(E e) {

        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
                // element is in the tree pointed by current
            }

        }
        //element is not in the tree
        if (current == null) {
            return false;
        }

        // left subtree is null
        if (current.left == null) 
        {
            // if e is the root, delete the root
            if (parent == null) 
               {
                root = current.right;
                } 
            else 
            {

                if (e.compareTo(current.element) < 0) 
                {
                    parent.left = current.right;
                } 
                else 
                {
                    parent.right = current.right;
                }
            }
        } 
        // left subtree is not null
        // find the largest one in the left subtree, namely the rightest one in the left subtree
        else 
        {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right 
            }
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;
            // Eliminate rightmost node 
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = null;
            } else if // Special case: 
                    (parentOfRightMost == current) {
                parentOfRightMost.left = rightMost.left;
            }
        }

        size--;
        return true; // Element deleted successfully 
    }

    @Override
    /**
     * Obtain an iterator. Use inorder.
     */
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {

        // Store the elements in a list 
        private java.util.ArrayList<E> list
                = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list 

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }
}
