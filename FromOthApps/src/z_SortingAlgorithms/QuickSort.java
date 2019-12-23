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
// https://play.google.com/store/apps/details?id=com.prodevs.apps.javaprogrammingguide
// Java Programs, Tutorials and Questions
public class QuickSort {

    private int array[];
    private int length;

    public static void main(String a[]) {
        int n;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the no."
                + " of elements:");
        n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter "
                    + "the" + (i + 1) + "th element:");
            arr[i] = scn.nextInt();
        }
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, 
        // here pivot is middle index number 
        int pivot = array[lowerIndex
                + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays 
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next 
                // position on both sides 
                i++;
                j--;
            }
        }
        // call quickSort() method 
        //by recursion 
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
