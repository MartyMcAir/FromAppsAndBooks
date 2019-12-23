/*
This is the java program to generate N passwords each of length M given by the user. The number of passwords, N, returned doesn’t exceed M!.
Here is the source code of the Java Program to G
*/

//This is sample program to generate N passwords of length M, where N < M!
import java.util.Random;
import java.util.Scanner;

public class N_Password_M_Length
{
    static void permute(int []a, int k)
    {
        if(k==a.length)
            {
                for(int i=0; i<a.length; i++)
                    {
                        System.out.print(a[i]);
                    }
                System.out.println();
            }
        else
            {
                for (int i = k; i<a.length; i++)
                    {
                        int temp=a[k];
                        a[k]=a[i];
                        a[i]=temp;
                        permute(a,k+1);
                        temp=a[k];
                        a[k]=a[i];
                        a[i]=temp;
                    }
            }
    }
    public static void main(String args[])
    {
        System.out.println("Enter the length of the password: ");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        Random random = new Random();
        int []a = new int[m];
        for(int i=0; i<m; i++)
            {
                a[i] = random.nextInt(10);
            }
        System.out.println("The Possible Passwords are: ");
        N_Password_M_Length.permute(a, 0);
        input.close();
    }
}


/*

Enter the length of the password:
5
The Passwords are:
31210
31201
31120
31102
31012
31021
32110
32101
32110
32101
32011
32011
31210
31201
31120
31102
31012
31021
30211
30211
30121
30112
30112
30121
13210
13201
13120
13102
13012
13021
12310
12301
12130
12103
12013
12031
11230
11203
11320
11302
11032
11023
10213
10231
10123
10132
10312
10321
21310
21301
21130
21103
21013
21031
23110
23101
23110
23101
23011
23011
21310
21301
21130
21103
21013
21031
20311
20311
20131
20113
20113
20131
11230
11203
11320
11302
11032
11023
12130
12103
12310
12301
12031
12013
13210
13201
13120
13102
13012
13021
10231
10213
10321
10312
10132
10123
01213
01231
01123
01132
01312
01321
02113
02131
02113
02131
02311
02311
01213
01231
01123
01132
01312
01321
03211
03211
03121
03112
03112
03121
