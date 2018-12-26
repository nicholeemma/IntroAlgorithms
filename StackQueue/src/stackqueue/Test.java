/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackqueue;

/**
 *
 * @author Jiayue(nichole) Yang
 */
public class Test {

    public static void main(String[] args) {
        // TODO code application logic here
        GenericStack<String> stack = new GenericStack<>();
        stack.push("tom");
        System.out.println("1" + stack);
        stack.push("alice");
        System.out.println("2" + stack);
        stack.push("mike");
        stack.push("doub");
        System.out.println("3" + stack);
        System.out.println("4" + stack.pop());
        System.out.println("5" + stack.pop());
        System.out.println("6" + stack);

        GenericQueue<String> queue = new GenericQueue<>();
        queue.enqueue("susan");
        System.out.println("1" + queue);
        queue.enqueue("kim");
        System.out.println("2" + queue);
        queue.enqueue("kimi");
        queue.enqueue("kien");
        System.out.println("3" + queue);
        System.out.println("4" + queue.dequeue());
        System.out.println("5" + queue.dequeue());
        System.out.println("6" + queue);

        Patient patient1 = new Patient("john", 1);
        Patient patient2 = new Patient("jessie", 15);
        Patient patient3 = new Patient("jerk", 3);
        Patient patient4 = new Patient("joss", 4);
        PriorityQueue<Patient> priorityqueue = new PriorityQueue<>();
        priorityqueue.enqueue(patient1);
        priorityqueue.enqueue(patient2);
        priorityqueue.enqueue(patient3);
        priorityqueue.enqueue(patient4);

        while (priorityqueue.getSize() > 0) {
            System.out.println(priorityqueue.dequeue() + " ");
        }
    }

    static class Patient implements Comparable<Patient> {

        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + "(priority:)" + priority + ")";
        }

        @Override
        public int compareTo(Patient patient) {
            return this.priority - patient.priority;
        }
    }
}

