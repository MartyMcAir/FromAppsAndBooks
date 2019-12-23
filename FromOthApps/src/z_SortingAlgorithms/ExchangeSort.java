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
public class ExchangeSort {

    public static void main(String[] args) {
        int[] array;
        int i, j, temp, size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        size = sc.nextInt();
        array = new int[size];

        System.out.println("Enter the elements of array : ");
        for (i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        for (i = 0; i < (size - 1); i++) {
            for (j = (i + 1); j < size; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Sorted Array is : ");
        for (i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
