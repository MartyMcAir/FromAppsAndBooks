/*This Java program is to Implement Sparse array. In computer science, a sparse array is an array in which most of the elements have the same value (known as the default value—usually 0 or null). The occurrence of zero elements in a large array is inefficient for both computation and storage. An array in which there is a large number of zero elements is referred to as being sparse.*/

class List
{
    private int index;
    private Object value;
    private List nextindex;

    public List(int index)
    {
        this.index = index;
        nextindex = null;
        value = null;
    }

    public List()
    {
        index = -1;
        value = null;
        nextindex = null;
    }

    public void store(int index, Object value)
    {
        List current = this;
        List previous = null;
        List node = new List(index);
        node.value = value;
        while (current != null && current.index < index)
            {
                previous = current;
                current = current.nextindex;
            }
        if (current == null)
            {
                previous.nextindex = node;
            }
        else
            {
                if (current.index == index)
                    {
                        System.out.println("DUPLICATE INDEX");
                        return;
                    }
                previous.nextindex = node;
                node.nextindex = current;
            }
        return;
    }

    public Object fetch(int index)
    {
        List current = this;
        Object value = null;
        while (current != null && current.index != index)
            {
                current = current.nextindex;
            }
        if (current != null)
            {
                value = current.value;
            }
        else
            {
                value = null;
            }
        return value;
    }

    public int elementCount()
    {
        int elementCount = 0;
        for (List current = this.nextindex; (current != null); current = current.nextindex)
            {
                elementCount++;
            }
        return elementCount;
    }
}

public class SparseArray
{
    private List start;
    private int index;

    SparseArray(int index)
    {
        start = new List();
        this.index = index;
    }

    public void store(int index, Object value)
    {
        if (index >= 0 && index < this.index)
            {
                if (value != null)
                    start.store(index, value);
            }
        else
            {
                System.out.println("INDEX OUT OF BOUNDS");
            }
    }

    public Object fetch(int index)
    {
        if (index >= 0 && index < this.index)
            return start.fetch(index);
        else
            {
                System.out.println("INDEX OUT OF BOUNDS");
                return null;
            }
    }

    public int elementCount()
    {
        return start.elementCount();
    }

    public static void main(String... arg)
    {
        Integer[] iarray = new Integer[5];
        iarray[0] = 1;
        iarray[1] = null;
        iarray[2] = 2;
        iarray[3] = null;
        iarray[4] = null;
        SparseArray sparseArray = new SparseArray(5);
        for (int i = 0; i < iarray.length; i++)
            {
                sparseArray.store(i, iarray[i]);
            }
        System.out.println("NORMAL ARRAY");
        for (int i = 0 ; i < iarray.length; i++)
            {
                System.out.print(iarray[i] + "\t");
            }
        System.out.println("\nSPARSE ARRAY");
        for (int i = 0; i < iarray.length; i++)
            {
                if (sparseArray.fetch(i) != null)
                    System.out.print(sparseArray.fetch(i) + "\t");
            }
        System.out.println("The Size of Sparse Array is " + sparseArray.elementCount());
    }
}

/*
NORMAL ARRAY
1	null	2	null	null
SPARSE ARRAY
1	2
The Size of Sparse Array 2
