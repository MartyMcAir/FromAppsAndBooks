/*This is a java program to generate and print all the permutations of the input string. User first enters the length of the string and then actual string. The notion of permutation relates to the act of permuting, or rearranging, members of a set into a particular sequence or order (unlike combinations, which are selections that disregard order). For example, there are six permutations of the set {1,2,3}, namely (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), and (3,2,1).*/

//This is a java program to permute all the characters of the input string
import java.util.Scanner;

public class Permute_All_Letters
{
    static void permute(char[] a, int k)
    {
        if (k == a.length)
            {
                for (int i = 0; i < a.length; i++)
                    {
                        System.out.print(a[i]);
                    }
                System.out.println();
            }
        else
            {
                for (int i = k; i < a.length; i++)
                    {
                        char temp = a[k];
                        a[k] = a[i];
                        a[i] = temp;
                        permute(a, k + 1);
                        temp = a[k];
                        a[k] = a[i];
                        a[i] = temp;
                    }
            }
    }

    public static void main(String args[])
    {
        System.out.println("Enter the length of character string: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] sequence = new char[n];
        System.out.println("Enter the original string: ");
        for (int i = 0; i < n; i++)
            sequence[i] = sc.next().charAt(0);
        System.out.println("The permuted strings are: ");
        permute(sequence, 0);
        sc.close();
    }
}

/*


Enter the length of character string:
3
Enter the original string:
H e y
The permuted strings are:
Hey
Hye
eHy
eyH
yeH
yHe
