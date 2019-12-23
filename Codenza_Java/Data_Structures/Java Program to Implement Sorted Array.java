/*This Java program is to Implement Sorted array. A sorted array is an array data structure in which each element is sorted in numerical, alphabetical, or some other order, and placed at equally spaced addresses in computer memory.*/

import java.util.Arrays;

public class SortedArray<T>
{
    private T[] array;

    public SortedArray(T[] array)
    {
        this.array = array;
    }

    public void sort()
    {
        Arrays.sort(array);
    }

    public T[] getArray()
    {
        return array;
    }

    public static void main(String...arg)
    {
        Integer[] inums = {10,9,8,7,6};
        Float[] fnums = {23.9f,5.5f,10.8f,2.5f,82.0f};
        Double[] dnums = {12.5,244.92,1.9,98.3,35.2};
        String[] strings = {"banana","pineapple","apple","mango","jackfruit"};
        System.out.println("The Values Before sorting");
        System.out.println();
        System.out.println("Integer Values");
        for (int i = 0; i < inums.length; i++)
            System.out.print(inums[i] + "\t");
        System.out.println();
        System.out.println("Floating Values");
        for (int i = 0; i < fnums.length; i++)
            System.out.print(fnums[i] + "\t");
        System.out.println();
        System.out.println("Double Values");
        for (int i = 0; i < dnums.length; i++)
            System.out.print(dnums[i] + "\t");
        System.out.println();
        System.out.println("String Values");
        for (int i = 0; i < strings.length; i++)
            System.out.print(strings[i] + "\t");
        SortedArray<Integer> integer = new SortedArray<Integer>(inums);
        SortedArray<Float> floating = new SortedArray<Float>(fnums);
        SortedArray<Double> doubles = new SortedArray<Double>(dnums);
        SortedArray<String> string = new SortedArray<String>(strings);
        integer.sort();
        floating.sort();
        doubles.sort();
        string.sort();
        inums = integer.getArray();
        fnums = floating.getArray();
        dnums = doubles.getArray();
        strings = string.getArray();
        System.out.println();
        System.out.println("The Values After sorting");
        System.out.println();
        System.out.println("Integer Values");
        for (int i = 0; i < inums.length; i++)
            System.out.print(inums[i] + "\t");
        System.out.println();
        System.out.println("Floating Values");
        for (int i = 0; i < fnums.length; i++)
            System.out.print(fnums[i] + "\t");
        System.out.println();
        System.out.println("Double Values");
        for (int i = 0; i < dnums.length; i++)
            System.out.print(dnums[i] + "\t");
        System.out.println();
        System.out.println("String Values");
        for (int i = 0; i < strings.length; i++)
            System.out.print(strings[i] + "\t");
    }
}

/*
The Values Before sorting

Integer Values
10	9	8	7	6
Floating Values
23.9	5.5	10.8	2.5	82.0
Double Values
12.5	244.92	1.9	98.3	35.2
String Values
banana	pineapple	apple	mango	jackfruit

The Values After sorting

Integer Values
6	7	8	9	10
Floating Values
2.5	5.5	10.8	23.9	82.0
Double Values
1.9	12.5	35.2	98.3	244.92
String Values
apple	banana	jackfruit	mango	pineapple
