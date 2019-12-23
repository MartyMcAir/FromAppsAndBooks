/*This is a java program to find the second smallest element with given complexity. Complexity here is minimum space constraints. Inplace sorting and returning second element help achieving the space constraints.*/

//This is a java program to find the second smallest element of N elements with the minimum space complexity constraints
import java.util.Random;

public class Second_Smallest_Element
{
    static int kthminimum(int[] sequence, int k)
    {
        // Bubble Sort for length of sequence minus k times
        for (int i = 0; i < (sequence.length - k); i++)
            for (int j = 0; j < sequence.length - 1; j++)
                if (sequence[j] > sequence[j + 1])
                    {
                        sequence[j] = sequence[j] + sequence[j + 1];
                        sequence[j + 1] = sequence[j] - sequence[j + 1];
                        sequence[j] = sequence[j] - sequence[j + 1];
                    }
        return sequence[k - 1];
    }

    public static void main(String args[])
    {
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(1000));
        System.out.println("Original Sequence: ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println("\nSecond smallest element :\n"
                           + kthminimum(sequence, 2));
    }
}

/*

Original Sequence:
459 886 873 766 616 878 122 372 453 876 845 965 477 139 788 861 148 5 894 439
Second smallest element :
122

Original Sequence:
695 213 257 62 315 289 234 90 153 721 192 183 676 373 292 928 57 472 200 177
Second smallest element :
62
