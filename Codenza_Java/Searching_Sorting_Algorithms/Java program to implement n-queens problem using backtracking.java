///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//This program is to implement n-queens problem using backtracking
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class Backtrack
{
    public int x[];
    public int count;
    public Backtrack(int MAX)
    {
        x=new int[MAX];
    }
    /* This function is for printing the solution
       to n-queens problem
    */
    public void print_board(int n)
    {
        int i;
        System.out.println("\n\nSolution  :"+(++count));//number of solution
        for(i=1; i<=n; i++)
            {
                System.out.print("           "+i);
            }
        for(i=1; i<=n; i++)
            {
                System.out.print("\n\n"+i);
                for(int j=1; j<=n; j++)   // for nXn board
                    {
                        if(x[i]==j)
                            System.out.print("          Q");//Queen at i,j position
                        else
                            System.out.print("          -");// empty slot
                    }
            }
        System.out.print("\n Press any key to continue...");
    }
    /*
    This function is for checking for the conflicts.
    If there is no conflict for the desired position
    it returns 1 otherwise it returns 0
    */
    public boolean place(int row,int column)
    {
        int i;
        for(i=1; i<=row-1; i++)
            {
                //checking for column and diagonal conflicts
                if(x[i] == column)
                    return false;
                else if(Math.abs(x[i] -  column) == Math.abs(i - row))
                    return false;
            }
        //no conflicts hence Queen can be placed
        return true;
    }
    /* By this function we try the next free slot
    and check for proper positioning of queen
    */
    public void Queen(int row,int n)
    {
        int column;
        for(column=1; column<=n; column++)
            {
                if(place(row,column))
                    {
                        x[row] = column;
                        if(row==n)
                            print_board(n);//printing the board configuration
                        else  //try next queen with next position
                            Queen(row+1,n);
                    }
            }
    }
}
class BacktrackDemo
{
    public static void main (String[] args )throws IOException,NullPointerException
    {
        int n;
        Backtrack obj=new Backtrack(20);
        System.out.println("\n\t Program for n-Queens Using Backtracking");
        System.out.println("\nEnter Number of Queens");
        n=getInt();
        obj.Queen(1,n);//trace using backtrack
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
D:\DAA_MU>javac Backtrack.java

D:\DAA_MU>java BacktrackDemo

Program for n-Queens Using Backtracking

Enter Number of Queens
4


Solution  :1
1           2           3           4

1          -          Q          -          -

2          -          -          -          Q

3          Q          -          -          -

4          -          -          Q          -
Press any key to continue...

Solution  :2
1           2           3           4

1          -          -          Q          -

2          Q          -          -          -

3          -          -          -          Q

4          -          Q          -          -
Press any key to continue...
D:\DAA_MU>
