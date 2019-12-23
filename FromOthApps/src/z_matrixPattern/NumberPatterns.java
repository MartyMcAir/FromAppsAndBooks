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
public class NumberPatterns {

    private static void numPattern5() {
//Enter number of rows: 5
//Here is your pattern....!!!
//0  
//1 2  
//3 4 5  
//6 7 8 9  
//10 11 12 13 14 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        int k = 0;
        System.out.println("Here is your pattern....!!!");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println(" ");
        }
    }

    private static void numPattern4() {
//Enter number of rows: 5
//Here is your pattern....!!!
//1
//10
//101
//1010
//10101
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int rows = sc.nextInt();

        System.out.println("Here is your pattern....!!!");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 0) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
            System.out.println();
        }
        sc.close();
    }

    private static void numPattern3() {
//Enter number of rows: 5
//Here is your pattern....!!!
//5 4 3 2 1 
//5 4 3 2 
//5 4 3 
//5 4 
//5 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int rows = sc.nextInt();

        System.out.println("Here is your pattern....!!!");

        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j >= i; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
        sc.close();
    }

    private static void numPattern2() {
//Enter number of rows: 5
//your pattern is: -
//1 
//1 2 
//1 2 3 
//1 2 3 4 
//1 2 3 4 5 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int rows = sc.nextInt();

        System.out.println("your pattern is: -");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void numPattern1() {
//Enter number of rows: 5
//Here is your pattern....!!!
//5 4 3 2 1 
//4 3 2 1 
//3 2 1 
//2 1 
//1
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int rows = sc.nextInt();

        System.out.println("Here is your pattern....!!!");

        for (int i = rows; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
        sc.close();
    }
}
