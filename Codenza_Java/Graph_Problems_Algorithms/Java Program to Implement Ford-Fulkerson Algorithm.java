/*This Java program is to Implement Ford-Fulkerson algorithm. The Ford–Fulkerson method (named for L. R. Ford, Jr. and D. R. Fulkerson) is an algorithm which computes the maximum flow in a flow network.
The idea behind the algorithm is simple. As long as there is a path from the source (start node) to the sink (end node), with available capacity on all edges in the path, we send flow along one of these paths. Then we find another path, and so on. A path with available capacity is called an augmenting path.*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FordFulkerson
{
    private int[] parent;
    private Queue<Integer> queue;
    private int numberOfVertices;
    private boolean[] visited;

    public FordFulkerson(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        this.queue = new LinkedList<Integer>();
        parent = new int[numberOfVertices + 1];
        visited = new boolean[numberOfVertices + 1];
    }

    public boolean bfs(int source, int goal, int graph[][])
    {
        boolean pathFound = false;
        int destination, element;
        for(int vertex = 1; vertex <= numberOfVertices; vertex++)
            {
                parent[vertex] = -1;
                visited[vertex] = false;
            }
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;
        while (!queue.isEmpty())
            {
                element = queue.remove();
                destination = 1;
                while (destination <= numberOfVertices)
                    {
                        if (graph[element][destination] > 0 &&  !visited[destination])
                            {
                                parent[destination] = element;
                                queue.add(destination);
                                visited[destination] = true;
                            }
                        destination++;
                    }
            }
        if(visited[goal])
            {
                pathFound = true;
            }
        return pathFound;
    }

    public int fordFulkerson(int graph[][], int source, int destination)
    {
        int u, v;
        int maxFlow = 0;
        int pathFlow;
        int[][] residualGraph = new int[numberOfVertices + 1][numberOfVertices + 1];
        for (int sourceVertex = 1; sourceVertex <= numberOfVertices; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberOfVertices; destinationVertex++)
                    {
                        residualGraph[sourceVertex][destinationVertex] = graph[sourceVertex][destinationVertex];
                    }
            }
        while (bfs(source,destination, residualGraph))
            {
                pathFlow = Integer.MAX_VALUE;
                for (v = destination; v != source; v = parent[v])
                    {
                        u = parent[v];
                        pathFlow = Math.min(pathFlow, residualGraph[u][v]);
                    }
                for (v = destination; v != source; v = parent[v])
                    {
                        u = parent[v];
                        residualGraph[u][v] -= pathFlow;
                        residualGraph[v][u] += pathFlow;
                    }
                maxFlow += pathFlow;
            }
        return maxFlow;
    }

    public static void main(String...arg)
    {
        int[][] graph;
        int numberOfNodes;
        int source;
        int sink;
        int maxFlow;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        numberOfNodes = scanner.nextInt();
        graph = new int[numberOfNodes + 1][numberOfNodes + 1];
        System.out.println("Enter the graph matrix");
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
                    {
                        graph[sourceVertex][destinationVertex] = scanner.nextInt();
                    }
            }
        System.out.println("Enter the source of the graph");
        source= scanner.nextInt();
        System.out.println("Enter the sink of the graph");
        sink = scanner.nextInt();
        FordFulkerson fordFulkerson = new FordFulkerson(numberOfNodes);
        maxFlow = fordFulkerson.fordFulkerson(graph, source, sink);
        System.out.println("The Max Flow is " + maxFlow);
        scanner.close();
    }
}

/*

Enter the number of nodes
6
Enter the graph matrix
0 16 13 0 0 0
0 0  10 12 0 0
0 4 0 0 14 0
0 0 9 0 0 20
0 0 0 7 0 4
0 0 0 0 0 0
Enter the source of the graph
1
Enter the sink of the graph
6
The Max Flow is 23
