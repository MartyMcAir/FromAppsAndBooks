import java.io.*;
import java.util.*;
class SeqSearch
{
    private int size;
    private int[] a;
    private int index;
    private int n=0;

//---------------------------------------------------------------------------------------
// 					constructor defined
//---------------------------------------------------------------------------------------
    public SeqSearch(int Max)
    {
        size=Max;
        a=new int[size];
        index=0;
    }
//---------------------------------------------------------------------------------------
// 				inserting an element in the array
//---------------------------------------------------------------------------------------
    public void insert(int val)
    {
        try
            {
                a[index++] = val;
                n=index;
            }
        catch(Exception e)
            {
                System.out.println(�e.getMessage�);
            }
    }
//---------------------------------------------------------------------------------------------
//  Searching the element by sequential search
//  method
//---------------------------------------------------------------------------------------------
    public int Search(int key)
    {
        for(int i=0; i<n; i++)
            {
                if(a[i]==key)
                    return 1;
            }
        return 0;
    }
//---------------------------------------------------------------------------------------------
//  Displaying the elments of an array
//---------------------------------------------------------------------------------------------
    public void display()
    {
        System.out.println(�\n The elements are�);
        for(int i=0; i<n; i++)
            System.out.println(�  �+a[i]);
    }
}  // end class

class SeqSearchDemo
{
    public static void main(String[] args)throws IOException
    {
        SeqSearch obj=new SeqSearch(10);
        System.out.println(�\n Inserting  items in the array�);
        obj.insert(20);
        obj.insert(10);
        obj.insert(30);
        obj.insert(50);
        obj.insert(40);
        obj.insert(60);
        obj.display();
        System.out.println(�\n Enter the elements to be searched�);
        int key=getInt();
        int status=obj.Search(key);
        if(status==1)
            System.out.println(�\n The element is present in the list�);
        else
            System.out.println(�\n The element is not present in the list�);
    }  // end main()
////////////////////////////////////////////////////////////////////////////////
//Following functions are used to handle the inputs entered
//by the user using keyboard
////////////////////////////////////////////////////////////////////////////////
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
        return Integer.parseInt(str);//converting console string
        //to numeric value
    }
}//end of class


