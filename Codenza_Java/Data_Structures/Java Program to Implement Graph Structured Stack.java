/*This Java program is to implement graph structured stack. In computer science, a graph-structured stack is a directed acyclic graph where each directed path represents a stack. The graph-structured stack is an essential part of Tomita’s algorithm, where it replaces the usual stack of a pushdown automaton. This allows the algorithm to encode the nondeterministic choices in parsing an ambiguous grammar, sometimes with greater efficiency.*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class GraphStructuredStack
{
    private ArrayList<Stack<Integer>> stackList;
    private Stack<Integer> stack;
    private int numberOfNodes;
    private int adjacencyMatrix[][];
    private int[] parent;

    public GraphStructuredStack()
    {
        stackList = new ArrayList<Stack<Integer>>();
        stack  = new Stack<Integer>();
    }

    public void graphStructuredStack(int adjacencyMatrix[][],int source,int bottomNode)
    {
        boolean stackFound = false;
        this.numberOfNodes = adjacencyMatrix[source].length - 1;
        this.adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes +1];
        this.parent = new int[numberOfNodes+ 1];
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
                    {
                        this.adjacencyMatrix[sourceVertex][destinationVertex]
                            = adjacencyMatrix[sourceVertex][destinationVertex];
                    }
            }
        stack.push(source);
        int element, destination;
        while (!stack.isEmpty())
            {
                element = stack.peek();
                destination = 1;
                while (destination <= numberOfNodes)
                    {
                        if (this.adjacencyMatrix[element][destination] == 1)
                            {
                                stack.push(destination);
                                parent[destination] = element;
                                this.adjacencyMatrix[element][destination] = 0;
                                if (destination == bottomNode)
                                    {
                                        stackFound = true;
                                        break;
                                    }
                                element = destination;
                                destination = 1;
                                continue;
                            }
                        destination++;
                    }
                if (stackFound)
                    {
                        Stack<Integer> istack = new Stack<Integer>();
                        for (int node = bottomNode; node != source; node = parent[node])
                            {
                                istack.push(node);
                            }
                        istack.push(source);
                        stackList.add(istack);
                        stackFound = false;
                    }
                stack.pop();
            }
        Iterator<Stack<Integer>> iterator = stackList.iterator();
        while (iterator.hasNext())
            {
                Stack<Integer> stack = iterator.next();
                Iterator<Integer> stckitr = stack.iterator();
                while (stckitr.hasNext())
                    {
                        System.out.print(stckitr.next() +"\t");
                    }
                System.out.println();
            }
    }

    public static void main(String...arg)
    {
        int adjacencyMatrix[][];
        int numberofnodes;
        int source, bottom;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of nodes");
        numberofnodes = scanner.nextInt();
        adjacencyMatrix = new int[numberofnodes + 1] [numberofnodes + 1];
        System.out.println("enter the graph matrix");
        for (int sourceVertex = 1; sourceVertex <= numberofnodes; sourceVertex++)
            {
                for (int destinationVertex = 1; destinationVertex <= numberofnodes; destinationVertex++)
                    {
                        adjacencyMatrix[sourceVertex][destinationVertex] = scanner.nextInt();
                    }
            }
        System.out.println("enter the source node");
        source = scanner.nextInt();
        System.out.println("enter the bottom node");
        bottom = scanner.nextInt();
        System.out.println("the stacks are");
        GraphStructuredStack graphStructuredStack = new GraphStructuredStack();
        graphStructuredStack.graphStructuredStack(adjacencyMatrix, source, bottom);
        scanner.close();
    }
}


/*
enter the number of nodes
6
enter the graph matrix
0 0 0 0 0 0
1 0 0 0 0 0
1 0 0 0 0 0
0 1 1 0 0 0
0 0 0 1 0 0
0 0 0 0 1 0
enter the source node
6
enter the bottom node
1
the stacks are
1	2	4	5	6
1	3	4	5	6
