package Problema3;

public class UndirectedWeightedEdge {
	private int v1;
	private int v2;
	private int weight;
	public UndirectedWeightedEdge(int v1, int v2, int weight) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	public int getV1() {
		return v1;
	}
	public int getV2() {
		return v2;
	}
	public int getWeight() {
		return weight;
	}

    public String toString() {
        return String.format("(%d-%d, %d)", v1, v2, weight);
    }

    public String toStringNoWeight() {
        return String.format("(%d-%d)", v1, v2);
    }
	
}
