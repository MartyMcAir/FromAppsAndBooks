/*This Java program is Implement Euler Circuit Problem.In graph theory, an Eulerian trail (or Eulerian path) is a trail in a graph which visits every edge exactly once. Similarly, an Eulerian circuit or Eulerian cycle is an Eulerian trail which starts and ends on the same vertex.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class EulerCircuit
{

    private int[][] adjacencyMatrix;
    private int numberOfNodes;

    public EulerCircuit (int numberOfNodes, int[][] adjacencyMatrix)
    {
        this.numberOfNodes = numberOfNodes;
        this.adjacencyMatrix = new int[numberOfNodes + 1] [numberOfNodes + 1];
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
                    {
                        this.adjacencyMatrix[sourceVertex][destinationVertex]
                            = adjacencyMatrix[sourceVertex] [destinationVertex];
                    }
            }
    }

    public int degree (int vertex)
    {
        int degree = 0;
        for (int destinationvertex = 1; destinationvertex <= numberOfNodes ; destinationvertex++)
            {
                if (adjacencyMatrix[vertex][destinationvertex] == 1
                        || adjacencyMatrix[destinationvertex][vertex] == 1)
                    {
                        degree++;
                    }
            }
        return degree;
    }

    public int oddDegreeVertex ()
    {
        int vertex = -1;
        for (int node = 1; node <= numberOfNodes; node++)
            {
                if ((degree(node) % 2) != 0)
                    {
                        vertex = node;
                        break;
                    }
            }
        return vertex;
    }

    public void printEulerTourUtil (int vertex)
    {
        for (int destination = 1; destination <= numberOfNodes; destination++)
            {
                if(adjacencyMatrix[vertex][destination] == 1 && isVaildNextEdge(vertex, destination))
                    {
                        System.out.println(" source : " + vertex + " destination " + destination);
                        removeEdge(vertex, destination);
                        printEulerTourUtil(destination);
                    }
            }
    }

    public void printEulerTour ()
    {
        int vertex = 1;
        if (oddDegreeVertex() != -1)
            {
                vertex = oddDegreeVertex();
            }
        printEulerTourUtil(vertex);
        return;
    }

    public boolean isVaildNextEdge (int source, int destination)
    {
        int count = 0;
        for (int vertex = 1; vertex <= numberOfNodes; vertex++)
            {
                if (adjacencyMatrix[source][vertex] == 1)
                    {
                        count++;
                    }
            }
        if (count == 1 )
            {
                return true;
            }
        int visited[] = new int[numberOfNodes + 1];
        int count1 = DFSCount(source, visited);
        removeEdge(source, destination);
        for (int vertex = 1; vertex <= numberOfNodes; vertex++)
            {
                visited[vertex] = 0;
            }
        int count2 = DFSCount(source, visited);
        addEdge(source, destination);
        return (count1 > count2 ) ? false : true;
    }

    public int DFSCount (int source, int visited[])
    {
        visited[source] = 1;
        int count = 1;
        int destination = 1;
        while (destination <= numberOfNodes)
            {
                if(adjacencyMatrix[source][destination] == 1 && visited[destination] == 0)
                    {
                        count += DFSCount(destination, visited);
                    }
                destination++;
            }
        return count;
    }

    public void removeEdge (int source, int destination)
    {
        adjacencyMatrix[source][destination]  = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public void addEdge (int source, int destination)
    {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public static void main (String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
            {
                // read the number of nodes
                System.out.println("Enter the number of nodes in the graph");
                scanner = new Scanner(System.in);
                number_of_nodes = scanner.nextInt();
                // read the adjacency matrix
                int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
                System.out.println("Enter the adjacency matrix");
                for (int i = 1; i <= number_of_nodes; i++)
                    {
                        for (int j = 1; j <= number_of_nodes; j++)
                            {
                                adjacency_matrix[i][j] = scanner.nextInt();
                            }
                    }
                //make the graph undirected
                for (int i = 1; i <= number_of_nodes; i++)
                    {
                        for (int j = 1; j <= number_of_nodes; j++)
                            {
                                if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                                    {
                                        adjacency_matrix[j][i] = 1;
                                    }
                            }
                    }
                System.out.println("the euler path or euler circuit is ");
                // print euler path or circuit
                EulerCircuit circuit = new EulerCircuit(number_of_nodes, adjacency_matrix);
                circuit.printEulerTour();
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input format");
            }
        scanner.close();
    }
}

/*
Enter the number of nodes in the graph
4
Enter the adjacency matrix
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
the euler path or euler circuit is
 source : 1 destination 2
 source : 2 destination 3
 source : 3 destination 4
 source : 4 destination 1
