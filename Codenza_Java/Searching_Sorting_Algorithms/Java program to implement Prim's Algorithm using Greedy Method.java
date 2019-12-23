/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//This program is to implement Prim�s Algorithm using Greedy Method
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
class PRIM_MST
{

    public int G[][],nodes,v1,v2;
    public PRIM_MST(int SIZE)
    {
        int i,j;
        G=new int[SIZE][SIZE];
        for (i=0 ; i<SIZE ; i++)       // Initialize the graph
            for (j=0 ; j<SIZE ; j++)
                G[i][j] = 0;
    }

    /*	 This function finds the minimal spanning tree by Prim�s Algorithm   */
    public void Prim(int SIZE)
    {
        int  i, j, k;
        boolean select[];
        int min_dist,V1=0,V2=0, total=0;
        select=new boolean[SIZE];
        for (i=0 ; i<nodes ; i++)   // Initialize the selected vertices list
            select[i] = false;
        System.out.print("\n\n The Minimal Spanning Tree Is :\n");
        select[0] = true;
        for (k=1 ; k<nodes ; k++)
            {
                min_dist =  9999;
                for (i=0 ; i<nodes ; i++)   // Select an edge such that one vertex is
                    {
                        // selected and other is not and the edge
                        for (j=0 ; j<nodes ; j++)   // has the least weight.
                            {
                                if (G[i][j]!=0 && ((select[i] && !select[j]) || (!select[i] && select[j])))
                                    {
                                        if (G[i][j] < min_dist)   //obtained edge with minimum wt
                                            {
                                                min_dist = G[i][j];
                                                V1 = i;
                                                V2 = j;   //picking up those vertices
                                            }
                                    }
                            }
                    }
                System.out.print("\n Edge ("+V1+"  "+V2+") and weight = "+min_dist);
                select[V1] = select[V2] = true;
                total =total+min_dist;
            }
        System.out.print("\n\n\t Total Path Length Is =  "+total);
    }
    public void get_data(int v1,int v2,int length)
    {
        G[v1][v2] = G[v2][v1] = length;
    }
    public void display(int SIZE)
    {
        System.out.println("\n The adjacency matrix graph is ...");
        for(int i=0; i<SIZE; i++)
            {
                for(int j=0; j<SIZE; j++)
                    {
                        System.out.print("      "+G[i][j]);
                    }
                System.out.println();
            }
    }
}
class PRIM_MSTDemo
{
    public static void main (String[] args )throws IOException,NullPointerException
    {
        int i, length, n;
        PRIM_MST obj=new PRIM_MST(10);
        System.out.print("\n\t Prim's Algorithm\n");
        System.out.print("\n Enter Number of Nodes in The Graph  ");
        obj.nodes=getInt();
        System.out.print("\n Enter Number of Edges in The Graph  ");
        n=getInt();
        //entering weighted graph
        System.out.print("\n Enter edges and weights \n");
        for (i=0 ; i<n; i++)
            {
                System.out.print("\n Enter Edge by V1 and V2 : ");
                obj. v1=getInt();
                obj.v2=getInt();
                System.out.print("\n Enter corresponding weight :");
                length=getInt();
                obj.get_data(obj.v1,obj.v2,length);
            }
        obj.display(10);
        System.out.println("\n");
        obj.Prim(10);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////
//Following functions are used to handle the inputs entered
//by the user using keyboard
///////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String getString() throws IOException
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(input);
        String str = b.readLine();//reading the string from console
        return str;
    }

    public static char getChar() throws IOException
    {
        String str = getString();
        return str.charAt(0);//reading first char of console string
    }
    public static int getInt() throws IOException
    {
        String str = getString();
        return Integer.parseInt(str);//converting console string to numeric value
    }
}
Output
D:\DAA_MU>javac PRIM_MST.java

D:\DAA_MU>java PRIM_MSTDemo

Prim's Algorithm

Enter Number of Nodes in The Graph  7

Enter Number of Edges in The Graph  9

Enter edges and weights

Enter Edge by V1 and V2 : 0
1

Enter corresponding weight :27

Enter Edge by V1 and V2 : 1
2

Enter corresponding weight :16

Enter Edge by V1 and V2 : 2
3

Enter corresponding weight :12

Enter Edge by V1 and V2 : 3
4

Enter corresponding weight :22

Enter Edge by V1 and V2 : 4
5

Enter corresponding weight :25

Enter Edge by V1 and V2 : 0
5

Enter corresponding weight :6

Enter Edge by V1 and V2 : 1
6

Enter corresponding weight :14

Enter Edge by V1 and V2 : 4
6

Enter corresponding weight :24

Enter Edge by V1 and V2 : 3
6

Enter corresponding weight :18

The adjacency matrix graph is ...
0      27      0      0      0      6      0      0      0      0
27      0      16      0      0      0      14      0      0      0
0      16      0      12      0      0      0      0      0      0
0      0      12      0      22      0      18      0      0      0
0      0      0      22      0      25      24      0      0      0
6      0      0      0      25      0      0      0      0      0
0      14      0      18      24      0      0      0      0      0
0      0      0      0      0      0      0      0      0      0
0      0      0      0      0      0      0      0      0      0
0      0      0      0      0      0      0      0      0      0

The Minimal Spanning Tree Is :

Edge (0  5) and weight = 6
                         Edge (4  5) and weight = 25
                                 Edge (3  4) and weight = 22
                                         Edge (2  3) and weight = 12
                                                 Edge (1  2) and weight = 16
                                                         Edge (1  6) and weight = 14

                                                                 Total Path Length Is =  95
                                                                         D:\DAA_MU>
