/* Conner Thomas
 * Nick Morello
 * CSe 373
 * Homework 5
 * 
 * This homework implements a graph and uses dijkstra's algorithm
 * to find the shortest path from one starting vertex to any other vertex
 * 
 */
import java.util.List;

public class Path {
    // we use public fields fields here since this very simple class is
    // used only for returning multiple results from shortestPath
    public final List<Vertex> vertices;
    public final int cost;
    
    public Path(List<Vertex> vertices, int cost) {
	this.vertices = vertices;
	this.cost = cost;
    }
}
