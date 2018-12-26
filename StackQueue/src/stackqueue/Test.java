/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackqueue;

/**
 *
 * @author 汪无证
 */
public class Test {
    public static void main(String[] args) {
        // TODO code application logic here
        GenericStack<String> stack=new GenericStack<>();
        stack.push("tom");
        System.out.println("1"+stack);
        stack.push("alice");
        System.out.println("2"+stack);
        stack.push("mike");
        stack.push("doub");
        System.out.println("3"+stack);
        System.out.println("4"+stack.pop());
        System.out.println("5"+stack.pop());
        System.out.println("6"+stack);
        
        GenericQueue<String> queue=new GenericQueue<>();
        queue.enqueue("susan");
        System.out.println("1"+queue);
        queue.enqueue("kim");
        System.out.println("2"+queue);
        queue.enqueue("kimi");
        queue.enqueue("kien");
        System.out.println("3"+queue);
        System.out.println("4"+queue.dequeue());
        System.out.println("5"+queue.dequeue());
        System.out.println("6"+queue);
    }
}
