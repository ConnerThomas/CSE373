
public class BinaryHeap implements PriorityQueue  {
	
	private double[] array; // our method of storing the data uses an array
	private int currentSize; // keep track of the number of nodes in the binary heap
	
	/**
	 * Constructs a binary heap using a default size for the data container
	 */
	public BinaryHeap(){
		array = new double[10];
		currentSize = 0;
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
		return currentSize == 0;
	}

	
	/**
	 * Returns the number of elements in this priority queue.
	 *
	 * @return the number of elements in this priority queue.
	 */
	public int size(){
		return currentSize;
	}


	/**
	 * Returns the minimum element in the priority queue
	 *
	 * @return the minimum element 
     * @throws EmptyPQException if priority queue contains no elements
	 */
	public double findMin() throws EmptyPQException{
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
		if (currentSize == array.length - 1){
			resizeArray();
		}
		currentSize++;
		int i = percolateUp(currentSize, x);
		array[i] = x;			
	}
	
	/**
	 * Helper method that determines where a value should be inserted
	 * 
	 * @return the index in the array that the new value should be placed
	 */
	private int percolateUp(int hole, double val){
		while(hole > 1 && val < array[hole / 2]){
			array[hole] = array[hole / 2];
			hole = hole / 2;
		}
		return hole;
	}

	/**
	 * Removes and returns the minimum element from the priority queue.
	 *
	 * @return the minimum element
     * @throws EmptyPQException if priority queue contains no elements
	 */
	public double deleteMin() throws EmptyPQException{
		if (isEmpty())
			throw new EmptyPQException();
		double ans = array[1];
		int hole = percolateDown(1, array[currentSize]);
		array[hole] = array[currentSize];
		currentSize--;
		return ans;
	}

	/**
	 * Helper method that rearranges the array to account for deleting 
	 * the minimum value at the 'top' of the heap
	 * 
	 * @return the 
	 */
	private int percolateDown(int hole, double val) {
		int target;
		int left;
		int right;
		while (2 * hole < currentSize){
			left = 2 * hole;
			right = left + 1;
			if (array[left] < array[right] || right > currentSize){
				target = left;
			}else{
				target = right;
			}
			if (array[target] < val){
				array[hole] = array[target];
				hole = target;
			}else{
				break;
			}
		}
		return hole;
	}

	/**
	 * Resets the priority queue to appear as not containing
	 * any elements.
	 */
	public void makeEmpty(){
		currentSize = 0;
	}
}
