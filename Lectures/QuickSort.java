public class QuickSort{


	public static void swap(int[] a, int i, int j) {	
		int xi = a[i];
		int xj = a[j];
		a[j] = xi;
		a[i] = xj;
	}

	public static int partition(int[] a, int b, int e) {	
		int p = a[b];
		b = b+1;
		while (b < e) {
			if (p <= a[b]) {
				swap(a,b,e-1);
				e = e-1;
			} else {
				b = b+1;
			}
		}
		swap(a ,p ,b-1);
		return b-1;
	}

	public static void sortPart(int[] a, int b, int e) {
	//	if (!b+1 <= e) {
	//		partition();
//		}	
		// partition
		

		// sort part 1
		// sort part 2
	
	}

	public void sort(int[] a) {
	}

	public static void printArray(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + i + ": " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {6,2,5,4,7,3,2};
		printArray(a);
		partition(a,0,a.length);
		printArray(a);
	}
}