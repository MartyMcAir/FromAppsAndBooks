
class SecondSmallestNumber
{

    public static void main(String args[])
    {
        int numbers[] = {6,3,37,12,46,5,64,21};
        int smallest=  numbers[0];;
        int second_smallest =  numbers[0];;
        for(int n:numbers)
            {
                if(n< smallest)
                    {
                        second_smallest = smallest;
                        smallest=n;
                    }
                else if( n< second_smallest)
                    {
                        second_smallest= n;
                    }
            }
        System.out.println("Smallest Number: "+smallest);
        System.out.println("Second Smallest Number: "+second_smallest);
    }

}
