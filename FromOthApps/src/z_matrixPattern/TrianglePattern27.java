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
public class TrianglePattern27 {

    public static void main(String[] args) {
//Enter row for pattern : 10
//Here is your pattern....!!!
//1 
//1 2 
//1 2 3 
//1 2 3 4 
//1 2 3 4 5 
//1 2 3 4 5 6 
//1 2 3 4 5 6 7 
//1 2 3 4 5 6 7 8 
//1 2 3 4 5 6 7 8 9 
//1 2 3 4 5 6 7 8 9 10 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row for pattern : ");
        int rows = sc.nextInt();
        System.out.println("Here is your pattern....!!!");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
