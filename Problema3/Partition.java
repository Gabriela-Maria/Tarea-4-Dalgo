package Problema3;

/**
 * Implementation of a structure to store partitions of the numbers from 0 to n-1
 * It corresponds to the structures named disjoint sets or union-find 
 */
public class Partition {
	private int n;
	private int[] parents;
	
	
	/**
	 * Builds a new partition for n elements.
	 * Assigns each element to a different subset
	 * @param n Number of elements to consider
	 */
	public Partition (int n) {
		this.n = n;
		parents = new int[n];
		for (int i = 0; i<n;i++) {
			parents[i]=i;
		}
	}
	/**
	 * Modifies the partition merging into a single subset the parents to which the given elements belong
	 * If the two elements belong to the same subset it leaves the structure unchanged
	 * @param e1 Element belonging to the first subset. 0<=e1<n
	 * @param e2 Element belonging to the second subset. 0<=e2<=n
	 */
	public void union (int e1, int e2) {
		int s1 = find(e1);
		int s2 = find(e2);
		if(s1==s2) return;
		parents[s2] = s1;
	}
	/**
	 * Returns the identifier of the subset to which the given element belongs
	 * @param e Element to find. 0<=e<n
	 * @return int Subset to which the element belongs
	 */
	public int find (int e) {
		if (parents[e]== e) return e;
		int subset = find(parents[e]);
		return subset;
	}
	/**
	 * Determines if the two elements belong to the same subset.
	 * @param e1 First element
	 * @param e2 Second element
	 * @return boolean true if e1 and e2 belong to the same subset. False otherwise
	 */
	public boolean sameSubsets(int e1, int e2) {
		return find(e1)==find(e2);
	}
}
