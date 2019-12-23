/*
To find missing numbers in an array first we need to make sure that array is sorted.
After sorting we need to check that array each element with next element then we can find the difference.
if Array is not sorted :To sort array use Arrays.sort(array);
If difference is 1 then no need to do any thing because numbers are in order.
If difference is not equal to 1 then we need to print all those numbers or pick those numbers and place it in one array.
this would be the logic to find missing numbers in an array
Here there may be a chance of array not starts with 1 then we need to check first itself whether array starts with 1 or not if not we need to print 1 to starting element of array.
for example int a[]={4,5,6,8}; then we need to print 1 2 3  7.
*/

public class PrintMissingNumbers
{

    private static void findMissingNumber(int[] number)
    {
        // take max length as last number in array
        int k[] = new int[number[number.length-1]];
        int m=0;
        if(number[0]!=1)
            {
                for (int x = 1; x < number[0]; x++)
                    {
                        k[m] =  x;
                        m++;
                    }
            }
        for (int i = 0; i < number.length -1; i++)
            {
                int j = i+1;
                int difference = number[j] - number[i] ;
                if(difference != 1 )
                    {
                        for (int x = 1; x < difference; x++)
                            {
                                k[m] = number[i] + x;
                                m++;
                            }
                    }
            }
        System.out.println("missing numbers in array ::");
        for (int l = 0; l < m ; l++)
            {
                System.out.println( k[l]+" ");
            }
    }
    public static void main(String[] args)
    {
        int a[]= {2,4,6,9,10,20};
        //if Array is not sorted :To sort array use ArraysC.sort(a);
        findMissingNumber(a);
    }
}
