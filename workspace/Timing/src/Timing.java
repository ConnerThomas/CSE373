class Timing {
    public static final int NUM_TIMINGS = 5;
    public static void main(String[] args) {
        for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
            long startTime = System.nanoTime();
            // ... start code being timed ...
            int n = 1000;
            
            
            
			// ... end code being timed ...
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }
}