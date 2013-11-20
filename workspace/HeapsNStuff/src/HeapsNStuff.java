
public class HeapsNStuff {

	public static void main(String[] args) {
			
			// ********** Tests to make sure insert, deleteMin, and resizing all work**********
			PriorityQueue PQTest1 = new MyPQ();		
			for (double i = 1.0; i < 100; i++){
				PQTest1.insert(Math.random() + 1);
			}
			for (int i = 1; i < 25; i++){
				System.out.println(PQTest1.deleteMin());
			}
			
			System.out.println();
			
			// ********** Tests to make sure exceptions throw correctly **********
			PriorityQueue PQTest2 = new MyPQ();
			for (double i = 1.0; i < 5; i++){
				PQTest2.insert(Math.random() + 1);
			}
			for (int i = 1; i < 5; i++){ // make x for i < x more than 5 to throw
				System.out.println(PQTest2.deleteMin());
			}
			
			// ********** Tests to make sure isEmpty, size, makeEmpty works correctly **********
			PriorityQueue PQTest3 = new MyPQ();
			for (double i = 1.0; i < 10; i++){
				PQTest3.insert(Math.random() + 1);
			}
			System.out.println(PQTest3.isEmpty());
			System.out.println(PQTest3.size());
			PQTest3.makeEmpty();
			System.out.println(PQTest3.isEmpty());
			System.out.println(PQTest3.size());
			System.out.println();
			
			// ********** Tests timing **********
			int[] nVals = new int[4];
			nVals[0] = 100;
			nVals[1] = 200;
			nVals[2] = 300;
			nVals[3] = 400;
			// Test insert
			for (int j = 0; j <= 3; j++){
				for(int timing = 0; timing < 3; ++timing) {
		            long startTime = System.nanoTime();
		            // ... start code being timed ...
		            int n = nVals[j];
		            PriorityQueue PQTime1 = new MyPQ();		
					for (double i = 1.0; i < n; i++){
						PQTime1.insert(Math.random() + 1);
					}	            
					// ... end code being timed ...
		            long endTime = System.nanoTime();
		            long elapsedTime = endTime - startTime;
		            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed for insert() when n = " + n);
				}
				System.out.println();
			}
			
			System.out.println();
			
			// Test deleteMin
			for (int j = 0; j <= 3; j++){
				for(int timing = 0; timing < 3; ++timing) {
					int n = nVals[j];
					PriorityQueue PQTime = new MyPQ();		
					for (double i = 1.0; i < n; i++){
						PQTime.insert(Math.random() + 1);
					}	
		            long startTime = System.nanoTime();
		            // ... start code being timed ...		
					for (int i = 1; i < n; i++){
						PQTime.deleteMin();
					}	            
					// ... end code being timed ...
		            long endTime = System.nanoTime();
		            long elapsedTime = endTime - startTime;
		            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed for deleteMin() when n = " + n);
				}
				System.out.println();
			}
			
			System.out.println();
	}

}
