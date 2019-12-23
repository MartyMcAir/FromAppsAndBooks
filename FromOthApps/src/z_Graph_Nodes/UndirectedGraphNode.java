/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.util.ArrayList;

/**
 *
 * @author MartyMcAir
 */
public class UndirectedGraphNode {

    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int label) {
        this.label = label;
    }
}
