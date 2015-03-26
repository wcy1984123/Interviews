package TopologicalSorting;

/**
 * Project: Interviews
 * Package: TopologicalSorting
 * Date: 18/Mar/2015
 * Time: 20:07
 * System Time: 8:07 PM
 */

/*
    Given an directed graph, a topological order of the graph nodes is defined as follow:

    For each directed edge A-->B in graph, A must before B in the order list.
    The first node in the order can be any node in the graph with no nodes direct to it.
    Find any topological order for the given graph.
    Note
    You can assume that there is at least one topological order in the graph.
    Example
    For graph as follow:

    The topological order can be:

    [0, 1, 2, 3, 4, 5]

    or

    [0, 2, 3, 1, 5, 4]

    or

    ....



    Challenge
    Can you do it in both BFS and DFS?
 */

import Graph.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return res;
        }

        Stack<DirectedGraphNode> st = new Stack<DirectedGraphNode>();
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!visited.contains(node)) {
                visit(st, node, visited);
            }
        }

        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        return res;
    }

    public void visit(Stack<DirectedGraphNode> st, DirectedGraphNode node, Set<DirectedGraphNode> visited) {
        visited.add(node);

        for (DirectedGraphNode neb : node.neighbors) {
            if (!visited.contains(neb)) {
                visit(st, neb, visited);
            }
        }

        st.push(node);
    }

}
