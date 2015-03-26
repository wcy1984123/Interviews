package DFS;

import Graph.Node;
import Graph.Status;
import Graph.Graph;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: DFS
 * Date: 22/Mar/2015
 * Time: 00:24
 * System Time: 12:24 AM
 */

/*
    Depth first search in general graph.
 */

public class Solution {

    public void dfsNode(Node EachNode) {


        if (EachNode.getStatus() == Status.UNVISIT) {

            EachNode.setStatus(Status.VISITING);

            System.out.print(EachNode.getData() + " ");

            ArrayList<Node> AdjacentNodes = EachNode.getAdjacentNodes();

            for (int j = 0; j < AdjacentNodes.size(); j++) {
                Node EachAdjacentNode = AdjacentNodes.get(j);

                if (EachAdjacentNode.getStatus() == Status.UNVISIT) {
                    dfsNode(EachAdjacentNode);
                }
            }

            EachNode.setStatus(Status.VISITED);
        }
    }

    public void dfsGraph(Graph g) {
        if (g == null) return;

        ArrayList<Node> nodes = g.getNodes();

        int count = 0;

        for (int i = 0; i < nodes.size(); i++) {

            Node EachNode = nodes.get(i);
            if(EachNode.getStatus() == Status.UNVISIT) {
                System.out.println("The " +  ++count + "th component in the graph : ");
                dfsNode(EachNode);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int GraphSize = 5;
        Graph g = new Graph();
        g.buildRandomGraph(GraphSize);
        g.printGraph();

        Solution test = new Solution();
        test.dfsGraph(g);
    }
}
