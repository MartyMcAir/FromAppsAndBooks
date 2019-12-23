/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Matrix_Array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class SmallestElementInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Element> minHeap = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Element(matrix[0][i], 0, i));
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            Element ele = minHeap.poll();
            res = ele.number;
            if (ele.row + 1 < n) {
                minHeap.offer(new Element(matrix[ele.row + 1][ele.col], ele.row + 1, ele.col));
            }
        }
        return res;
    }

    class Element implements Comparable<Element> {

        int number;
        int row;
        int col;

        public Element(int number, int row, int col) {
            this.number = number;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.number, o.number);
        }
    }
}
