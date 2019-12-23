/*
This is a java program to generate random numbers using rand() and srand() functions. Java provides Random class that generates a random numbers. rand() gives long random numbers. srand() provides unique numbers.
*/

//This is a sample program to generate a random numbers using rand() and srand()
//rand() gives long random numbers
//srand() provides unique numbers
import java.util.Random;
import java.util.UUID;

public class Rand_and_Srand
{
    public static void main(String args[])
    {
        System.out.println("The numbers using rand");
        for(int i=0; i<5; i++)
            {
                Random rand = new Random();
                System.out.println(Math.abs(rand.nextInt()));
            }
        System.out.println("The numbers using srand");
        for(int i=0; i<5; i++)
            {
                System.out.println(Math.abs(UUID.randomUUID().getMostSignificantBits()));
            }
    }
}

/*
The numbers using rand
1339557437
636169175
1207287888
1539694038
1040189301
The numbers using srand
301709257092546335
8798470719933102847
3480203219570178904
3272351410737399038
2158529096808811162
