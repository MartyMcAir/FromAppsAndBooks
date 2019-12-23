/*This Java program is to Implement binary tree and check whether a tree is subtree of another. This can be done in two ways. A tree can be subtree of another if they have same structure (same object references but different value) and with same structure and values. This given class checks for both.*/

//This is a java program to check whether a binary tree is subtree of another tree
class Btrees
{
    Object value;
    Btrees Left;
    Btrees Right;

    Btrees(int k)
    {
        value = k;
    }
}

public class SubBinaryTree
{
    public static boolean ifsubtreeRef(Btrees t1, Btrees t2)
    {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        return (t1 == t2) || ifsubtreeRef(t1.Left, t2)
               || ifsubtreeRef(t1.Right, t2);
    }

    public static boolean ifsubtreeValue(Btrees t1, Btrees t2)
    {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.value == t2.value)
            if (ifsubtreeValue(t1.Left, t2.Left)
                    && ifsubtreeValue(t1.Right, t2.Right))
                return true;
        return ifsubtreeValue(t1.Left, t2) || ifsubtreeValue(t1.Right, t2);
    }

    public static void main(String[] args)
    {
        Btrees t1 = new Btrees(1);
        t1.Left = new Btrees(2);
        t1.Right = new Btrees(3);
        t1.Right.Left = new Btrees(4);
        t1.Right.Right = new Btrees(5);
        Btrees t2 = new Btrees(3);
        t2.Left = new Btrees(4);
        t2.Right = new Btrees(5);
        if (ifsubtreeRef(t1, t2))
            System.out.println("T2 is sub-tree of T1 (Reference wise)");
        else
            System.out.println("T2 is NOT sub-tree of T1 (Reference wise)");
        if (ifsubtreeValue(t1, t2))
            System.out.println("T2 is sub-tree of T1 (Value wise)");
        else
            System.out.println("T2 is NOT sub-tree of T1 (Value wise)");
    }
}

/*

T2 is NOT sub-tree of T1 (Reference wise)
T2 is sub-tree of T1 (Value wise)
