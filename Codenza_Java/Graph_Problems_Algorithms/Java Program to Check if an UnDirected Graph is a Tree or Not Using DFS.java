/*This is a java program to check if graph is tree or not. Graph is tree if,
1. It has number of edges one less than number of vertices.
2. Graph is connected.
3. There are no cycles.*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TGraph
{
    static final int MAXV      = 100;
    static final int MAXDEGREE = 50;
    public int       edges[][] = new int[MAXV + 1][MAXDEGREE];
    public int       degree[]  = new int[MAXV + 1];
    public int       nvertices;
    public int       nedges;

    TGraph()
    {
        nvertices = nedges = 0;
        for (int i = 1; i <= MAXV; i++)
            degree[i] = 0;
    }

    void read_CCGraph(boolean directed)
    {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        nvertices = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
        System.out.println("Enter the edges: <from> <to>");
        for (int i = 1; i <= m; i++)
            {
                x = sc.nextInt();
                y = sc.nextInt();
                insert_edge(x, y, directed);
            }
        sc.close();
    }

    void insert_edge(int x, int y, boolean directed)
    {
        if (degree[x] > MAXDEGREE)
            System.out.printf(
                "Warning: insertion (%d, %d) exceeds max degree\n", x, y);
        edges[x][degree[x]] = y;
        degree[x]++;
        if (!directed)
            insert_edge(y, x, true);
        else
            nedges++;
    }

    void print_CCGraph()
    {
        for (int i = 1; i <= nvertices; i++)
            {
                System.out.printf("%d: ", i);
                for (int j = degree[i] - 1; j >= 0; j--)
                    System.out.printf(" %d", edges[i][j]);
                System.out.printf("\n");
            }
    }
}

public class CheckUndirectedGraphisTree
{
    static final int MAXV         = 100;
    static boolean   processed[]  = new boolean[MAXV];
    static boolean   discovered[] = new boolean[MAXV];
    static int       parent[]     = new int[MAXV];

    static void bfs(TGraph g, int start)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        int i, v;
        q.offer(start);
        discovered[start] = true;
        while (!q.isEmpty())
            {
                v = q.remove();
                // process_vertex(v);
                processed[v] = true;
                for (i = g.degree[v] - 1; i >= 0; i--)
                    {
                        if (!discovered[g.edges[v][i]])
                            {
                                q.offer(g.edges[v][i]);
                                discovered[g.edges[v][i]] = true;
                                parent[g.edges[v][i]] = v;
                            }
                    }
            }
    }

    static void initialize_search(TGraph g)
    {
        for (int i = 1; i <= g.nvertices; i++)
            {
                processed[i] = discovered[i] = false;
                parent[i] = -1;
            }
    }

    static void process_vertex(int v)
    {
        System.out.printf(" %d", v);
    }

    static int connected_components(TGraph g)
    {
        int c;
        initialize_search(g);
        c = 0;
        for (int i = 1; i <= g.nvertices; i++)
            {
                if (!discovered[i])
                    {
                        c++;
                        // System.out.printf("Component %d:", c);
                        bfs(g, i);
                        // System.out.printf("\n");
                    }
            }
        return c;
    }

    static public void main(String[] args)
    {
        TGraph g = new TGraph();
        g.read_CCGraph(false);
        g.print_CCGraph();
        boolean flag = false;
        if (g.nedges == g.nvertices - 1)
            {
                flag = true;
                if (connected_components(g) == 1 && flag == true)
                    {
                        System.out
                        .println("Graph is a Tree, as graph is connected and Euler's criterion is satisfied.");
                    }
            }
        else
            {
                System.out
                .println("Graph is not a Tree, as Euler's criterion is not satisfied");
            }
    }
}

/*
Enter the number of vertices:
6
Enter the number of edges:
7
Enter the edges: <from> <to>
1 2
2 3
2 4
4 5
5 6
6 4
6 3
1:  2
2:  4 3 1
3:  6 2
4:  6 5 2
5:  6 4
6:  3 4 5
Graph is not a Tree, as Euler's criterion is not satisfied

Enter the number of vertices:
4
Enter the number of edges:
3
Enter the edges: <from> <to>
1 2
1 3
2 4
1:  3 2
2:  4 1
3:  1
4:  2
Graph is a Tree, as graph is connected and Euler's criterion is satisfied.
