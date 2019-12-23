/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_matrixPattern;

import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class PacManPattern28 {

    public static void main(String[] args) {
//Enter row for pattern : 5
//Here is your pattern....!!!
//1 2 3 4 5 
//1 2 3 4 
//1 2 3 
//1 2 
//1 
//1 2 
//1 2 3 
//1 2 3 4 
//1 2 3 4 5
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row for pattern : ");
        int rows = sc.nextInt();
        System.out.println("Here is your pattern....!!!");

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
