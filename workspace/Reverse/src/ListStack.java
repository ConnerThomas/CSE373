/**
 * Conner Thomas
 * CSE 373
 * 10-1-2013
 * 
 * Implementation of a stack for doubles using a form of 
 * Linked List Nodes
 */

import java.util.EmptyStackException;

public class ListStack implements DStack {
	
	private ListStackNode front = null;
	private int elements = 0;

	/** 
	 * isEmpty checks if the stack is empty or not
     * @return true if stack is empty, false if stack is not
     */
	public boolean isEmpty() {
		return elements == 0;
	} 
	
	/**
     * push adds a value to the top of the stack
     */
	public void push (double d) {
		ListStackNode newFront = new ListStackNode(d, front);
		front = newFront;
		elements++;
	}
	
	/**
     * pop takes the value at the top of the stack, returns it and deletes it from the stack
     * @return the deleted value
     * @throws EmptyStackException if stack is empty
     */	
	public double pop() {
		double d;
		if (this.isEmpty())
			throw new EmptyStackException();
		else
			d = front.data;
			front = front.next;
			elements--;
			return d;
	}
		
	/**
     * peek returns the value at the top of the stack and does not delete it as pop does
     * @return the value at the top of the stack
     * @throws EmptyStackException if stack is empty
     */
	public double peek() {
		if (this.isEmpty())
			throw new EmptyStackException();
		else
			return front.data;
	}
}
