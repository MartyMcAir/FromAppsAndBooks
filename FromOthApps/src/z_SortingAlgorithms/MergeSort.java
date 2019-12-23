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
public class MergeSort {

    private int[] array;
    private int[] tempMergArr;
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
        MergeSort mms = new MergeSort();
        mms.sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex
                    + (higherIndex - lowerIndex) / 2;
            // Sort the left side of the array 
            doMergeSort(lowerIndex,
                    middle);
            // Sort the right side of the array 
            doMergeSort(middle + 1,
                    higherIndex);
            // Now merge both sides 
            mergeParts(lowerIndex,
                    middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
