/* Conner Thomas
 * Nick Morello
 * CSe 373
 * Homework 5
 * 
 * This homework implements a graph and uses dijkstra's algorithm
 * to find the shortest path from one starting vertex to any other vertex
 * 
 */

/**
 * Representation of a graph vertex
 */
public class Vertex {
	private final String label;   // label attached to this vertex
	public boolean known;
	public int distance;
	public Vertex path;

	/**
	 * Construct a new vertex
	 * @param label the label attached to this vertex
	 */
	public Vertex(String label) {
		this(label, false, Integer.MAX_VALUE, null);
	}
	
	public Vertex(String label, boolean known, int distance, Vertex path) {
		if(label == null)
			throw new IllegalArgumentException("null");
		this.label = label;
		this.known = known;
		this.distance = distance;
		this.path = path;
	}

	/**
	 * Get a vertex label
	 * @return the label attached to this vertex
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * A string representation of this object
	 * @return the label attached to this vertex
	 */
	public String toString() {
		return label;
	}

	//auto-generated: hashes on label
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	//auto-generated: compares labels
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Vertex other = (Vertex) obj;
		if (label == null) {
                    return other.label == null;
		} else {
		    return label.equals(other.label);
		}
	}


}
