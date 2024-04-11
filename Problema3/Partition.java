package Problema3;


public class Partition {
	private int n;
	private int[] parents;
	
	
	public Partition (int n) {
		this.n = n;
		parents = new int[n];
		for (int i = 0; i<n;i++) {
			parents[i]=i;
		}
	}
	
	public void union (int e1, int e2) {
		int s1 = find(e1);
		int s2 = find(e2);
		if(s1==s2) return;
		parents[s2] = s1;
	}
	
	public int find (int e) {
		if (parents[e]== e) return e;
		int subset = find(parents[e]);
		return subset;
	}
	
	public boolean sameSubsets(int e1, int e2) {
		return find(e1)==find(e2);
	}
}
