/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurision;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author 汪无证
 */
public class Recurision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // System.out.println("sum is"+XMethod(5));
        // XMethod1(12345678);
        //  xMethod2(5);
        //    Test test = new Test();
        //    System.out.println(test.toString());
        // System.out.println(isPali("dasddsa"));
    //    int[] list = {2, 1, 3, 5, 2, 7, 6, 8};
    //    sort(list, 0, list.length - 1);
     //   for (int i = 0; i < list.length; i++) {
     //       System.out.println(list[i] + " ");
    //    }
    //    System.out.println(recursiveBinarySearch(list,2,0,list.length-1));
  //      System.out.println("enter a directory or a file");
  //      Scanner input =new Scanner(System.in);
   //     String directory=input.nextLine();
   //     System.out.println(getSize(new File(directory))+"bytes");
        
        moveDisk(7,'a','b','c');
    }
//recursively add n--1

    public static int XMethod(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + XMethod(n - 1);
        }
    }
//recursively print out digits from the right 

    public static void XMethod1(int n) {
        if (n > 0) {
            System.out.println(n % 10);
            XMethod1(n / 10);
        }
    }

    //first do recursion, complete all recursions, then print out numbers
    //output will be 1 2 3 4 5
    public static void xMethod2(int n) {
        if (n > 0) {
            xMethod2(n - 1);
            System.out.print(n + " ");
            /*  System.out.print(n + " ");
             xMethod2(n - 1);
             */
            //output will be 5 4 3 2 1
        }
    }

    //recursivePalindrome
    public static boolean isPali(String s) {
        if (s.length() <= 1) {
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        } else {
            return isPali(s.substring(1, s.length() - 1));
        }
    }

    public static void sort(int[] list, int low, int high) {
        if (low < high) {
            int index = low;
            int min = list[low];
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    index = i;
                    min = list[i];
                }
            }

            list[index] = list[low];
            list[low] = min;

            sort(list, low + 1, high);
        }
    }
    public static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high) {
            return 0;
        }
        int mid = (low + high) / 2;
        if (key == list[mid]) {
            return mid;
        } else if (key > list[mid]) {
            return recursiveBinarySearch(list, key, mid + 1, high);
        } else {
            return recursiveBinarySearch(list, key, low, mid - 1);
        }
    }
    
    public static long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            //return an array of File object under a directory
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                size += getSize(files[i]);
            }
        } else {
            // the size of file
            size += file.length();
        }
        return size;
    }
        
        public static void moveDisk(int n,char beg,char aux,char goal){
         if (n==1) System.out.println(" from " +beg+" to "+goal);
         else{
         moveDisk(n-1,beg,goal,aux);
         moveDisk(1,beg,aux,goal);
         moveDisk(n-1,aux,beg,goal);}
        }
}
