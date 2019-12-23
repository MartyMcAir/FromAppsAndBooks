/*This is a Java Program to implement 2D KD Tree and find the nearest neighbor for dynamic input set. In computer science, a k-d tree (short for k-dimensional tree) is a space-partitioning data structure for organizing points in a k-dimensional space. k-d trees are a useful data structure for several applications, such as searches involving a multidimensional search key (e.g. range searches and nearest neighbor searches). k-d trees are a special case of binary space partitioning trees.*/

//This is a java program to find nearest neighbor for dynamic data set
import java.io.IOException;
import java.util.Scanner;

class KDN
{
    int axis;
    double[] x;
    int id;
    boolean checked;
    boolean orientation;

    KDN Parent;
    KDN Left;
    KDN Right;

    public KDN(double[] x0, int axis0)
    {
        x = new double[2];
        axis = axis0;
        for (int k = 0; k < 2; k++)
            x[k] = x0[k];
        Left = Right = Parent = null;
        checked = false;
        id = 0;
    }

    public KDN FindParent(double[] x0)
    {
        KDN parent = null;
        KDN next = this;
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

    public KDN Insert(double[] p)
    {
        x = new double[2];
        KDN parent = FindParent(p);
        if (equal(p, parent.x, 2) == true)
            return null;
        KDN newNode = new KDN(p, parent.axis + 1 < 2 ? parent.axis + 1 : 0);
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

class KDTreeDynamic
{
    KDN Root;

    int TimeStart, TimeFinish;
    int CounterFreq;

    double d_min;
    KDN nearest_neighbour;

    int KD_id;

    int nList;

    KDN CheckedNodes[];
    int checked_nodes;
    KDN List[];

    double x_min[], x_max[];
    boolean max_boundary[], min_boundary[];
    int n_boundary;

    public KDTreeDynamic(int i)
    {
        Root = null;
        KD_id = 1;
        nList = 0;
        List = new KDN[i];
        CheckedNodes = new KDN[i];
        max_boundary = new boolean[2];
        min_boundary = new boolean[2];
        x_min = new double[2];
        x_max = new double[2];
    }

    public boolean add(double[] x)
    {
        if (nList >= 2000000 - 1)
            return false; // can't add more points
        if (Root == null)
            {
                Root = new KDN(x, 0);
                Root.id = KD_id++;
                List[nList++] = Root;
            }
        else
            {
                KDN pNode;
                if ((pNode = Root.Insert(x)) != null)
                    {
                        pNode.id = KD_id++;
                        List[nList++] = pNode;
                    }
            }
        return true;
    }

    public KDN find_nearest(double[] x)
    {
        if (Root == null)
            return null;
        checked_nodes = 0;
        KDN parent = Root.FindParent(x);
        nearest_neighbour = parent;
        d_min = Root.distance2(x, parent.x, 2);
        ;
        if (parent.equal(x, parent.x, 2) == true)
            return nearest_neighbour;
        search_parent(parent, x);
        uncheck();
        return nearest_neighbour;
    }

    public void check_subtree(KDN node, double[] x)
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

    public void set_bounding_cube(KDN node, double[] x)
    {
        if (node == null)
            return;
        int d = 0;
        double dx;
        for (int k = 0; k < 2; k++)
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

    public KDN search_parent(KDN parent, double[] x)
    {
        for (int k = 0; k < 2; k++)
            {
                x_min[k] = x_max[k] = 0;
                max_boundary[k] = min_boundary[k] = false; //
            }
        n_boundary = 0;
        KDN search_root = parent;
        while (parent != null && (n_boundary != 2 * 2))
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

}

public class Dynamic_Nearest
{

    public static void main(String args[]) throws IOException
    {
        int numpoints = 10;
        Scanner sc = new Scanner(System.in);
        KDTreeDynamic kdt = new KDTreeDynamic(numpoints);
        double x[] = new double[2];
        System.out.println("Enter the first 10 data set : <x> <y>");
        for (int i = 0; i < numpoints; i++)
            {
                x[0] = sc.nextDouble();
                x[1] = sc.nextDouble();
                kdt.add(x);
            }
        System.out.println("Enter the co-ordinates of the point: <x> <y>");
        double sx = sc.nextDouble();
        double sy = sc.nextDouble();
        double s[] = { sx, sy };
        KDN kdn = kdt.find_nearest(s);
        System.out.println("The nearest neighbor for the static data set is: ");
        System.out.println("(" + kdn.x[0] + " , " + kdn.x[1] + ")");
        sc.close();
    }
}

/*
Enter the first 10 data set :
1.2 3.3
2.3 3.4
4.5 5.6
6.7 7.8
8.9 9.0
10.1 11.3
15.6 19.4
20.5 25.4
52.8 65.3
62.6 56.3

Enter the co-ordinates of the point: <x> <y>
60 34.2

The nearest neighbor for the static data set is:
(62.6 , 56.3)
