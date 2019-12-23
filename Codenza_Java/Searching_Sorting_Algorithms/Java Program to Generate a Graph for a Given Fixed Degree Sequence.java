/*This is a java program to generate a graph from given degree sequence. The degree sequence of an undirected graph is the non-increasing sequence of its vertex degrees.The degree sequence problem is the problem of finding some or all graphs with the degree sequence being a given non-increasing sequence of positive integers. A sequence which is the degree sequence of some graph, i.e. for which the degree sequence problem has a solution, is called a graphic or graphical sequence. As a consequence of the degree sum formula, any sequence with an odd sum, such as (3, 3, 1), cannot be realized as the degree sequence of a graph. The converse is also true: if a sequence has an even sum, it is the degree sequence of a multigraph. The construction of such a graph is straightforward: connect vertices with odd degrees in pairs by a matching, and fill out the remaining even degree counts by self-loops.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphUsingDegreeSequence
{
    Integer[][] adjecencyMatrix;
    List<Integer> degreeSequence;

    private void addEdges(Integer v, Integer e)
    {
        for (int i = 0; i < adjecencyMatrix.length && e > 0; i++)
            {
                if (degreeSequence.get(i) != 0)
                    {
                        adjecencyMatrix[v][i] = adjecencyMatrix[i][v] = 1;
                        Integer val = degreeSequence.get(i);
                        if (val > 0)
                            degreeSequence.set(i, val - 1);
                        e--;
                    }
            }
    }

    public void generateGraph()
    {
        adjecencyMatrix = new Integer[degreeSequence.size()][degreeSequence
                .size()];
        for (int i = 0; i < adjecencyMatrix.length; i++)
            {
                for (int j = 0; j < adjecencyMatrix.length; j++)
                    {
                        adjecencyMatrix[i][j] = 0;
                    }
            }
        for (int i = 0; i < degreeSequence.size(); i++)
            {
                Integer e = degreeSequence.get(i);
                degreeSequence.set(i, 0);
                addEdges(i, e);
            }
    }

    public void printGraph()
    {
        System.out.println("The matrix form of graph: ");
        for (int i = 0; i < adjecencyMatrix.length; i++)
            {
                for (int j = 0; j < adjecencyMatrix.length; j++)
                    {
                        System.out.print(adjecencyMatrix[i][j] + " ");
                    }
                System.out.println();
            }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        Integer n = sc.nextInt();
        System.out
        .println("Enter the Degree Sequence: <Degree sequence is always in non-increasing order>");
        GraphUsingDegreeSequence gds = new GraphUsingDegreeSequence();
        gds.degreeSequence = new ArrayList<Integer>();
        while (n > 0)
            {
                gds.degreeSequence.add(sc.nextInt());
                n--;
            }
        System.out.println("Entered degree sequence: "
                           + gds.degreeSequence.toString());
        gds.generateGraph();
        gds.printGraph();
        sc.close();
    }
}

/*
Enter the number of vertices:
7
Enter the Degree Sequence: <Degree sequence is always in non-increasing order>
5 3 3 2 2 1 0
Entered degree sequence: [5, 3, 3, 2, 2, 1, 0]
The matrix form of graph:
0 1 1 1 1 1 0
1 0 1 1 0 0 0
1 1 0 0 1 0 0
1 1 0 0 0 0 0
1 0 1 0 0 0 0
1 0 0 0 0 0 0
0 0 0 0 0 0 0
