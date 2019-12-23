import java.io.*;
import java.util.*;
class BinSearch
{
    private int size;
    private int[] a;
    private int index;
    public int n=0;

//-----------------------------------------------------------------------------------------
// 					constructor defined
//-----------------------------------------------------------------------------------------
    public BinSearch(int Max)
    {
        size=Max;
        a=new int[size];
        index=0;
    }
//-----------------------------------------------------------------------------------------
// 				inserting an element in the array
//-----------------------------------------------------------------------------------------
    public void insert(int val)
    {
        try
            {
                a[index++]=val;
                n=index;
            }
        catch(Exception e)
            {
                System.out.println("e.getMessage");
            }
    }
//-----------------------------------------------------------------------------------------
//  Searching the element by Binary search
//  method
//----------------------------------------------------------------------------------------
    public void Search(int low,int high,int key)
    {
        int mid;
        if(low>high)
            {
                System.out.println(" Error! It is not present in the list");
                return;
            }
        mid=(low+high)/2;
        if(key==a[mid])
            System.out.println("\nThe element is present at location "+(mid+1));
        else if(key<a[mid])
            Search(low,mid-1,key);
        else if(key>a[mid])
            Search(mid+1,high,key);
    }
//----------------------------------------------------------------------------------------
//  			Displaying the elements of an array
//----------------------------------------------------------------------------------------
    public void display()
    {
        System.out.println("\n The elements are");
        for(int i=0; i<n; i++)
            System.out.println("  "+a[i]);
    }
}  // end class

class BinSearchDemo
{
    public static void main(String[] args)throws IOException
    {
        BinSearch obj = new BinSearch(10);
        System.out.println("\n Inserting  items in the array");
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);
        obj.insert(60);
        obj.insert(70);
        obj.display();
        System.out.println("\n Enter the elements to be searched");
        int key=getInt();
        int low=0;
        int high=obj.n;
        obj.Search(low,high,key);
    }  // end main()
//////////////////////////////////////////////////////////////////////////////
//Following functions are used to handle the inputs entered
//by the user using keyboard
//////////////////////////////////////////////////////////////////////////////
    public static String getString() throws IOException
    {
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(input);
        String str=b.readLine();//reading the string from console
        return str;
    }
    public static int getInt() throws IOException
    {
        String str=getString();
        return Integer.parseInt(str);//converting console string 															//to numeric value
    }
}//end of class



