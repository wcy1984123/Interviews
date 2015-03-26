package Graph;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: Graph
 * Date: 19/Mar/2015
 * Time: 21:55
 * System Time: 9:55 PM
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        this.label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
