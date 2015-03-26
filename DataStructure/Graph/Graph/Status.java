package Graph;

public enum Status {
	UNVISIT(1), VISITING(0), VISITED(2);
	
	private int value;
	
	private Status(int value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		System.out.println(Status.UNVISIT.ordinal());
		System.out.println(Status.VISITED.ordinal());
		System.out.println(Status.VISITING.ordinal());
	}
}
