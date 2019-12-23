
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//To implement knapsack problem using Greedy algorithm
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.lang.*;
import java.util.*;
class KS
{
    public double[] x;
    public double U,profit,weight;
    public double[] p,w,c;
    public int m,n;
    public KS(int SIZE)
    {
        int i;
        profit=0.0;
        weight=0.0;
        x=new double[SIZE];
        p=new double[SIZE];
        w=new double[SIZE];
        c=new double[SIZE];
        for(i=0; i<n; i++)
            x[i]=0.0;
    }
    public void knapsack()
    {
        int i;
        U=m;
        for(i=0; i<n; i++)
            {
                if(w[i]>U)
                    break;
                x[i]=1.0;
                U=U-w[i];
            }
        if(i<n)
            x[i]=U/w[i];//take fractional part of item to fulfil the size
        System.out.print("\nThe solution vector is:");
        for(i=0; i<n; i++)
            System.out.print("\n   "+i+"    "+x[i]);
        for(i=0; i<n; i++)
            {
                w[i]=w[i]*x[i];
                p[i]=p[i]*x[i];
            }
        for(i=0; i<n; i++)
            {
                profit=profit+p[i];//computing total profit & wt.
                weight=weight+w[i];
            }
        System.out.print("\nMaximum profit is:   ");
        System.out.print("   "+profit);
        System.out.print("\nMaximum weight is: ");
        System.out.print("   "+weight);
    }
    public void display()
    {
        System.out.print("\n The items are arranged as  ...\n");
        System.out.print("\n\nItems\tweights\tProfits");
        {
            for(int i=0; i<n; i++)
                System.out.print("\nx["+i+"]"+"\t"+w[i]+"   \t"+p[i]);
        }
    }

}//end of class KS
class KnapsackDemo
{
    public static void main(String[] args)throws IOException,ArrayIndexOutOfBoundsException
    {
        KS obj=new KS(15);
        int i,j;
        double temp;
        System.out.println("\nEnter number of objects:");
        obj.n=getInt();
        System.out.print("\nEnter weights: ");
        for(i=0; i<obj.n; i++)
            obj.w[i]=getdouble();
        System.out.print("\nEnter profits:");
        for(i=0; i<obj.n; i++)
            obj.p[i]=getdouble();
        System.out.print("\nEnter knapsack size: ");
        obj.m=getInt();
        for(i=0; i<obj.n; i++)
            obj.c[i]=obj.p[i]/obj.w[i];
        for(i=0; i<obj.n; i++)
            {
                for(j=0; j<obj.n-1; j++)
                    {
                        if(obj.c[j] < obj.c[j+1])
                            {
                                temp=obj.c[j];
                                obj.c[j]=obj.c[j+1];
                                obj.c[j+1]=temp;
                                temp=obj.w[j];
                                obj.w[j]=obj.w[j+1];
                                obj.w[j+1]=temp;
                                temp=obj.p[j];
                                obj.p[j]=obj.p[j+1];
                                obj.p[j+1]=temp;
                            }
                    }
            }
        obj.display();
        obj.knapsack();
    }//end of main
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
    public static double getdouble() throws IOException
    {
        String str = getString();
        //double d= Double.valueOf(str);
        return Double.parseDouble(str);
    }

}
