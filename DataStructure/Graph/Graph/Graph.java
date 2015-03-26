package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

public class Graph {
	ArrayList<Node> nodes;
	public Graph() {
		nodes = new ArrayList<Node>();
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public void addNode(Node n) {
		nodes.add(n);
	}

	public void buildRandomGraph(int NodeSize) {
		
		Random random = new Random();

		// Recode the created nodes
		HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();

		// Produce adjacent nodes for each node
		for(int i = 0; i< NodeSize; i++) {

			// Create a new node if not exist in hashmap
			Node NewNode = null;
			if (hashmap.containsKey(i)) {
				NewNode = hashmap.get(i);
			} else {
				NewNode = new Node(i);
			}

			// Create the number of adjacent nodes to the new node
			int AdjacentNodeNum = random.nextInt(NodeSize);
			if(AdjacentNodeNum <= 0) {
				addNode(NewNode); // add a new node to the graph
				continue;
			}

			// Randomly produce a list of adjacent nodes to the new node
			int[] NodeSeq = new int[AdjacentNodeNum];
			for (int j = 0; j < AdjacentNodeNum; j++) {
				NodeSeq[j] = random.nextInt(NodeSize);
			}

			// sort the node sequence
			Arrays.sort(NodeSeq);

			int pre = -1;
			int curr = -1;

			// Create adjacent nodes for the current node
			for(int j = 0; j < AdjacentNodeNum && NodeSeq[j] != i; j++) {

				curr = NodeSeq[j];

				if (curr != pre) {
					if(hashmap.containsKey(curr)) {
						NewNode.addAdjacentNode(hashmap.get(curr));
					} else {
						Node temp = new Node(curr);
						NewNode.addAdjacentNode(temp);
						hashmap.put(curr, temp);
					}
				}
				
				pre = curr;
			}

			// Add a node into graph
			addNode(NewNode);
			if (!hashmap.containsKey(i)) hashmap.put(i, NewNode);
		}
	}

	public void printGraph() {

		if (nodes.size() == 0) {
			System.out.println("Empty Graph!");
			return;
		}

		for(Node n : nodes) {
			System.out.print("Node " + n.data + "'s adjacent nodes :");
			for (Node an : n.AdjacentNodes) {
				System.out.print(" " + an.data);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int GraphSize = 6;
		Graph test = new Graph();
		test.buildRandomGraph(GraphSize);
		test.printGraph();


	}
}
