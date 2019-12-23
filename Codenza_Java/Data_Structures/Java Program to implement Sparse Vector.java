/**
 ** Java Program to implement Sparse Vector
 **/

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/** Class SparseVector **/
class SparseVector
{
    /* Tree map is used to maintain sorted order */
    private TreeMap<Integer, Double> st;
    private int N;

    /** Constructor **/
    public SparseVector(int N)
    {
        this.N = N;
        st = new TreeMap<Integer, Double>();
    }

    /** Function to insert a (key, value) pair **/
    public void put(int i, double value)
    {
        if (i < 0 || i >= N)
            throw new RuntimeException("\nError : Out of Bounds\n");
        if (value == 0.0)
            st.remove(i);
        else
            st.put(i, value);
    }

    /** Function to get value for a key **/
    public double get(int i)
    {
        if (i < 0 || i >= N)
            {
                throw new RuntimeException("\nError : Out of Bounds\n");
            }
        if (st.containsKey(i))
            return st.get(i);
        else
            return 0.0;
    }

    /** Function to get size of the vector **/
    public int size()
    {
        return N;
    }

    /** Function to get dot product of two vectors **/
    public double dot(SparseVector b)
    {
        SparseVector a = this;
        if (a.N != b.N)
            throw new RuntimeException("Error : Vector lengths are not same");
        double sum = 0.0;
        if (a.st.size() <= b.st.size())
            {
                for (Map.Entry<Integer, Double> entry : a.st.entrySet())
                    if (b.st.containsKey(entry.getKey()))
                        sum += a.get(entry.getKey()) * b.get(entry.getKey());
            }
        else
            {
                for (Map.Entry<Integer, Double> entry : b.st.entrySet())
                    if (a.st.containsKey(entry.getKey()))
                        sum += a.get(entry.getKey()) * b.get(entry.getKey());
            }
        return sum;
    }

    /** Function to get sum of two vectors **/
    public SparseVector plus(SparseVector b)
    {
        SparseVector a = this;
        if (a.N != b.N)
            throw new RuntimeException("Error : Vector lengths are not same");
        SparseVector c = new SparseVector(N);
        for (Map.Entry<Integer, Double> entry : a.st.entrySet())
            c.put(entry.getKey(), a.get(entry.getKey()));
        for (Map.Entry<Integer, Double> entry : b.st.entrySet())
            c.put(entry.getKey(), b.get(entry.getKey()) + c.get(entry.getKey()));
        return c;
    }

    /** Function toString() for printing vector **/
    public String toString()
    {
        String s = "";
        for (Map.Entry<Integer, Double> entry : st.entrySet())
            s += "(" + entry.getKey() + ", " + st.get(entry.getKey()) + ") ";
        return s;
    }
}

/** Class SparseVector **/
public class SparseVectorTest
{
    public static void main(String[] args)
    {
        System.out.println("Sparse Vector Test\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of sparse vectors");
        int n = scan.nextInt();
        SparseVector v1 = new SparseVector(n);
        SparseVector v2 = new SparseVector(n);
        System.out.println("\nEnter number of entries for vector 1");
        int n1 = scan.nextInt();
        System.out.println("Enter "+ n1 +" (int, double) pairs");
        for (int i = 0; i < n1; i++)
            v1.put(scan.nextInt(), scan.nextDouble() );
        System.out.println("\nEnter number of entries for vector 2");
        int n2 = scan.nextInt();
        System.out.println("Enter "+ n2 +" (int, double) pairs");
        for (int i = 0; i < n2; i++)
            v2.put(scan.nextInt(), scan.nextDouble() );
        System.out.println("\n");
        System.out.println("Vector v1 = " + v1);
        System.out.println("Vector v2 = " + v2);
        System.out.println("\nv1 dot v2 = " + v1.dot(v2));
        System.out.println("v1  +  v2   = " + v1.plus(v2));
    }
}

/*

Enter size of sparse vectors
70000

Enter number of entries for vector 1
4
Enter 4 (int, double) pairs
3 1.0
2500 6.3
5000 10.0
60000 5.7

Enter number of entries for vector 2
3
Enter 3 (int, double) pairs
1 7.5
3 5.7
2500 -6.3


Vector v1 = (3, 1.0) (2500, 6.3) (5000, 10.0) (60000, 5.7)
Vector v2 = (1, 7.5) (3, 5.7) (2500, -6.3)

v1 dot v2 = -33.989999999999995
v1  +  v2   = (1, 7.5) (3, 6.7) (5000, 10.0) (60000, 5.7)
