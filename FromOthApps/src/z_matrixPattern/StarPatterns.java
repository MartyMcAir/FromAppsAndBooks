/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_matrixPattern;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class StarPatterns {

    public static void main(String args[]) {

    }

    private static void starPattern1() {
//        *
//       * *
//      * * *
//     * * * *
//    * * * * *
        int space = 4;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
            space--;
        }
    }

    private static void starPattern2() {
//    * * * * *
//     * * * *
//      * * *
//       * *
//        *    
        int space = 0;
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
            space++;
        }
    }

    private static void starPattern3() {
//    *        *
//    **      **
//    ***    ***
//    ****  ****
//    **********
        int space = 8;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
            space = space - 2;
        }
    }

    private static void starPattern4() {
//    **********
//    ****  ****
//    ***    ***
//    **      **
//    *        *
        int space = 0;
        for (int i = 5; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            System.out.println();
            space = space + 2;
        }
    }

    private static void starPattern5() {
        //    **********
//    ****  ****
//    ***    ***
//    **      **
//    *        *
//    *        *
//    **      **
//    ***    ***
//    ****  ****
//    **********
        int space = 0;
        for (int i = 5; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            System.out.println();
            space = space + 2;
        }

        space = 8;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
            space = space - 2;
        }
    }

}
