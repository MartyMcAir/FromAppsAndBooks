/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_SortingAlgorithms;

import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class SortNameInAscending {

    public static void main(String args[]) {
        String temp;
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = SC.nextInt();
        SC.nextLine();

        String names[] = new String[N];

        System.out.println("Enter names: ");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter name [ " + (i + 1) + " ]: ");
            names[i] = SC.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (names[j - 1].compareTo(names[j]) > 0) {
                    temp = names[j - 1];
                    names[j - 1] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.println("\nSorted names are in Ascending Order: ");
        for (int i = 0; i < N; i++) {
            System.out.println(names[i]);
        }
    }
}
