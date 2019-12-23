import java.io.*;
import java.util.*;
class HeapSrt
{
    public int[ ] arr;
    public HeapSrt(int MAX)
    {
        arr=new int[MAX];
    }

    public void makeheap(int n)
    {
        int val,j,father;
        for(int i=1; i<n; i++)
            {
                val=arr[i];
                j=i;
                father=(j-1)/2;//finding the parent of node j
                while(j>0&&arr[father]<val)   //creating a MAX heap
                    {
                        arr[j]=arr[father];//preserving parent dominance
                        j=father;
                        father=(j-1)/2;
                    }
                arr[j]=val;
            }
    }
    void heapsort(int n)
    {
        int k,temp,j;
        for(int i=n-1; i>0; i�)
            {
                temp=arr[i];
                arr[i]=arr[0];
                k=0;
                if(i==1)
                    j=-1;
                else
                    j=1;
                if(i>2&&arr[2]>arr[1])
                    j=2;
                while(j>=0&& temp <arr[j])
                    {
                        arr[k]=arr[j];
                        k=j;
                        j=2*k+1;
                        if(j+1<=i-1&&arr[j]<arr[j+1])
                            j++;
                        if(j>i-1)
                            j=-1;
                    }
                arr[k]=temp;
            }
    }
    /*
    ----------------------------------------------------------------------------------
    			display: function for displaying the elements
    ----------------------------------------------------------------------------------
    */
    public void display(int n)
    {
        for(int i=0; i<n; i++)
            System.out.println(arr[i]);
    }
}
class HeapSrtDemo
{
    public static void main(String[] args)throws IOException
    {
        HeapSrt obj=new HeapSrt(10);
        int n;
        System.out.println("\n\t Program for Heap Sort    ");
        System.out.println("\n How many elements are there?");
        n=getInt();
        System.out.println("\n Enter the elements ");
        for(int i=0; i<n; i++)
            obj.arr[i]=getInt();
        System.out.println("\n The Elements are...");
        obj.display(n);
        obj.makeheap(n);
        System.out.println("\n Heapified");
        obj.display(n);
        obj.heapsort(n);
        System.out.println("\nElements sorted by Heap sort... ");
        obj.display(n);
    }//end of main
////////////////////////////////////////////////////////////////////////////
//Following functions are used to handle the inputs entered
//by the user using keyboard
////////////////////////////////////////////////////////////////////////////
    public static String getString() throws IOException
    {
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(input);
        String str=b.readLine();//reading the string from console
        return str;
    }
    public static char getChar() throws IOException
    {
        String str=getString();
        return str.charAt(0);//reading first char of console string
    }
    public static int getInt() throws IOException
    {
        String str=getString();
        return Integer.parseInt(str);//converting console string 																		    //to numeric value
    }
}//end of class


