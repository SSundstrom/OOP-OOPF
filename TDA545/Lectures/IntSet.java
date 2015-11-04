public class IntSet {
	private int[] a;
	public IntSet(int[] content) {
		if (content == null) {
				a = new int[0];
		} else {
			int j = 0;
			a = new int[content.length];
			for (int i : content) {
				a[j] = i;
				j++;
			} 
		}
	}
	public boolean hasInt(int n) {
		for (int i : this.a) {
			if (i == n) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] a = {2,6,1,7,9,2,34,7};
		//int[] a = null;
		IntSet s = new IntSet(a);
		System.out.println("s.hasint(0) = " + s.hasInt(0));
		System.out.println("s.hasint(2) = " + s.hasInt(2));
		
	}
}