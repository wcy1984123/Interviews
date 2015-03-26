package TopologicalSort;

import Graph.Node;
import Graph.Status;
import Graph.Graph;

import java.util.List;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: TopologicalSort
 * Date: 22/Mar/2015
 * Time: 00:26
 * System Time: 12:26 AM
 */

/*
    Implement topological sort in general graph.
 */

public class Solution {

    public void topologicalSortingHelper(Node node, Stack<Node> stack) {

        node.setStatus(Status.VISITED);

        List<Node> adjacentNodes = node.getAdjacentNodes();

        for (Node eachNode : adjacentNodes) {
            if (eachNode.getStatus() == Status.UNVISIT) {
                topologicalSortingHelper(eachNode, stack);
            }
        }

        stack.push(node);
    }

    public void topologicalSorting(Graph g) {
        if (g == null) return;

        Stack<Node> stack = new Stack<Node>();

        List<Node> nodes = g.getNodes();

        if (nodes.size() == 0) return;

        for (Node node : nodes) {
            if (node.getStatus() == Status.UNVISIT) topologicalSortingHelper(node, stack);
        }

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getData() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int GraphSize = 5;
        Graph g = new Graph();
        g.buildRandomGraph(GraphSize);
        g.printGraph();

        Solution test = new Solution();
        test.topologicalSorting(g);
    }
}
