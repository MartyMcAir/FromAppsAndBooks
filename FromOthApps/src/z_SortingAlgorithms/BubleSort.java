/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
public class BubleSort {

    public static void main(String[] args) {

    }

    public static void v2() {
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
        int n, c, d, swap;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of integers to sort");
        n = in.nextInt();
        int array[] = new int[n];
        System.out.println("Enter " + n + " integers");

        for (c = 0; c < n; c++) {
            array[c] = in.nextInt();
        }

        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d + 1]) {
                    swap = array[d];
                    array[d] = array[d + 1];
                    array[d + 1] = swap;
                }
            }
        }

        System.out.println("Sorted list of numbers");
        for (c = 0; c < n; c++) {
            System.out.println(array[c]);
        }
    }

    public static void myV1() {
        int[] arrInt = {19, 6, 18, 8, 13, 0, 3, 9};
        System.out.println(Arrays.toString(arrInt));

        boolean flag = false;
        int current, next;
        while (!flag) {
            flag = true;
            for (int i = 0, j = i + 1; i < arrInt.length - 1; i++, j++) {
                current = arrInt[i];
                next = arrInt[j];
                if (current > next) {
                    flag = false;
                    arrInt[i] = next;
                    arrInt[j] = current;
                }
            }
        }
        System.out.println(Arrays.toString(arrInt));
    }

}
