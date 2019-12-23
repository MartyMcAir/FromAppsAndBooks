/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_SortingAlgorithms;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class InsertionSort {

    static int step = 1;

    public static void main(String[] args) {
        int[] input = {7, 21, 91, 43, 23, 17, 34, 9, 1};
        insertionSort(input);
    }

    private static void printNumbers(int[] input) {
        System.out.println("Step " + step);
        System.out.println("-----------------------------");
        step++;

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }

        System.out.println("\n");
    }

    public static void insertionSort(int array[]) {
        int n = array.length;

        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;

            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
            printNumbers(array);
        }
    }
}
