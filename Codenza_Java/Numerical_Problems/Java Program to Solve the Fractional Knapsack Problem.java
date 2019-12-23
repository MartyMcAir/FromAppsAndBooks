/*
This is a java program to implement a standard fractional knapsack problem. It is an algorithmic problem in combinatorial optimization in which the goal is to fill a container (the “knapsack”) with fractional amounts of different materials chosen to maximize the value of the selected materials.
*/

//This is a sample program to implement a fractional knapsack problem
import java.io.IOException;
import java.util.Scanner;

class Fractional_Knapsack
{
    public static void main(String args[]) throws IOException
    {
        int i,j=0,max_qty,m,n;
        float sum=0,max;
        Scanner sc = new Scanner(System.in);
        int array[][]=new int[2][20];
        System.out.println("Enter no of items");
        n=sc.nextInt();
        System.out.println("Enter the weights of each items");
        for(i=0; i<n; i++)
            array[0][i]=sc.nextInt();
        System.out.println("Enter the values of each items");
        for(i=0; i<n; i++)
            array[1][i]=sc.nextInt();
        System.out.println("Enter maximum volume of knapsack :");
        max_qty=sc.nextInt();
        m=max_qty;
        while(m>=0)
            {
                max=0;
                for(i=0; i<n; i++)
                    {
                        if(((float)array[1][i])/((float)array[0][i])>max)
                            {
                                max=((float)array[1][i])/((float)array[0][i]);
                                j=i;
                            }
                    }
                if(array[0][j]>m)
                    {
                        System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);
                        sum+=m*max;
                        m=-1;
                    }
                else
                    {
                        System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);
                        m-=array[0][j];
                        sum+=(float)array[1][j];
                        array[1][j]=0;
                    }
            }
        System.out.println("The total profit is " + sum);
        sc.close();
    }
}

/*
Enter no of items
5
Enter the weights of each items
10 20 30 40 50
Enter the values of each items
5 4 3 2 1
Enter maximum volume of knapsack :
80
Quantity of item number: 1 added is 10
Quantity of item number: 2 added is 20
Quantity of item number: 3 added is 30
Quantity of item number: 4 added is 20
The total profit is 13.0
