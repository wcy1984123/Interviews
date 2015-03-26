package Graph;

import java.util.ArrayList;

public class Node {

	
	int data;
	ArrayList<Node> AdjacentNodes;
	Status status;
	
	public Node(int data) {
		this.data = data;
		this.AdjacentNodes = new ArrayList<Node>();
		this.status = Status.UNVISIT;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ArrayList<Node> getAdjacentNodes() {
		return AdjacentNodes;
	}
	
	public void addAdjacentNode(Node n) {
		AdjacentNodes.add(n);
	}
	
	public Status getStatus() {
		return status;
	}
	
}
