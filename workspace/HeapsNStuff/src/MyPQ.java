
public class MyPQ implements PriorityQueue{
	
	private double[] array;
	private int size;
	
	/**
	 * Constructs a unary heap using a default size for the data container
	 */
	public MyPQ(){
		array = new double[10];
		size = 0;
	}
	
	/**
	 * Helper method for resizing the array if it fills up
	 */
	private void resizeArray(){
		double[] newArr = new double[2 * array.length];
		for (int i = 0; i < array.length; i++){
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	
	/**
	 * Returns true if priority queue has no elements
	 *
	 * @return true if the priority queue has no elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}


	/**
	 * Returns the number of elements in this priority queue.
	 *
	 * @return the number of elements in this priority queue.
	 */
	public int size(){
		return size;
	}


	/**
	 * Returns the minimum element in the priority queue
	 *
	 * @return the minimum element 
     * @throws EmptyPQException if priority queue contains no elements
	 */
	public double findMin(){
		if (isEmpty())
			throw new EmptyPQException();
		return array[1];
	}


	/**
	 * Inserts a new element into the priority queue.
	 * Duplicate values ARE allowed.
	 *
	 * @param x element to be inserted into the priority queue.
	 */
	public void insert(double x){
		if (size == array.length - 1)
			resizeArray();
		size++;
		int hole = size;
		while (x <=  array[hole - 1] && hole > 1){
			array[hole] = array[hole - 1];
			hole--;
		}
		array[hole] = x;
	}


	/**
	 * Removes and returns the minimum element from the priority queue.
	 *
	 * @return the minimum element
     * @throws EmptyPQException if priority queue contains no elements
	 */
	public double deleteMin(){
		if (isEmpty())
			throw new EmptyPQException();
		double ans = array[1];
		for (int i = 1; i <= size; i++){
			array[i] = array[i + 1];
		}
		size--;
		return ans;
	}


	/**
	 * Resets the priority queue to appear as not containing
	 * any elements.
	 */
	public void makeEmpty(){
		size = 0;
	}
}
