import java.util.Arrays;

/**
 * 7 March 2016
 * @author merrillm, Matthew Merrill
 *
 */
public class DivFreed2 {

	
	public static final int mod = 1000000007;
	
	public static void main(String[] args) {
		check(count(2, 2), 3);
		check(count(9, 1), 1);
		check(count(3, 3), 15);
		check(count(1, 107), 107);
		check(count(2, 10), 83);
		check(count(2, 1234), 1515011);
		check(count(3, 8), 326);
		check(count(10, 100000), 526882214);
	}
	
	public static void check(int a, int b) {
		System.out.println("\t\t\t" + a + " =?= " + b + "\n" + (a==b));
	}
	
	public static boolean inc(int i, int[] arr, int k) {
		while (true) {
			arr[i]++;
			
			while (arr[i] <= k && i < arr.length-1 && arr[i] > arr[i+1] && arr[i] % arr[i+1] == 0)
				arr[i]++;
			
			if (arr[i] > k) {
				arr[i] = 1;
				
				if (i+1 < arr.length) {
					i++;
					continue;
				} else {
					return false;
				}
			}
			break;
		}
		return true;
	}
	
	public static int count(int n, int k) {
		
		int tot = 1;
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		
		outer:
		while (inc(0, arr, k)) {
			
			tot++;
			tot%=mod;
		}
		
		return tot;
	}

}
