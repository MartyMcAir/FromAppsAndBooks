/*This Java program is to Implement Variable length array. In programming, a variable-length array (or VLA) is an array data structure of automatic storage duration whose length is determined at run time (instead of at compile time).*/

import java.util.ArrayList;
import java.util.Scanner;

public class VariableLengthArray<T>
{
    private volatile int size;
    private ArrayList<T> array;

    public VariableLengthArray()
    {
        array = new ArrayList<T>();
        setSize(-1);
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return size;
    }

    public void store(int index, T value)
    {
        try
            {
                array.set(index, value);
            }
        catch (IndexOutOfBoundsException indexOutBounds)
            {
                if (index >= 0 && !(index < size))
                    {
                        throw new IndexOutOfBoundsException();
                    }
                array.add(index, value);
            }
    }

    public T get(int index)
    {
        try
            {
                if (index >= 0 && index < size)
                    return array.get(index);
                else
                    throw new IndexOutOfBoundsException();
            }
        catch (IndexOutOfBoundsException indexOutBounds)
            {
                System.out.println("INDEX OUT OF BOUNDS : the specified index is
                                   more than the size of the  array");
            }
        return null;
    }

    public T remove(int index)
    {
        try
            {
                if (index >= 0 && index < size)
                    {
                        size--;
                        return array.remove(index);
                    }
                else
                    throw new IndexOutOfBoundsException();
            }
        catch (IndexOutOfBoundsException indexOutBounds)
            {
                System.out.println("INDEX OUT OF BOUNDS : the specified index
                                   is more than the size of the array");
            }
        return null;
    }

    public static void main(String... arg)
    {
        int size, value;
        String choice;
        Scanner scanner = new Scanner(System.in);
        VariableLengthArray<Integer> integersArray = new VariableLengthArray<Integer>();
        do
            {
                System.out.println("Enter the size of the array");
                size = scanner.nextInt();
                integersArray.setSize(size);
                System.out.println("Enter the values of the array");
                for (int index = 0; index < integersArray.getSize(); index++)
                    {
                        value = scanner.nextInt();
                        integersArray.store(index, value);
                    }
                System.out.println("The Values entered are ");
                for (int index = 0; index < integersArray.getSize(); index++)
                    {
                        System.out.print(integersArray.get(index) + "\t");
                    }
                System.out.println("\nEnter more values ?[y/n]");
                choice = scanner.next();
            }
        while (choice.equals("y"));
        scanner.close();
    }
}

/*
Enter the size of the array
5
Enter the values of the array
10 9 8 7 6
The Values entered are
10	9	8	7	6
Enter more values ?[y/n]
y
Enter the size of the array
3
Enter the values of the array
2 3 4
The Values entered are
2	3	4
