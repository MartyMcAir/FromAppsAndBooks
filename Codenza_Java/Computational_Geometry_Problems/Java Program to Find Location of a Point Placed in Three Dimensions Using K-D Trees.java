/*This is a Java Program to implement 3D KD Tree and Search an element. In computer science, a k-d tree (short for k-dimensional tree) is a space-partitioning data structure for organizing points in a k-dimensional space. k-d trees are a useful data structure for several applications, such as searches involving a multidimensional search key (e.g. range searches and nearest neighbor searches). k-d trees are a special case of binary space partitioning trees.*/

//This is a java program to find the location of point in 3 dimensional KD Tree
import java.io.IOException;
import java.util.Scanner;

class KD3DNode
{
    int axis;
    double[] x;
    int id;
    boolean checked;
    boolean orientation;

    KD3DNode Parent;
    KD3DNode Left;
    KD3DNode Right;

    public KD3DNode(double[] x0, int axis0)
    {
        x = new double[3];
        axis = axis0;
        for (int k = 0; k < 3; k++)
            x[k] = x0[k];
        Left = Right = Parent = null;
        checked = false;
        id = 0;
    }

    public KD3DNode FindParent(double[] x0)
    {
        KD3DNode parent = null;
        KD3DNode next = this;
        int split;
        while (next != null)
            {
                split = next.axis;
                parent = next;
                if (x0[split] > next.x[split])
                    next = next.Right;
                else
                    next = next.Left;
            }
        return parent;
    }

    public KD3DNode Insert(double[] p)
    {
        x = new double[3];
        KD3DNode parent = FindParent(p);
        if (equal(p, parent.x, 3) == true)
            return null;
        KD3DNode newNode = new KD3DNode(p,
                                        parent.axis + 1 < 3 ? parent.axis + 1 : 0);
        newNode.Parent = parent;
        if (p[parent.axis] > parent.x[parent.axis])
            {
                parent.Right = newNode;
                newNode.orientation = true; //
            }
        else
            {
                parent.Left = newNode;
                newNode.orientation = false; //
            }
        return newNode;
    }

    boolean equal(double[] x1, double[] x2, int dim)
    {
        for (int k = 0; k < dim; k++)
            {
                if (x1[k] != x2[k])
                    return false;
            }
        return true;
    }

    double distance2(double[] x1, double[] x2, int dim)
    {
        double S = 0;
        for (int k = 0; k < dim; k++)
            S += (x1[k] - x2[k]) * (x1[k] - x2[k]);
        return S;
    }
}

class KD3DTree
{
    KD3DNode Root;

    int TimeStart, TimeFinish;
    int CounterFreq;

    double d_min;
    KD3DNode nearest_neighbour;

    int KD_id;

    int nList;

    KD3DNode CheckedNodes[];
    int checked_nodes;
    KD3DNode List[];

    double x_min[], x_max[];
    boolean max_boundary[], min_boundary[];
    int n_boundary;

    public KD3DTree(int i)
    {
        Root = null;
        KD_id = 1;
        nList = 0;
        List = new KD3DNode[i];
        CheckedNodes = new KD3DNode[i];
        max_boundary = new boolean[3];
        min_boundary = new boolean[3];
        x_min = new double[3];
        x_max = new double[3];
    }

    public boolean add(double[] x)
    {
        if (nList >= 2000000 - 1)
            return false; // can't add more points
        if (Root == null)
            {
                Root = new KD3DNode(x, 0);
                Root.id = KD_id++;
                List[nList++] = Root;
            }
        else
            {
                KD3DNode pNode;
                if ((pNode = Root.Insert(x)) != null)
                    {
                        pNode.id = KD_id++;
                        List[nList++] = pNode;
                    }
            }
        return true;
    }

    public KD3DNode find_nearest(double[] x)
    {
        if (Root == null)
            return null;
        checked_nodes = 0;
        KD3DNode parent = Root.FindParent(x);
        nearest_neighbour = parent;
        d_min = Root.distance2(x, parent.x, 3);
        ;
        if (parent.equal(x, parent.x, 3) == true)
            return nearest_neighbour;
        search_parent(parent, x);
        uncheck();
        return nearest_neighbour;
    }

    public void check_subtree(KD3DNode node, double[] x)
    {
        if ((node == null) || node.checked)
            return;
        CheckedNodes[checked_nodes++] = node;
        node.checked = true;
        set_bounding_cube(node, x);
        int dim = node.axis;
        double d = node.x[dim] - x[dim];
        if (d * d > d_min)
            {
                if (node.x[dim] > x[dim])
                    check_subtree(node.Left, x);
                else
                    check_subtree(node.Right, x);
            }
        else
            {
                check_subtree(node.Left, x);
                check_subtree(node.Right, x);
            }
    }

    public void set_bounding_cube(KD3DNode node, double[] x)
    {
        if (node == null)
            return;
        int d = 0;
        double dx;
        for (int k = 0; k < 3; k++)
            {
                dx = node.x[k] - x[k];
                if (dx > 0)
                    {
                        dx *= dx;
                        if (!max_boundary[k])
                            {
                                if (dx > x_max[k])
                                    x_max[k] = dx;
                                if (x_max[k] > d_min)
                                    {
                                        max_boundary[k] = true;
                                        n_boundary++;
                                    }
                            }
                    }
                else
                    {
                        dx *= dx;
                        if (!min_boundary[k])
                            {
                                if (dx > x_min[k])
                                    x_min[k] = dx;
                                if (x_min[k] > d_min)
                                    {
                                        min_boundary[k] = true;
                                        n_boundary++;
                                    }
                            }
                    }
                d += dx;
                if (d > d_min)
                    return;
            }
        if (d < d_min)
            {
                d_min = d;
                nearest_neighbour = node;
            }
    }

    public KD3DNode search_parent(KD3DNode parent, double[] x)
    {
        for (int k = 0; k < 3; k++)
            {
                x_min[k] = x_max[k] = 0;
                max_boundary[k] = min_boundary[k] = false; //
            }
        n_boundary = 0;
        KD3DNode search_root = parent;
        while (parent != null && (n_boundary != 3 * 3))
            {
                check_subtree(parent, x);
                search_root = parent;
                parent = parent.Parent;
            }
        return search_root;
    }

    public void uncheck()
    {
        for (int n = 0; n < checked_nodes; n++)
            CheckedNodes[n].checked = false;
    }

    public void inorder()
    {
        inorder(Root);
    }

    private void inorder(KD3DNode root)
    {
        if (root != null)
            {
                inorder(root.Left);
                System.out.print("(" + root.x[0] + ", " + root.x[1] + ", "
                                 + root.x[2] + ")  ");
                inorder(root.Right);
            }
    }

    public void preorder()
    {
        preorder(Root);
    }

    private void preorder(KD3DNode root)
    {
        if (root != null)
            {
                System.out.print("(" + root.x[0] + ", " + root.x[1] + ", "
                                 + root.x[2] + ")  ");
                inorder(root.Left);
                inorder(root.Right);
            }
    }

    public void postorder()
    {
        postorder(Root);
    }

    private void postorder(KD3DNode root)
    {
        if (root != null)
            {
                inorder(root.Left);
                inorder(root.Right);
                System.out.print("(" + root.x[0] + ", " + root.x[1] + ", "
                                 + root.x[2] + ")  ");
            }
    }

    public void search(double x, double y, double z)
    {
        search(Root, x, y, z);
    }

    private void search(KD3DNode root, double x, double y, double z)
    {
        if (root != null)
            {
                search(root.Left, x, y, z);
                if (x == root.x[0] && y == root.x[1] && z == root.x[2])
                    System.out.print("True (" + root.x[0] + ", " + root.x[1] + ", "
                                     + root.x[2] + ")  ");
                search(root.Right, x, y, z);
            }
    }
}

public class KD3D_Search
{
    public static void main(String args[]) throws IOException
    {
        int numpoints = 5;
        Scanner sc = new Scanner(System.in);
        KD3DTree kdt = new KD3DTree(numpoints);
        double x[] = new double[3];
        x[0] = 0.0;
        x[1] = 0.0;
        x[2] = 0.0;
        kdt.add(x);
        x[0] = 3.3;
        x[1] = 1.5;
        x[2] = 4.0;
        kdt.add(x);
        x[0] = 4.7;
        x[1] = 11.1;
        x[2] = 2.3;
        kdt.add(x);
        x[0] = 5.0;
        x[1] = 12.3;
        x[2] = 5.7;
        kdt.add(x);
        x[0] = 5.1;
        x[1] = 1.2;
        x[2] = 4.2;
        kdt.add(x);
        System.out.println("Enter the co-ordinates of the point: <x> <y> <z>");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double z1 = sc.nextDouble();
        kdt.search(x1, y1, z1);
        System.out.println("\nInorder of 2D Kd tree: ");
        kdt.inorder();
        System.out.println("\nPreorder of 2D Kd tree: ");
        kdt.preorder();
        System.out.println("\npostorder of 2D Kd tree: ");
        kdt.postorder();
        sc.close();
    }
}

/*
Enter the co-ordinates of the point: <x> <y> <z>
5.1 1.2 4.2
True (5.1, 1.2, 4.2)
Inorder of 2D Kd tree:
(0.0, 0.0, 0.0)  (5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)
Preorder of 2D Kd tree:
(0.0, 0.0, 0.0)  (5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)
postorder of 2D Kd tree:
(5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)  (0.0, 0.0, 0.0)

Enter the co-ordinates of the point: <x> <y> <z>
5.1 5.2 5.3
False
Inorder of 2D Kd tree:
(0.0, 0.0, 0.0)  (5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)
Preorder of 2D Kd tree:
(0.0, 0.0, 0.0)  (5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)
postorder of 2D Kd tree:
(5.1, 1.2, 4.2)  (3.3, 1.5, 4.0)  (4.7, 11.1, 2.3)  (5.0, 12.3, 5.7)  (0.0, 0.0, 0.0)
