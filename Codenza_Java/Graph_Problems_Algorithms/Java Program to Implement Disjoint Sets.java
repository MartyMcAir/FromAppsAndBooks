/*This Java program is to Implement Disjoint Sets. A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (nonoverlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
Find: Determine which subset a particular element is in.This can be used for determining if two elements are in the same subset.
Union: Join two subsets into a single subset.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisjointSets
{
    private List<Map<Integer, Set<Integer>>> disjointSet;

    public DisjointSets()
    {
        disjointSet = new ArrayList<Map<Integer, Set<Integer>>>();
    }

    public void create_set(int element)
    {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(element);
        map.put(element, set);
        disjointSet.add(map);
    }

    public void union(int first, int second)
    {
        int first_rep = find_set(first);
        int second_rep = find_set(second);
        Set<Integer> first_set = null;
        Set<Integer> second_set = null;
        for (int index = 0; index < disjointSet.size(); index++)
            {
                Map<Integer, Set<Integer>> map = disjointSet.get(index);
                if (map.containsKey(first_rep))
                    {
                        first_set = map.get(first_rep);
                    }
                else if (map.containsKey(second_rep))
                    {
                        second_set = map.get(second_rep);
                    }
            }
        if (first_set != null && second_set != null)
            first_set.addAll(second_set);
        for (int index = 0; index < disjointSet.size(); index++)
            {
                Map<Integer, Set<Integer>> map = disjointSet.get(index);
                if (map.containsKey(first_rep))
                    {
                        map.put(first_rep, first_set);
                    }
                else if (map.containsKey(second_rep))
                    {
                        map.remove(second_rep);
                        disjointSet.remove(index);
                    }
            }
        return;
    }

    public int find_set(int element)
    {
        for (int index = 0; index < disjointSet.size(); index++)
            {
                Map<Integer, Set<Integer>> map = disjointSet.get(index);
                Set<Integer> keySet = map.keySet();
                for (Integer key : keySet)
                    {
                        Set<Integer> set = map.get(key);
                        if (set.contains(element))
                            {
                                return key;
                            }
                    }
            }
        return -1;
    }

    public int getNumberofDisjointSets()
    {
        return disjointSet.size();
    }

    public static void main(String... arg)
    {
        DisjointSets disjointSet = new DisjointSets();
        for (int i = 1; i <= 5; i++)
            {
                disjointSet.create_set(i);
            }
        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++)
            {
                System.out.println(i + "\t:\t" + disjointSet.find_set(i));
            }
        disjointSet.union(1, 5);
        disjointSet.union(5, 3);
        System.out.println("\nThe Representative keys after performing the union operation\n");
        System.out.println("Union of (1 and 5)  and (5 and 3) ");
        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++)
            {
                System.out.println(i + "\t:\t" + disjointSet.find_set(i));
            }
        System.out.println("\nThe number of disjoint set : " + disjointSet.getNumberofDisjointSets());
    }
}

/*
ELEMENT : REPRESENTATIVE KEY
1	:	1
2	:	2
3	:	3
4	:	4
5	:	5

The Representative keys after performing the union operation
Union of (1 and 5)  and (5 and 3)

ELEMENT : REPRESENTATIVE KEY
1	:	1
2	:	2
3	:	1
4	:	4
5	:	1

The number of disjoint set : 3
