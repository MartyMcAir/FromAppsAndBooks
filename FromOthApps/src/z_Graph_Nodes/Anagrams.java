/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author MartyMcAir
 */
public class Anagrams {

    public static void main(String args[]) throws Exception {
        Anagrams a = new Anagrams();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter first string: ");
        String str1 = br.readLine();

        System.out.print("Enter second string: ");
        String str2 = br.readLine();

        int flag = a.anagram(str1, str2);

        if (flag == 0) {
            System.out.print("Result: " + str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.print("Result: " + str1 + " and " + str2 + " are not anagrams.");
        }

        System.out.println();
    }

    public int anagram(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }
        return 1;
    }
}
