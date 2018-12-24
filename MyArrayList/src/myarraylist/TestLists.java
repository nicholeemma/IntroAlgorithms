/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;

/**
 * For testing arraylist creation and linkedlist creation
 * @author Nichole(Jiayue) Yang
 */
public class TestLists {

    public static void main(String[] args) {
       
        MyList<String> list = new MyArrayList<String>();
        // Add elements to the list
        list.add("America"); // Add it to the list     
        System.out.println("(1) " + list);
        list.add(0, "Canada"); // Add it to the beginning of the list       
        System.out.println("(2) " + list);
        list.add("Russia"); // Add it to the end of the list       
        System.out.println("(3) " + list);
        list.add("France"); // Add it to the end of the list      
        System.out.println("(4) " + list);
        list.add(2, "Germany"); // Add it to the list at index 2 
        System.out.println("(5) " + list);
        list.add(5, "Norway"); // Add it to the list at index 5       
        System.out.println("(6) " + list); // Remove elements from the list 
        list.remove("Canada"); // Same as list.remove(0) in this case     
        System.out.println("(7) " + list);
        list.remove(2); // Remove the element at index 2    
        System.out.println("(8) " + list);
        list.remove(list.size() - 1); // Remove the last element       
        System.out.print("(9) " + list + "\n(10) ");
        for (String s : list) {
            System.out.print(s.toUpperCase() + " ");
        }

        MyLinkedList<String> linkedlist = new MyLinkedList<>();
        linkedlist.add("american");
        linkedlist.add("american");
        linkedlist.add("american");
        System.out.println("1" + linkedlist);
        linkedlist.removeFirst();
         System.out.println("1.1" + linkedlist);
        linkedlist.add(1, "canada");
        System.out.println("2" + linkedlist);
        System.out.println(linkedlist.lastIndexOf("american"));
        linkedlist.add("russia");
        System.out.println("3" + linkedlist);
        linkedlist.addFirst("france");
        System.out.println("4" + linkedlist);
        linkedlist.addLast("germany");
        System.out.println("5" + linkedlist);
        linkedlist.remove("germany");
        System.out.println("6" + linkedlist);
        linkedlist.remove(2);
        System.out.println("7" + linkedlist);
        linkedlist.remove(linkedlist.size - 1);
        System.out.println("8" + linkedlist);

        for (String s : linkedlist) {
            System.out.print(s.toUpperCase() + " ");
        }
        for(int i=1;i<2;i++)System.out.println("a");

    }

}
