///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Program for finding shortest path using dynamic programming approach
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
class Multistage
{
    public int stages,stage_vertices[],c[][];
    public int cost[],p[],n;
    public Multistage(int MAX)
    {
        c=new int[MAX][MAX];
        stage_vertices=new int[MAX];
        cost=new int[MAX];
        p=new int[MAX];
    }
    public int Get_min(int s,int n)
    {
        int min=9999;//equal to infinity
        int min_vertex=0;
        for(int i=0; i<n; i++)
            {
                if(min>(c[s][i]+cost[i]))
                    {
                        min=c[s][i]+cost[i];
                        min_vertex=i;
                    }
            }
        return min_vertex;
    }
    public void Forward(int n)
    {
        int i,r;
        int d[];
        d=new int[20];
        for(i=0; i<n; i++)
            cost[i]=0;//initalize graph by cost 0
        for(i=n-2; i>=0; i--)
            {
                r=Get_min(i,n);
                cost[i]=c[i][r]+cost[r];
                d[i]=r;
            }
        p[0]=0;
        p[stages-1]=n-1;
        for(i=1; i<stages-1; i++)
            p[i]=d[p[i-1]];
    }

    public void display( )
    {
        int i;
        System.out.print(" Shortest path is...\n");
        for(i=0; i<stages-1; i++)
            System.out.print(" -- "+(p[i]+1));
        System.out.print(" -- "+(p[i]+1));;//printing target node
    }
}
class MultistageDemo
{
    public static void main (String[] args )throws IOException,NullPointerException
    {
        Multistage obj=new Multistage(20);
        int n=0;
        int i,j,m,p;
        System.out.print("\nEnter no of vertices: ");
        n=getInt();
        System.out.print("\nEnter no of stages : ");
        obj.stages=getInt();
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                obj.c[i][j]=9999;//initialization
        for(i=0; i<obj.stages; i++)
            {
                System.out.print("\nEnter no of vertices in stage "+(i+1)+":  ");
                obj.stage_vertices[i]=getInt();
            }
        i=0;
        j=obj.stage_vertices[0];
        for(m=0; m<obj.stages; m++)
            {
                j=i+obj.stage_vertices[m];
                for(; i<j; i++)
                    {
                        for(p=0; p<obj.stage_vertices[m+1]; p++)
                            {
                                System.out.print("\nEnter cost for  "+(i+1)+"  to  "+(p+j+1)+": ");
                                obj.c[i][p+j]=getInt();//entering the corresponding cost
                            }
                    }
            }
        obj.Forward(n);
        obj.display( );
    }//end main

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

D:\DAA_MU>javac Multistage.java

D:\DAA_MU>java MultistageDemo

Enter no of vertices: 12

Enter no of stages : 5

Enter no of vertices in stage 1:  1

Enter no of vertices in stage 2:  4

Enter no of vertices in stage 3:  3

Enter no of vertices in stage 4:  3

Enter no of vertices in stage 5:  1

Enter cost for  1  to  2: 9

Enter cost for  1  to  3: 7

    Enter cost for  1  to  4: 3

        Enter cost for  1  to  5: 2

            Enter cost for  2  to  6: 4

                Enter cost for  2  to  7: 2

                    Enter cost for  2  to  8: 1

                        Enter cost for  3  to  6: 2

                            Enter cost for  3  to  7: 7

                                Enter cost for  3  to  8: 9999

                                    Enter cost for  4  to  6: 9999

                                        Enter cost for  4  to  7: 9999

                                            Enter cost for  4  to  8: 11

                                                Enter cost for  5  to  6: 9999

                                                    Enter cost for  5  to  7: 11

                                                        Enter cost for  5  to  8: 8

                                                            Enter cost for  6  to  9: 6

                                                                Enter cost for  6  to  10: 5

                                                                    Enter cost for  6  to  11: 9999

                                                                        Enter cost for  7  to  9: 4

                                                                            Enter cost for  7  to  10: 3

                                                                                Enter cost for  7  to  11: 9999

                                                                                    Enter cost for  8  to  9: 9999

                                                                                        Enter cost for  8  to  10: 5

                                                                                            Enter cost for  8  to  11: 6

                                                                                                Enter cost for  9  to  12: 4

                                                                                                    Enter cost for  10  to  12: 2

                                                                                                        Enter cost for  11  to  12: 5
                                                                                                            Shortest path is...
                                                                                                            -- 1 -- 2 -- 7 -- 10 -- 12
