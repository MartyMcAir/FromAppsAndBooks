/*This Java program,implements Adjacency list.In graph theory and computer science, an adjacency list representation of a graph is a collection of unordered lists, one for each vertex in the graph. Each list describes the set of neighbors of its vertex.*/

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdjacencyList
{
    private  Map<Integer,List<Integer>> Adjacency_List;

    public AdjacencyList(int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= number_of_vertices;  i++)
            {
                Adjacency_List.put(i, new LinkedList<Integer>());
            }
    }

    public void setEdge(int source, int destination)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
            {
                System.out.println("the vertex entered in not present ");
                return;
            }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
    }

    public List<Integer> getEdge(int source)
    {
        if (source > Adjacency_List.size())
            {
                System.out.println("the vertex entered is not present");
                return null;
            }
        return Adjacency_List.get(source);
    }

    public static void main(String...arg)
    {
        int source, destination;
        int number_of_edges, number_of_vertices;
        int count = 1;
        Scanner scan = new Scanner(System.in);
        try
            {
                System.out.println("Enter the number of vertices and edges in graph");
                number_of_vertices = scan.nextInt();
                number_of_edges = scan.nextInt();
                AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices);
                System.out.println("Enter the edges in graph Format : <source index> <destination index>");
                while (count <= number_of_edges)
                    {
                        source = scan.nextInt();
                        destination = scan.nextInt();
                        adjacencyList.setEdge(source, destination);
                        count++;
                    }
                System.out.println("the given Adjacency List for the graph \n");
                for (int i = 1; i <= number_of_vertices; i++)
                    {
                        System.out.print(i+"->");
                        List<Integer> edgeList = adjacencyList.getEdge(i);
                        for (int j = 1; ; j++ )
                            {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1 ) + "->");
                                else
                                    {
                                        System.out.print(edgeList.get(j - 1 ));
                                        break;
                                    }
                            }
                        System.out.println();
                    }
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
            }
        scan.close();
    }
}

/*
Enter the number of vertices and edges in graph
4 5
Enter the edges in graph Format : <source index> <destination index>
1 2
2 3
3 4
4 1
1 3
the given Adjacency List for the graph

1->2->4->3
2->1->3
3->2->4->1
4->3->1
