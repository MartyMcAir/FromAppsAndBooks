/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Matrix_Array;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.prodevs.apps.javaprogrammingguide
// Java Programs, Tutorials and Questions
// Sparse - right name _  Matrix
public class SparceMatrix {

    private int[][] data = new int[10][3];
    private int row, col; // size of the matrix 
    private int len; // useful length of data 

    public SparceMatrix(int r, int c) {
        row = r;
        col = c;
    }

    public static void main(String[] argv) { // for unit test 
        SparceMatrix a = new SparceMatrix(3, 5);
        SparceMatrix b = new SparceMatrix(5, 3);
        a.addData(0, 1, 3);
        a.addData(0, 2, 4);
        a.addData(0, 3, 5);
        a.addData(0, 4, 1);
        a.addData(1, 0, 1);
        a.addData(1, 2, 3);
        a.addData(1, 3, 2);
        a.addData(2, 0, 2);
        a.addData(2, 2, 1);
        b.addData(0, 0, 1);
        b.addData(0, 2, 3);
        b.addData(2, 0, 2);
        b.addData(3, 0, 4);
        b.addData(3, 2, 6);
        b.addData(4, 0, 1);
        b.addData(4, 2, 1);
        SparceMatrix rel = a.multiply(b);
        rel.print();
    }

    public void addData(int r, int c, int val) {
        if (len >= data.length) { // double capacity 
            int[][] tmp = new int[data.length * 2][3];
            for (int i = 0; i < len; i++) { // copy original data 
                tmp[i][0] = data[i][0];
                tmp[i][1] = data[i][1];
                tmp[i][2] = data[i][2];
            }
            data = tmp; // data points to new array 
        }
        data[len][0] = r;
        data[len][1] = c;
        data[len++][2] = val;
    }

    public SparceMatrix add(SparceMatrix b) {
        int aPos = 0, bPos = 0;
        SparceMatrix tmp = new SparceMatrix(row, col);
        while (aPos < len && bPos < b.len) { // when none is empty, scan both matrix 
            if (data[aPos][0] > b.data[bPos][0] || (data[aPos][0] == b.data[bPos][0] && data[aPos][1] > b.data[bPos][1])) { // b smaller 
                // copy b to new matrix 
                tmp.addData(b.data[bPos][0], b.data[bPos][1], b.data[bPos][2]);
                bPos++;
            } else if (data[aPos][0] < b.data[bPos][0] || (data[aPos][0] == b.data[bPos][0] && data[aPos][1] < b.data[bPos][1])) { // a smaller 
                // copy a to new matrix 
                tmp.addData(data[aPos][0], data[aPos][1], data[aPos][2]);
                aPos++;
            } else { // data at aPos and bPos are the same row and column 
                int rel = data[aPos][2] + b.data[bPos][2];
                if (rel != 0) {
                    tmp.addData(data[aPos][0], data[aPos][1], rel);
                }
                aPos++;
                bPos++;
            }
        }
        // copy remain data 
        while (aPos < len) {
            tmp.addData(data[aPos][0], data[aPos][1], data[aPos++][2]);
        }
        while (bPos < b.len) {
            tmp.addData(b.data[bPos][0], b.data[bPos][1], b.data[bPos++][2]);
        }
        return tmp;
    }

    public SparceMatrix transpose() {
        SparceMatrix tmp = new SparceMatrix(col, row);
        tmp.data = new int[len][3];
        tmp.len = len;
        tmp.row = col;
        tmp.col = row;
        int[] count = new int[col]; // count[i]: how many data in column i 
        for (int i = 0; i < len; i++) {
            count[data[i][1]]++;
        }
        int[] index = new int[col]; // index[i]: how many data have column smaller than i 
        for (int i = 1; i < col; i++) {
            index[i] = index[i - 1] + count[i - 1];
        }
        for (int i = 0; i < len; i++) {
            int insertPos = index[data[i][1]]++; // a new data inserted, so shift insertion point 
            tmp.data[insertPos][0] = data[i][1]; // transpose 
            tmp.data[insertPos][1] = data[i][0]; // transpose 
            tmp.data[insertPos][2] = data[i][2]; // copy data 
        }
        return tmp;
    }

    public SparceMatrix multiply(SparceMatrix x) {
        SparceMatrix b = x.transpose();
        int aPos, bPos;
        SparceMatrix rel = new SparceMatrix(row, b.row);
        for (aPos = 0; aPos < len;) {
            int r = data[aPos][0]; // current row 
            for (bPos = 0; bPos < b.len;) {
                int c = b.data[bPos][0]; // current column 
                int scanA = aPos;
                int scanB = bPos;
                int sum = 0;
                while (scanA < len && data[scanA][0] == r && scanB < b.len && b.data[scanB][0] == c) { // calculate rel[r][c] 
                    if (data[scanA][1] < b.data[scanB][1]) // scanB has larger column 
                    {
                        scanA++; // skip a 
                    } else if (data[scanA][1] > b.data[scanB][1]) // scanA has larger column 
                    {
                        scanB++; // skip b 
                    } else // same column, so they can multiply 
                    {
                        sum += data[scanA++][2] * b.data[scanB++][2];
                    }
                }
                if (sum != 0) {
                    rel.addData(r, c, sum);
                }
                while (bPos < b.len && b.data[bPos][0] == c) {
                    bPos++; // jump to next column 
                }
            }
            while (aPos < len && data[aPos][0] == r) {
                aPos++; // jump to next row 
            }
        }
        return rel;
    }

    public void print() {
        System.out.println("row = " + row + ", column = " + col);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i][0]);
            System.out.print(" ");
            System.out.print(data[i][1]);
            System.out.print(" ");
            System.out.print(data[i][2]);
            System.out.println();
        }
    }
}
