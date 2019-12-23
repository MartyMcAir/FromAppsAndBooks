/*This Java program is to Implement Vector. The elements of a vector are stored contiguously.Like all dynamic array implementations, vectors have low memory usage and good locality of reference and data cache utilization*/

import java.util.ArrayList;
import java.util.Scanner;

public class Vector<T>
{
    private int capacity;
    private int size;
    private ArrayList<T> vector;
    private static final int INCREMENT_FACTOR = 5;

    public Vector(int size)
    {
        this.size = size;
        this.capacity = size + INCREMENT_FACTOR;
        vector = new ArrayList<T>();
    }

    public void store(int index, T value)
    {
        try
            {
                vector.set(index, value);
            }
        catch (IndexOutOfBoundsException indexOutBounds)
            {
                if (index >= 0 && (index < size))
                    {
                        vector.add(index, value);
                    }
                if (index >= 0 && (index >= size && index < capacity))
                    {
                        vector.add(index, value);
                        size = index + 1;
                        if (size == capacity)
                            capacity = capacity + INCREMENT_FACTOR;
                    }
                if (index >= capacity)
                    {
                        throw new IndexOutOfBoundsException();
                    }
            }
    }

    public T get(int index)
    {
        try
            {
                return vector.get(index);
            }
        catch (IndexOutOfBoundsException indexOutBounds)
            {
            }
        return null;
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public static void main(String... arg)
    {
        int size;
        int num;
        int value;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial size of the vector");
        size = scanner.nextInt();
        Vector<Integer> vector = new Vector<>(size);
        System.out.println("Enter the number of elements ");
        num = scanner.nextInt();
        System.out.println("Enter the values");
        for (int index = 0; index < num; index++)
            {
                value = scanner.nextInt();
                vector.store(index, value);
            }
        System.out.println("The Entered Values are");
        for (int index = 0; index < vector.getSize(); index++)
            {
                System.out.print(vector.get(index) + "\t");
            }
        System.out.println("\nTHE SIZE OF THE VECTOR IS  " + vector.getSize());
        System.out.println("THE CAPACITY OF THE VECTOR IS  " + vector.getCapacity());
        scanner.close();
    }
}

/*
Enter the initial size of the vector
5
Enter the number of elements
5
Enter the values
10 9 8 7 6
The Entered Values are
10	9	8	7	6
THE SIZE OF THE VECTOR IS  5
THE CAPACITY OF THE VECTOR IS  10
