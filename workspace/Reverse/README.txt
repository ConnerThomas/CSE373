Conner Thomas
CSE 373

1. I used a separate project to test the basic functionality of the structures, then
	tried the Revers program, and it worked perfectly for both implementations
	
2. "the scent of bitter almonds always reminded him of the fate of unrequited love"

3. You would solve 2^n => (max size). Solving this yields 20 for 1 million, 
	30 for 1 billion, and 40 for 1 trillion, wish leftover space as it is approximate
	
4. 
new queue q1
new queue q2
push (number)
	enqueue number to q1
pop
	check if q1 is empty
	for 1 less than q1.size
		move each item to q2
	number to return= last item in q1
	newq = q1
	q1= q2
	q2 = q1
	return the number stored earlier
	
5. The pop method (or push, depending on how you code it) is very costly in the 
	queue implementation while the array and linked lists are not very expensive.
	I would choose to use the array one over the queue.
	
6. My array implementation cuts the size of the array in half when the array is 1/4 full 
	or less.
	
7. I did find it somewhat enjoyable to have all the java knowledge
	I had from when I took CSe 142/143 come back so quickly when I started
	this assignment. I probably could have optimized a bit more but I haven't written java in a long time, so I've forgotten some of the finer details that I used to know.
	
8. n/a