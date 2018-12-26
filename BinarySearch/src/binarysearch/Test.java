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
public class Test {

    public static void main(String[] args) {// Create a BST
        BinarySearch<String> tree = new BinarySearch<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        // Traverse tree      
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        // Search for an element     
        System.out.print("\nIs Peter in the tree? "
                + tree.search("Peter"));
        // Get a path from the root to Peter       
        System.out.print("\nA path from the root to Peter is: ");
        java.util.ArrayList<BinarySearch.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++) {
            System.out.print(path.get(i).element + " ");
        }
        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BinarySearch<Integer> intTree = new BinarySearch<>(numbers);
        System.out.print("\nInorder (sorted): ");
        intTree.inorder();
    }

}
