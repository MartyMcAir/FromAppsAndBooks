/*This Java program,to describe the representation of graph using incident list. Vertices and edges are stored as records or objects. Each vertex stores its incident edges, and each edge stores its incident vertices. This data structure allows the storage of additional data on vertices and edges.*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IncidentList
{
    private Map<Integer, List<Integer>> incidentList;
    private int numberOfVertices;

    public IncidentList(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        incidentList = new HashMap<Integer, List<Integer>>();
        for (int vertex = 1; vertex <= numberOfVertices; vertex++)
            incidentList.put(vertex, new LinkedList<Integer>());
    }

    public void setEdge(int sourcevertex, int destinationvertex, int edgeNumber)
    {
        List<Integer> slist = incidentList.get(sourcevertex);
        slist.add(edgeNumber);
        return;
    }

    public List<Integer> getEdge(int vertex)
    {
        return incidentList.get(vertex);
    }

    public void printIncidentList()
    {
        System.out.println("Vertex   EdgeNumber");
        for (int vertex = 1; vertex <= numberOfVertices; vertex++)
            {
                System.out.print(vertex + ":");
                List<Integer> edgeList = getEdge(vertex);
                for (int j = 1; ; j++)
                    {
                        if (j != edgeList.size())
                            System.out.print(edgeList.get(j - 1) + "\t");
                        else
                            {
                                System.out.print(edgeList.get(j - 1));
                                break;
                            }
                    }
                System.out.println();
            }
    }

    public static void main(String... arg)
    {
        int numberOfVertices, numberOfEdges;
        int source, destination, edgeNumber;
        int edgeCount = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        numberOfVertices = scanner.nextInt();
        IncidentList incidentList = new IncidentList(numberOfVertices);
        System.out.println("Enter the number of edges");
        numberOfEdges = scanner.nextInt();
        System.out.println("Enter the edges format : <edgeNumber> <source> <destination>");
        while (edgeCount <= numberOfEdges)
            {
                edgeNumber = scanner.nextInt();
                source = scanner.nextInt();
                destination = scanner.nextInt();
                incidentList.setEdge(source, destination, edgeNumber);
                edgeCount++;
            }
        System.out.println("\nThe Incident List is ");
        incidentList.printIncidentList();
        scanner.close();
    }
}

/*
Enter the number of vertices
5
Enter the number of edges
5
Enter the edges format : <edgeNumber> <source> <destination>
1 1 2
2 2 4
3 5 4
4 4 3
5 5 1

The Incident List is
Vertex   EdgeNumber
  1    : 1 5
  2    : 1 2
  3    : 4
  4    : 2 3 4
  5    : 3 5
