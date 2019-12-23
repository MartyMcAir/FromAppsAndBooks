/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author MartyMcAir
 */
// With err
public class Anagram2 {

    static int size;
    static int count;
    static char[] arr = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");
        String input = getString();
        size = input.length();
        count = 0;
        for (int j = 0; j < size; j++) {
            arr[j] = input.charAt(j);
        }
        doAnagram(size);
    }

    public static void doAnagram(int nSize) {
        if (nSize == 1) {
            return;
        }
        for (int j = 0; j < nSize; j++) {
            doAnagram(nSize - 1);
            if (nSize == 2) {
                displayWord();
            }
            rotate(nSize);
        }
    }

    public static void rotate(int nSize) {
        int j;
        int position = size - nSize;
        char temp = arr[position];
        for (j = position + 1; j < size; j++) {
            arr[j - 1] = arr[j];
        }
        arr[j - 1] = temp;
    }

    public static void displayWord() {
        if (count < 99) {
            System.out.print("");
        }
        if (count > 9) {
            System.out.print("");
        }
        System.out.print(++count);
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j]);
        }
        System.out.print("");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        String s = reader.readLine();
        return s;
    }
}
