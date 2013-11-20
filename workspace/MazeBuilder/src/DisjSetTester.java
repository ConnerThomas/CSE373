
public class DisjSetTester {

	public static void main(String[] args) {
		int NumElements = 128;
	    int NumInSameSet = 16;

	    DisjointSets dj = new MyDisjSets(NumElements);
	    int set1, set2;

	    for (int k = 1; k < NumInSameSet; k *= 2) {
	      for (int j = 0; j + k < NumElements; j += 2 * k) {
	        set1 = dj.find(j);
	        set2 = dj.find(j + k);
	        dj.union(set1, set2);
	      }
	    }

	    for (int i = 0; i < NumElements; i++) {
	      System.out.print(dj.find(i) + "-");
	      if (i % NumInSameSet == NumInSameSet - 1) {
	        System.out.println();
	      }
	    }
	    System.out.println();

	}

}
