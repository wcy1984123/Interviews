package CtCILibrary;

public class BitVector {
	private static int DATA_SIZE = 32; // there are totally 32 bits in the integer in Java.
	private int length;
	private int[] vector;
	
	public BitVector(int length) {
		this.length = length;
		if (length % DATA_SIZE == 0) {
			vector = new int[length / DATA_SIZE];
		} else {
			vector = new int[length / DATA_SIZE + 1];
		}
	}
	
	public int length() {
		return length;
	}

	/**
	 * Check if the ith position in the bit vector is set or not.
	 * @param i the ith position in the bit vector
	 * @return true if the ith position is 1, otherwise 0
	 */
	public boolean get(int i) {
		int b = vector[i / DATA_SIZE];
		int bit_index = i % DATA_SIZE;
		//00100010
		if (((b >> bit_index) & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void print() {
		for (int k : vector) {
			for (int i = 0; i < DATA_SIZE; i++) {
				if ((k >> i & 1) == 1) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	/**
	 * set to 1 or clear to 0
	 * @param i the ith position in the bit vector
	 * @param flag set or clear in terms of the flag value
	 */
	public void set(int i, boolean flag) {
		if (i >= 0 && i < length) {
			int mask = ~(1 << i);
			int b = vector[i / DATA_SIZE] & mask;
			if (flag) { // set to 1
				vector[i / DATA_SIZE] = b | (1 << i);
			} else { // clear to 0
				vector[i / DATA_SIZE] = b;
			}
		}
	}
}
