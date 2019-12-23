/*This is a Java Program to check whether a polygon contains another polygon or not. The class returns true if one polygon contains another, false otherwise.*/

//This is a java program to test whether a polygon is inside another polygon
class Point
{
    int x, y;

    Point()
    {
    }

    Point(int p, int q)
    {
        x = p;
        y = q;
    }
}

public class Position_Point_WRT_Polygon
{

    public static boolean onSegment(Point p, Point q, Point r)
    {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        return false;
    }

    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2)
    {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4)
            return true;
        if (o1 == 0 && onSegment(p1, p2, q1))
            return true;
        if (o2 == 0 && onSegment(p1, q2, q1))
            return true;
        if (o3 == 0 && onSegment(p2, p1, q2))
            return true;
        if (o4 == 0 && onSegment(p2, q1, q2))
            return true;
        return false;
    }

    public static boolean isInside(Point polygon[], int n, Point p)
    {
        int INF = 10000;
        if (n < 3)
            return false;
        Point extreme = new Point(INF, p.y);
        int count = 0, i = 0;
        do
            {
                int next = (i + 1) % n;
                if (doIntersect(polygon[i], polygon[next], p, extreme))
                    {
                        if (orientation(polygon[i], p, polygon[next]) == 0)
                            return onSegment(polygon[i], p, polygon[next]);
                        count++;
                    }
                i = next;
            }
        while (i != 0);
        return (count & 1) == 1 ? true : false;
    }

    public static Boolean DoesPolygonContainPolygon(Point[] p1, Point[] p2)
    {
        Point p;
        for (int i = 0; i < p2.length; i++)
            {
                p = new Point(p2[i].x, p2[i].y);
                if (!isInside(p1, p1.length, p))
                    return false;
            }
        return true;
    }

    public static void main(String args[])
    {
        Point polygon1[] = { new Point(0, 0), new Point(10, 0),
                  new Point(10, 10), new Point(0, 10)
        };
        Point polygon2[] = { new Point(0, 0), new Point(15, 5), new Point(5, 0) };
        Point polygon3[] = { new Point(0, 0), new Point(10, 0),
                  new Point(10, 10), new Point(0, 10), new Point(5, 5)
        };
        System.out.println("Polygon 1 contains Polygon 2 :"
                           + DoesPolygonContainPolygon(polygon1, polygon2));
        System.out.println("Polygon 3 contains Polygon 1 :"
                           + DoesPolygonContainPolygon(polygon3, polygon1));
    }
}


/*
Polygon 1 contains Polygon 2 :false
Polygon 3 contains Polygon 1 :true
