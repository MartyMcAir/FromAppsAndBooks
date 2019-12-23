/*This Java program is to find the number of spanning trees in a Complete Bipartite graph. This can be calculated using the matrix tree theorem or Cayley’s formula.*/

import java.util.Scanner;

public class NumOfSpanningBipartite
{
    private int firstSetSize;
    private int secondSetSize;

    public int numberOfSpanningTree(int firstSetSize, int secondSetSize)
    {
        this.firstSetSize = firstSetSize;
        this.secondSetSize = secondSetSize;
        return (this.firstSetSize^(this.secondSetSize - 1)) *(this.secondSetSize ^ (this.firstSetSize -1));
    }

    public static void main(String...arg)
    {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of the bipartite graph (m and n)");
        m = scanner.nextInt();
        n = scanner.nextInt();
        NumOfSpanningBipartite bipartite = new  NumOfSpanningBipartite();
        System.out.println(" the number of spanning trees are  " + bipartite.numberOfSpanningTree(m, n));
        scanner.close();
    }
}

/*
enter the size of the bipartite graph (m and n)
2 2
 the number of spanning trees are  9
