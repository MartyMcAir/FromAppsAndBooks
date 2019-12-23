/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MartyMcAir
 */
// from https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Apas
public class Tmp1 {
    ///////////////////////////////////  Count Complete Tree Nodes
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = fullTreeHeight(root.left);
        int rightHeight = fullTreeHeight(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int fullTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }
    
    ///// delete node _ ListNode
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /////////////////////////////// Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    ///////////////////////////// Clone Graph
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> cloned) {
        if (cloned.containsKey(node.label)) {
            return cloned.get(node.label);
        }
        cloned.put(node.label, new UndirectedGraphNode(node.label));
        for (int i = 0; i < node.neighbors.size(); i++) {
            cloned.get(node.label).neighbors.add(dfs(node.neighbors.get(i), cloned));
        }
        return cloned.get(node.label);
    }

    ////////////////////////////////////// number of Connected Components 
    // in Undirected Graph
    private int[] id;

    public int countComponents(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        // Initialize id
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        // Build connected components
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        //
        for (int i = 0; i < n; i++) {
            set.add(root(i)); // O(n^2)
        }
        return set.size();
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    ///////////////////////////////////// Lexicographical Numbers
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int curr, int n, List<Integer> res) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        for (int i = 0; i < 10; i++) {
            int next = 10 * curr + i;
            if (next > n) {
                return;
            }
            dfs(next, n, res);
        }
    }

    /////////////////////// Graph Valid Tree
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) { // Quick check on the number of edges. It requires n - 1 edges to connect n vertices.
            return false;
        }
        // Init CC id array.
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // Check cycle.
        for (int[] edge : edges) {
            // Find connected component ids of the two nodes.
            int r1 = find(ids, edge[0]);
            int r2 = find(ids, edge[1]);
            if (r1 == r2) { // If two vertices are already connected, there is a cycle.
                return false;
            }
            // Union the 2 nodes.
            ids[r1] = r2; // Add edges[i][0] to one connected component.
        }
        return true;
    }

    private int find(int ids[], int i) {
        while (i != ids[i]) {
            // Here if we found the child''s id are not the same as the parent''s.
            // We know the parent can be an intermediate id.
            // So we set parent''s id to grand parent''s id.
            // Which will dynamically balance the tree thus reducing O(n) to O(1).
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
}
