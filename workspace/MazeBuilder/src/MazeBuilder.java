/* Conner Thomas
 * CSE 373
 * Homework 4
 * 
 * Programs that uses my MyDisjSets implementation to generate a maze
 * whose size can be set by the user
 * 
 */
import java.io.*;
import java.util.*;

public class MazeBuilder {
	
	public static void main(String[] args) throws FileNotFoundException{
			
		int cols;
		int rows;
		String outputFilename;
		int[] walls;
		int[] floors;
		

		try {
		
		// Make sure commands are kosher
		if (args.length != 3){
			System.err.println(" Incorrect number of arguments");
            System.err.println(" Usage: ");
            System.err.println("\tjava MazeBilder <height> <width> <output file>");
            System.exit(1);
		}
		
		// Read in command line arguments for height and weight and output filename
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
		outputFilename = args[2];
		
		// Zeros are not allowed!
		if (rows * cols == 0){
			System.err.println(" Incorrect argument for size");
            System.err.println(" both the height and width must be nonzero. ");
            System.exit(1);
		}
				
		// Make an arraylist for the edges based on height and width and fill it up
		ArrayList<int[]> edges = new ArrayList<int[]>();
		fillEdgeList(edges, rows, cols);		
		
		// Initialize arrays that will hold discarded edges
		walls = new int[rows * cols];
		floors = new int[rows * cols];
		
		// Do some pre setting of values to print easier
		for (int i = rows * cols - 1; i > rows * cols - 1 - cols; i--){
			floors[i] = 1;
		}
		for (int i = cols - 1; i < rows * cols; i += cols){
			walls[i] = 1;
		}
		walls[rows * cols - 1] = 0; // maze exit
		
		// Create disjoint set for the cells
		DisjointSets cells = new MyDisjSets(rows * cols);		
		
		// BUILD THE MAZE!!
		buildMaze(edges, cells, walls, floors);
				
		// Transfer all the edges left in the ArrayList over to the floors/walls arrays
		xferEdges(edges, walls, floors);
				
		// Print out maze to text file
		printMaze(outputFilename, rows, cols, walls, floors);
			
		// Some testing output shit
		System.out.println(rows + " by " + cols);
		System.out.println("Output file is: " + outputFilename);
		
		//Error check output file
		} catch(IOException ioe) {
            System.err.println("Error opening/reading/writing input or output file.");
            System.exit(1);
        } catch(NumberFormatException nfe) {
            System.err.println(nfe.toString());
            System.err.println("Error in file format");
            System.exit(1);
        }
		
	}
	
	/*
	 * This method handles printing the maze to a file
	 * 
	 * @param outputFilename the name of the file to contain the maze
	 * @param rows the number of rows in the maze
	 * @param cols the number of columns in the maze
	 * @param walls the array that hold which cells have right side walls
	 * @param floors the array that hold which cells have floors
	 * @throws FileNotFoundException if the output file is not found
	 */
	private static void printMaze(String outputFilename, int rows, int cols, int[] walls, int[] floors) throws FileNotFoundException{
		// Creates a printstream to write to the specified output file
		PrintStream output = new PrintStream(new File(outputFilename));
		
		// Start by printing the top of the maze to the file
		output.print("+");
		for (int i = 0; i < cols; i++){
			output.print("-+");
		}
		output.println();
		// Then start printing rows
		for (int i = 0; i < rows; i++){
			
			//left side wall
			if (i == 0)
				output.print(" ");
			else
				output.print("|");
			
			// walls		
			for (int j = 0; j < cols; j++){
				output.print(" ");
				if (walls[(i * cols) + j] == 1)
					output.print("|");
				else
					output.print(" ");
			}
			
			output.println();
			output.print("+"); // There's way too goddamn much fenceposting in this method
			
			// floors
			for (int j = 0; j < cols; j++){
				if (floors[(i * cols) + j] == 1)
					output.print("-");
				else
					output.print(" ");
				output.print("+");
			}
			
			output.println();			
		}
		output.close();
	}
	
	/*
	 * This method transfers all of the remaining edges in the set of unused edges
	 * to an array so that it is easier to print from
	 * 
	 * @param outputFilename the name of the file to contain the maze
	 * @param walls the array that hold which cells have right side walls
	 * @param floors the array that hold which cells have floors
	 */
	private static void xferEdges (ArrayList<int[]> edges, int[] walls, int[] floors){
		while (edges.size() > 0){
			int[] edge = edges.get(0);
			edges.remove(0);
			if (edge[1] == edge[0] + 1)  // if it's a wall
				walls[edge[0]] = 1;
			else 						 // if it's a floor
				floors[edge[0]] = 1;
		}
	}
	
	/*
	 * This method fills the ArrayList with all the possible inner edges in the maze
	 * 
	 * @param edges the ArrayList<int[]> that holds all the inner edges of the maze
	 * @param rows the number of rows in the maze
	 * @param cols the number of columns in the maze
	 */
	private static void fillEdgeList(ArrayList<int[]> edges, int rows, int cols){
		// there should be (2*rows*cols + rows - cols) # of edges
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				int val = j + cols * i;
				if ((val + 1) % cols != 0){		 // if it's not the right edge
					int[] temp1 = {val, val + 1};
					edges.add(temp1);
				}
				if ((rows * cols) - val > cols){ // if it's not the bottom row
					int[] temp2 = {val, val + cols};
					edges.add(temp2);
				}
				
			}
		}
	}
	
	/*
	 * This method manipulates the edges set and the union-find set to generate a tree-like
	 * maze structure.
	 * 
	 * @param edges the ArrayList<int[]> that holds all the inner edges of the maze
	 * @param cells the union-find disjoint set that holds the tree-like structure of the maze
	 * @param rows the number of rows in the maze
	 * @param cols the number of columns in the maze
	 */
	private static void buildMaze (ArrayList<int[]> edges, DisjointSets cells, int[] walls, int[] floors){
		Random rand = new Random();
		while (cells.numSets() > 1){
			int index = rand.nextInt(edges.size());
			int[] randEdge = edges.get(index);
			edges.remove(index);
			int u = cells.find(randEdge[0]);
			int v = cells.find(randEdge[1]);
			if (u != v){
				cells.union(u, v);
			}else{
				if (randEdge[1] == randEdge[0] + 1) // if it's a wall
					walls[randEdge[0]] = 1;
				else								 // if it's a floor
					floors[randEdge[0]] = 1;
			}
		}
	}
	

}
