import java.io.*;
import java.util.*;
class Bubble
{
    public int n;
    public int[] A;
    /*
    -----------------------------------------------------------------
    Constructor defined
    -----------------------------------------------------------------
    */
    public Bubble(int MAX)
    {
        A=new int[MAX];
    }
    /*
    ----------------------------------------------------------------------------------
    			bubblesort : function for sorting the elements
    ----------------------------------------------------------------------------------
    */
    public void bubblesort(int n)
    {
        int temp;
        for(int i=0; i<=n-2; i++)
            {
                for(int j=0; j<=n-2-i; j++)
                    {
                        if(A[j]>A[j+1])
                            {
                                temp=A[j];
                                A[j]=A[j+1];
                                A[j+1]=temp;
                            }//end of if
                    }//end of inner for
            }//end of outer for
    }//end of function
    /*
    ----------------------------------------------------------------------------------
    			display: function for displaying the elements
    ----------------------------------------------------------------------------------
    */
    public void display(int n)
    {
        System.out.println("\n The sorted List is ...\n");
        for(int i=0; i<n; i++)
            System.out.print("   "+A[i]);
    }
}

class BubbleDemo
{
    public static void main(String[] args)throws
    IOException,ArrayIndexOutOfBoundsException
    {
        Bubble obj=new Bubble(10);
        int n;
        System.out.println("\n\t Program for Bubble Sort    ");
        System.out.println("\n How many elements are there?");
        n=getInt();
        System.out.println("\n Enter the elements ");
        for(int i=0; i<n; i++)
            obj.A[i]=getInt();
        obj.bubblesort(n);
        obj.display(n);
    }//end of main
/////////////////////////////////////////////////////////////////////////
//Following functions are used to handle the inputs entered
//by the user using keyboard
////////////////////////////////////////////////////////////////////////
    public static String getString() throws IOException
    {
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(input);
        String str=b.readLine();//reading the string from console
        return str;
    }
    public static char getChar() throws IOException
    {
        //This function can be use instead of getInt()for handling 	//character type elements
        String str=getString();
        return str.charAt(0);//reading first char of console string
    }
    public static int getInt() throws IOException
    {
        String str=getString();
        return Integer.parseInt(str);//converting console string
        //to numeric value
    }
}//end of class BubbleDemo


