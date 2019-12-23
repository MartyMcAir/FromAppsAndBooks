import java.util.Scanner;
import java.util.Vector;

class Node
{
    int             name; // node ID, started from 0 to n-1
    Vector<Integer> preds; // predecessors (String)
    Vector<Integer> neibs; // neighbors (String)
    Vector<Integer> backs; // backward edges -node is end vertex (Integer)
    Vector<Integer> fors; // forward edges -node is start vertex (Integer)
    int             pNode; // previous node on the augmenting path
    int             pEdge; // from which edge this node comes on the augmenting
    // path

    public Node(int id)
    {
        name = id;
        backs = new Vector<Integer>();
        fors = new Vector<Integer>();
        pNode = -1;
        pEdge = -1;
    }
}

class Edge
{
    int name;    // edge ID, started from 0 to n-1
    int start;   // start vertex of this edge
    int end;     // end vertex of this edge
    int direct;  // forwards (+1) or backwards (-1) on augmenting path
    // if 0 then not part of augmenting path
    int capacity; // capacity
    int flow;    // current flow

    public Edge(int id)
    {
        name = id;
        start = -1;
        end = -1;
        direct = 0; // default is neither
        capacity = 0;
        flow = 0;
    }

    public String toString()
    {
        return name + ": s=" + start + " e=" + end + " d=" + direct;
    }
}

public class LongestPathinDAG
{
    int    n;                      // number of nodes
    int    target;                 // destination node
    int    minLength;              // the minimal length of each path
    Node[] v;                      // used to store Nodes
    Edge[] e;                      // used to store Edges
    int[]  path;                   // used to store temporary path
    int    length       = 0;       // length of the path
    int    distance     = 0;       // distance of the path
    int[]  bestPath;               // used to store temporary path
    int    bestLength   = 0;       // length of the longest path
    int    bestDistance = -1000000; // distance of the longest path
    int[]  visited;                // used to mark a node as visited if set as
    // 1

    public LongestPathinDAG()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
        v = new Node[n];
        e = new Edge[m];
        System.out.println(n + " nodes and " + m + " edges.");
        for (int i = 0; i < n; i++)
            v[i] = new Node(i);
        int i = 0;
        while (i < e.length)
            {
                Edge edge = new Edge(i);
                int sVal = sc.nextInt();
                edge.start = sVal;// sc.nextInt();
                int eVal = sc.nextInt();
                edge.end = eVal;// sc.nextInt();
                edge.capacity = sc.nextInt();
                System.out.println(" edge: " + edge.start + " - " + edge.end
                                   + " : " + edge.capacity);
                edge.flow = 0;
                e[i] = edge;
                v[sVal].fors.add(i);
                v[eVal].backs.add(i);
                i++;
                if (i == m)
                    break;
            }
        visited = new int[v.length];
        path = new int[v.length];
        bestPath = new int[v.length];
        sc.close();
    }

    /*
     * this function looks for a longest path starting from being to end,
     * using the backtrack depth-first search.
     */
    public boolean findLongestPath(int begin, int end, int minLen)
    {
        /*
         * compute a longest path from begin to end
         */
        target = end;
        bestDistance = -100000000;
        minLength = minLen;
        dfsLongestPath(begin);
        if (bestDistance == -100000000)
            return false;
        else
            return true;
    }

    private void dfsLongestPath(int current)
    {
        visited[current] = 1;
        path[length++] = current;
        if (current == target && length >= minLength)
            {
                if (distance > bestDistance)
                    {
                        for (int i = 0; i < length; i++)
                            bestPath[i] = path[i];
                        bestLength = length;
                        bestDistance = distance;
                    }
            }
        else
            {
                Vector<Integer> fors = v[current].fors;
                for (int i = 0; i < fors.size(); i++)
                    {
                        Integer edge_obj = (Integer) fors.elementAt(i);
                        int edge = edge_obj.intValue();
                        if (visited[e[edge].end] == 0)
                            {
                                distance += e[edge].capacity;
                                dfsLongestPath(e[edge].end);
                                distance -= e[edge].capacity;
                            }
                    }
            }
        visited[current] = 0;
        length--;
    }

    public String toString()
    {
        String output = "v" + bestPath[0];
        for (int i = 1; i < bestLength; i++)
            output = output + " -> v" + bestPath[i];
        return output;
    }

    public static void main(String arg[])
    {
        LongestPathinDAG lp = new LongestPathinDAG();
        /*
         * find a longest path from vertex 0 to vertex n-1.
         */
        if (lp.findLongestPath(0, lp.n - 1, 1))
            System.out.println("Longest Path is " + lp
                               + " and the distance is " + lp.bestDistance);
        else
            System.out.println("No path from v0 to v" + (lp.n - 1));
        /*
         * find a longest path from vertex 3 to vertex 5.
         */
        if (lp.findLongestPath(3, 5, 1))
            System.out.println("Longest Path is " + lp
                               + " and the distance is " + lp.bestDistance);
        else
            System.out.println("No path from v3 to v5");
        /*
         * find a longest path from vertex 5 to vertex 3.
         */
        if (lp.findLongestPath(lp.n - 1, 3, 1))
            System.out.println("Longest Path is " + lp
                               + " and the distance is " + lp.bestDistance);
        else
            System.out.println("No path from v5 to v3");
    }
}

/*
Enter the number of vertices:
6
Enter the number of edges:
7
6 nodes and 7 edges.

0 1 2
 edge: 0 - 1 : 2
1 2 3
 edge: 1 - 2 : 3
1 3 4
 edge: 1 - 3 : 4
3 4 5
 edge: 3 - 4 : 5
4 5 6
 edge: 4 - 5 : 6
5 3 7
 edge: 5 - 3 : 7
5 2 8
 edge: 5 - 2 : 8
Longest Path is v0 -> v1 -> v3 -> v4 -> v5 and the distance is 17
Longest Path is v3 -> v4 -> v5 and the distance is 11
Longest Path is v5 -> v3 and the distance is 7
