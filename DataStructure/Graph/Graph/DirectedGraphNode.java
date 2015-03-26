package Graph;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: Graph
 * Date: 19/Mar/2015
 * Time: 01:14
 * System Time: 1:14 AM
 */

public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
