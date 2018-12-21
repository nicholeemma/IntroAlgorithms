/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 汪无证
 */
public class Nqueens {

    /**
     * @param args the command line arguments
     */
    //print solution
    public Nqueens(int n){
    }
    void printSolution(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    boolean solve(int board[][], int col) {
        if (col >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solve(board, col + 1) == true) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }
boolean solveNQ(int n){
    int board[][] = new int[n][n];
if (solve(board, 0) == false) 
        { 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
  
        printSolution(board); 
        return true; 
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
     //   int board[][] = new int[n][n];
        /*
         ArrayList<Nqueens> nq=new ArrayList<Nqueens>();
         for(int i=0;i<n;i++){nq.add(new Nqueens());}
         for(int i=0;i<n;i++){
         if (nq.get(i).solve(board,i)==true){nq.get(i).printSolution(board); }
      
       
         }*/
        Nqueens nq = new Nqueens(n);
        nq.solveNQ(n);
    }
}
