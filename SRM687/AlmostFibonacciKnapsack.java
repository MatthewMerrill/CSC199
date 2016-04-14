import java.util.ArrayList;
import java.util.Arrays;

public class AlmostFibonacciKnapsack {

	private static int maxKnown = -1;
	private static long[] m = new long[100];
	private static int[] DNE = new int[]{-1};
	
	static { 
		m[1] = 2; m[2] = 3;
		for (int i = 3; i < 100; i++)
			m[i] = m[i-1] + m[i-2] - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(m[99]);
		int[] arr = getIndices(86267769395L);
		System.out.println(Arrays.toString(arr));
		long res = 0;
		for (int i : arr)
			res += m[i];
		System.out.print(res);
	}
	
	public static int[] getIndices(long x) {
		ArrayList<Integer> arr = getIndices(x, 80);
		if (arr != null) {
			int[] r = new int[arr.size()];
			for (int j = 0; j < arr.size(); ++j)
				r[j] = arr.get(j);
			return r;
		}
		return DNE;
	}
	
	public static ArrayList<Integer> getIndices(long x, int max) {
		if (x == 0) {
			return new ArrayList<Integer>();
		}
		
		if (x < 0)
			return null;

		while (m[--max] > x){}
		for (int i = max; i > 0; --i) {
			ArrayList<Integer> arr = getIndices(x - m[i], i);
			if (arr != null) {
				arr.add(i);
				return arr;
			}
		}
		
		return null;
	}
}
