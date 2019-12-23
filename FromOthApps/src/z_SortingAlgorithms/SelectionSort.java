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
public class SelectionSort {

    public static void main(String args[]) {
        int[] arrInt = {19, 6, 18, 8, 13, 0, 3, 9};
        System.out.println(Arrays.toString(arrInt));

    }

    public static int[] doSelectionSort(int[] arr) {
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
        // example for use
//        int[] arr1 = {102, 34, 2, 56, 76, 5, 88, 42};
//        int[] arr2 = doSelectionSort(arr1);
//
//        for (int i : arr2) {
//            System.out.print(i);
//            System.out.print(", ");
//        }
    }

    public static void v1() {
// https://play.google.com/store/apps/details?id=com.prodevs.apps.javaprogrammingguide
// 	Java Programs, Tutorials and Questions
        int n, ele;
        System.out.println("Enter the no. " + "of elements:");
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the" + " " + (i + 1) + "th element:");
            arr[i] = scn.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp;
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

}
