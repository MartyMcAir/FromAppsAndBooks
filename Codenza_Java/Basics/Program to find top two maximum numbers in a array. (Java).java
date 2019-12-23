/*
Write a program to find top two maximum numbers in the
given array. You should not use any sorting functions. You
should iterate the array only once. You should not use any
kind of collections in java.
*/

public class TwoMaxNumbers
{

    public void printTwoMaxNumbers(int[] nums)
    {
        int maxOne = 0;
        int maxTwo = 0;
        for(int n:nums)
            {
                if(maxOne < n)
                    {
                        maxTwo = maxOne;
                        maxOne =n;
                    }
                else if(maxTwo < n)
                    {
                        maxTwo = n;
                    }
            }
        System.out.println("First Max Number: "+maxOne);
        System.out.println("Second Max Number: "+maxTwo);
    }

    public static void main(String a[])
    {
        int num[] = {5,34,78,2,45,1,99,23};
        TwoMaxNumbers tmn = new TwoMaxNumbers();
        tmn.printTwoMaxNumbers(num);
    }
}

/*
Output:
First Max Number: 99
Second Max Number: 78
