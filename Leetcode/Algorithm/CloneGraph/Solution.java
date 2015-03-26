package CloneGraph;

/**
 * Project: Interviews
 * Package: CloneGraph
 * Date: 19/Mar/2015
 * Time: 21:54
 * System Time: 9:54 PM
 */

import Graph.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


    OJ's undirected graph serialization:
    Nodes are labeled uniquely.

    We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    As an example, consider the serialized graph {0,1,2#1,2#2,2}.

    The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

        queue.add(node);
        map.put(node, newHead);

        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pop();
            ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;

            for(UndirectedGraphNode aNeighbor: currNeighbors){
                if(!map.containsKey(aNeighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbor);
                }else{
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }

        }
        return newHead;
    }
}
