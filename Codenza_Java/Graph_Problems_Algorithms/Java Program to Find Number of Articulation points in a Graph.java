/*This Java program is to find number of articulation points in graph. A vertex in an undirected connected graph is an articulation point (or cut vertex) iff removing it (and edges through it) disconnects the graph. Articulation points represent vulnerabilities in a connected network – single points whose failure would split the network into 2 or more disconnected components.*/

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class NumberOfArticulationPoints
{
    private Stack<Integer> stack;
    private int numberOfNodes;
    private Set<Integer> articulationPoints;
    private int[] parent;
    private int[] visited;
    private int[][] adjacencyMatrix;

    public NumberOfArticulationPoints(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
        this.stack = new Stack<Integer>();
        this.articulationPoints = new HashSet<Integer>();
        this.parent = new int[numberOfNodes + 1];
        this.visited = new int[numberOfNodes + 1];
        this.adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];
    }

    public int numberOfArticulationPoint(int adjacencyMatrix[][], int source)
    {
        int children = 0;
        int element, destination;
        stack.push(source);
        visited[source] = 1;
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
                    {
                        this.adjacencyMatrix[sourceVertex][destinationVertex]
                            = adjacencyMatrix[sourceVertex][destinationVertex];
                    }
            }
        while (!stack.isEmpty())
            {
                element = stack.peek();
                destination = element;
                while (destination <= numberOfNodes)
                    {
                        if (this.adjacencyMatrix[element][destination] == 1 && visited[destination] == 0)
                            {
                                stack.push(destination);
                                visited[destination] = 1;
                                parent[destination] = element;
                                if (element == source)
                                    {
                                        children++;
                                    }
                                if (!isLeaf(this.adjacencyMatrix, destination))
                                    {
                                        if (children > 1)
                                            {
                                                articulationPoints.add(source);
                                            }
                                        if (isArticulationPoint(this.adjacencyMatrix, destination))
                                            {
                                                articulationPoints.add(destination);
                                            }
                                    }
                                element = destination;
                                destination = 1;
                                continue;
                            }
                        destination++;
                    }
                stack.pop();
            }
        return articulationPoints.size();
    }

    private boolean isArticulationPoint(int adjacencyMatrix[][], int root)
    {
        int explored[] = new int[numberOfNodes + 1];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        int element = 0, destination = 0;
        while (!stack.isEmpty())
            {
                element = stack.peek();
                destination = 1;
                while (destination <= numberOfNodes)
                    {
                        if ( element != root)
                            {
                                if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 1)
                                    {
                                        if (this.stack.contains(destination))
                                            {
                                                if (destination <= parent[root])
                                                    {
                                                        return false;
                                                    }
                                                return true;
                                            }
                                    }
                            }
                        if ((adjacencyMatrix[element][destination] == 1 && explored[destination] == 0 )
                                && visited[destination] == 0)
                            {
                                stack.push(destination);
                                explored[destination] = 1;
                                adjacencyMatrix[destination][element] = 0;
                                element = destination;
                                destination = 1;
                                continue;
                            }
                        destination++;
                    }
                stack.pop();
            }
        return true;
    }

    private boolean isLeaf(int adjacencyMatrix[][], int node)
    {
        boolean isLeaf = true;
        for (int vertex = 1; vertex <= numberOfNodes; vertex++)
            {
                if (adjacencyMatrix[node][vertex] == 1 && visited[vertex] == 1)
                    {
                        isLeaf = true;
                    }
                else if (adjacencyMatrix[node][vertex] == 1 && visited[vertex] == 0)
                    {
                        isLeaf = false;
                        break;
                    }
            }
        return isLeaf;
    }

    public static void main(String... arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try
            {
                System.out.println("Enter the number of nodes in the graph");
                scanner = new Scanner(System.in);
                number_of_nodes = scanner.nextInt();
                int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
                System.out.println("Enter the adjacency matrix");
                for (int i = 1; i <= number_of_nodes; i++)
                    for (int j = 1; j <= number_of_nodes; j++)
                        adjacency_matrix[i][j] = scanner.nextInt();
                System.out.println("Enter the source for the graph");
                source = scanner.nextInt();
                NumberOfArticulationPoints articulationPoints = new NumberOfArticulationPoints(number_of_nodes);
                int num = articulationPoints.numberOfArticulationPoint(adjacency_matrix, source);
                System.out.println("The number is " + num);
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
5
Enter the adjacency matrix
0 1 1 1 0
1 0 1 0 0
1 1 0 0 1
1 0 0 0 1
0 0 1 1 0
Enter the source for the graph
1
The Given Graph is BiConnected
