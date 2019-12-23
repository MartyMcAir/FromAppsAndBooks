/*This is a Java Program to compute cross product of two vectors. In mathematics, the cross product or vector product is a binary operation on two vectors in three-dimensional space. It results in a vector that is perpendicular to both and therefore normal to the plane containing them.*/

//This is a java program to find the cross product of two vectors
import java.util.Random;

public class Cross_Product
{
    public static void main(String args[])
    {
        Random random = new Random();
        int u1, u2, u3, v1, v2, v3;
        u1 = random.nextInt(10);
        u2 = random.nextInt(10);
        u3 = random.nextInt(10);
        v1 = random.nextInt(10);
        v2 = random.nextInt(10);
        v3 = random.nextInt(10);
        int uvi, uvj, uvk;
        uvi = u2 * v3 - v2 * u3;
        uvj = v1 * u3 - u1 * v3;
        uvk = u1 * v2 - v1 * u2;
        System.out.println("The cross product of the 2 vectors \n u = " + u1
                           + "i + " + u2 + "j + " + u3 + "k and \n v = " + u1 + "i + "
                           + u2 + "j + " + u3 + "k \n ");
        System.out.println("u X v : " + uvi + "i +" + uvj + "j+ " + uvk + "k ");
    }
}

/*
The cross product of the 2 vectors
 u = 3i + 8j + 9k and
 v = 3i + 8j + 9k

u X v : -2i +48j+ -42k
