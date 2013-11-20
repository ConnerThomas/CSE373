
public class Notes {

	public static void main(String[] args) {
		int cols = 3;
		int rows = 4;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				System.out.println((i * cols) + j);
			}
		}
	}
	
	public int find (int x) {
		if (x > up.length){
			//throw new InvalidElementException();
		}
		int r = x;
		while (up[r] > 0){
			r = up[r];
		}
		if (x==r){
			return r;
		}
		int old_parent = up[x];
		while(old_parent != r) {
			up[x] = r;
			x = old_parent;
			old_parent = up[x];
		}
		return r;
	}

}
