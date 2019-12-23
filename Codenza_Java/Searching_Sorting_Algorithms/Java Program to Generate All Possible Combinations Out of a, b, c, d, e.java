/*This is a java program to generate and print all possible combinations out of a, b, c, d, e. The trick here is to start with one letter combinations, then with two letter combinations and so on.*/

//This is a java program to print all possible combinations out of a, b, c, d, e

public class All_Possible_Combinatons
{
    static void printCombinations(char[] sequence, int N)
    {
        char[] data = new char[N];
        for (int r = 0; r < sequence.length; r++)
            combinations(sequence, data, 0, N - 1, 0, r);
    }

    static void combinations(char[] sequence, char[] data, int start, int end,
                             int index, int r)
    {
        if (index == r)
            {
                for (int j = 0; j < r; j++)
                    System.out.print(data[j] + " ");
                System.out.println();
            }
        for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++)
            {
                data[index] = sequence[i];
                combinations(sequence, data, i + 1, end, index + 1, r);
            }
    }

    public static void main(String args[])
    {
        char[] sequence = { 'a', 'b', 'c', 'd', 'e' };
        System.out.print("The combinations are: ");
        printCombinations(sequence, sequence.length);
    }
}

/*


The combinations are:
a
b
c
d
e
a b
a c
a d
a e
b c
b d
b e
c d
c e
d e
a b c
a b d
a b e
a c d
a c e
a d e
b c d
b c e
b d e
c d e
a b c d
a b c e
a b d e
a c d e
b c d e
