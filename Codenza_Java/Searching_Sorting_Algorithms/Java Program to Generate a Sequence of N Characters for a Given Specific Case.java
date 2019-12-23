
import java.util.Scanner;

public class SequenceOfNCharacters
{
    public static Integer randomInt(Integer low, Integer high)
    {
        return (int) (Math.floor(Math.random() * (high - low + 1)) + low);
    }

    public static Character randomChar(String str)
    {
        return str.charAt(randomInt(0, str.length() - 1));
    }

    public static String generateRandSeq(Integer length, String src)
    {
        String seq = "";
        for (int i = 1; i <= length; i = i + 1)
            {
                seq += randomChar(src);
            }
        return seq;
    }

    public static void main(String[] args)
    {
        String src = "abcdefghijklmnopqrstuvwxyz";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of sequences to be generated: ");
        int numberOfSequence = sc.nextInt();
        System.out.println("Enter the length of each sequence: ");
        int length = sc.nextInt();
        for (int i = 0; i < numberOfSequence; i++)
            {
                System.out.println(generateRandSeq(length, src));
            }
        sc.close();
    }
}

/*

Enter the number of sequences to be generated:
4
Enter the length of each sequence:
5
qgpnt
kdxyr
ynhmf
wambi

Enter the number of sequences to be generated:
3
Enter the length of each sequence:
8
ilhddizq
evmpejxv
malvlhja
