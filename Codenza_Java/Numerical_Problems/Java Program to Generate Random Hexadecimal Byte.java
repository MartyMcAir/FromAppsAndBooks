/*
This is the java program to randomly generate a hexadecimal byte. First random decimal byte is generated and then converted to hexadecimal form.
*/

//This is sample program to generate random hexadeciaml bytes
import java.util.Random;

public class Generate_Random_Hex_Bytes
{
    public static void main(String args[])
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        System.out.println("Random Hex Byte: " + Hex);
    }
}

/*
Random Hex Byte: 63e15d89
