//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//This program is for Graph coloring Problem. The Backtracking method is
//used to solve this problem.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
class Gr_Color
{
    public int G[][],n,m,edges;
    int color_tab[];
    public Gr_Color(int MAX)
    {
        System.out.println("\n\n\t Graph Coloring ");
        G=new int[MAX][MAX];
        color_tab=new int[MAX];
        for(int i=0; i<MAX; i++)
            {
                for(int j=0; j<MAX; j++)
                    {
                        G[i][j]=0;
                        color_tab[i]=0;
                    }
            }
    }
    public void Gen_Col_Value(int k)
    {
        int j;
        int a,b;
        while(true)
            {
                a=color_tab[k]+1;
                b=m+1;
                color_tab[k] = a%b; // next highest color
                if(color_tab[k]==0) return;    // all colors have been used
                for(j=1; j<=n; j++)
                    {
                        // check if this color is distinct from adjacent colors
                        if(G[k][j]!=0 && color_tab[k]==color_tab[j])
                            break;
                    }
                if(j==n+1) return; // next new color found
            }
    }

// such that adjacent vertices are assigned distinct integers
// k is the index of next vertex color.
    public void Gr_coloring(int k)
    {
        Gen_Col_Value(k);
        if(color_tab[k]==0) return;   // No new color available
        if(k==n)  return;     // at most m colors have been
        else Gr_coloring(k+1);  // used to color the n vertices
    }
    public void display()
    {
        System.out.print("\n The Vertices To be Coloured As...\n");
        for(int i=1; i<=n; i++)
            System.out.print("\n V"+i+":= "+color_tab[i]);
    }
}
class Gr_ColorDemo
{
    public static void main (String[] args )throws IOException,NullPointerException
    {
        Gr_Color obj=new Gr_Color(10);
        int v1,v2;
        System.out.println("\n Enter the number of nodes  ");
        obj.n=getInt();
        System.out.println("\n Enter the number of edges  ");
        obj.edges=getInt();
        obj.m=obj.n-1;
        System.out.println("\n Create a graph");
        for (int i=1; i<=obj.edges; i++)
            {
                System.out.println("\n Enter the edges of the graph");
                System.out.println(" Enter value of V1 ");
                v1=getInt();
                System.out.println(" Enter value of V2 ");
                v2=getInt();
                obj.G[v1][v2] =obj. G[v2][v1] = 1;//if an edge is present then set it
            }
        obj.Gr_coloring(1);
        obj.display();
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
D:\DAA_MU>javac Gr_Color.java

D:\DAA_MU>java Gr_ColorDemo


Graph Coloring

Enter the number of nodes
5

Enter the number of edges
8

Create a graph

Enter the edges of the graph
Enter value of V1
1
Enter value of V2
2

Enter the edges of the graph
Enter value of V1
1
Enter value of V2
3

Enter the edges of the graph
Enter value of V1
1
Enter value of V2
4

Enter the edges of the graph
Enter value of V1
2
Enter value of V2
3

Enter the edges of the graph
Enter value of V1
2
Enter value of V2
4

Enter the edges of the graph
Enter value of V1
2
Enter value of V2
5

Enter the edges of the graph
Enter value of V1
3
Enter value of V2
4

Enter the edges of the graph
Enter value of V1
4
Enter value of V2
5

The Vertices To be Coloured As...

V1:= 1
     V2:= 2
          V3:= 3
               V4:= 4
                    V5:= 1
                         D:\DAA_MU>
