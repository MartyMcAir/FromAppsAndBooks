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
public class AlphabetPattern11 {

    public static void main(String[] args) {
//Enter number of rows: 5
//Here is your pattern....!!!
//A
//BC
//DEF
//GHIJ
        int alphabet = 65;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Here is your pattern....!!!");

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char) alphabet);
                alphabet++;
            }
            System.out.println();
        }
        sc.close();
    }
}
