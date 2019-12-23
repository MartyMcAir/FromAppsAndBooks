/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author MartyMcAir
 */
// Java Algorithms - Android Apps
// https://play.google.com/store/apps/details?id=com.izaron.pepperpied
public class GraphClassTemplate {

    public Map<Integer, Set<Integer>> edges = new TreeMap<>();

    public void addNode(int u) {
        if (!edges.containsKey(u)) {
            edges.put(u, new TreeSet<Integer>());
        }
    }

    public void removeNode(int u) {
        if (!edges.containsKey(u)) {
            return;
        }
        for (int v : edges.get(u)) {
            edges.get(v).remove(u);
        }
        edges.remove(u);
    }

    public void addEdge(int u, int v) {
        edges.get(u).remove(v);
        edges.get(v).remove(u);
    }

    public void removeEdge(int u, int v) {
        edges.get(u).remove(v);
        edges.get(v).remove(u);
    }

    // Usage Example
    public static void main(String[] args) {
        GraphClassTemplate g = new GraphClassTemplate();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        System.out.println(g.edges);
        g.removeEdge(1, 0);
        System.out.println(g.edges);
        g.removeNode(1);
        System.out.println(g.edges);
    }
}
