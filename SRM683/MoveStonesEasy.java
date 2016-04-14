
/**
 * Included are two solutions. Both work, but
 * the uncommented version reduces time by
 * calculating the number of iterations it
 * would otherwise perform.
 * 
 * 1 March 2016
 * @author merrillm, Mtthew Merrill
 *
 */
public class MoveStonesEasy {

	public static void main(String[] args) {
		System.out.println(get(
				new int[]{1,2}, new int[]{2,1})
				== 1);
		System.out.println(get(
				new int[]{10,0}, new int[]{0,10})
				== 10);
		System.out.println(get(
				new int[]{3,10,0,4,0,0,0,1,0}, new int[]{5,5,0,7,0,0,0,0,1})
				== 9);
		System.out.println(get(
				new int[]{5}, new int[]{6})
				== -1);
	}

	public static int get(int[] a, int[] b) {
		int n = a.length - 1;
		int moves = 0;
		
		for (int i = 0; i < n; i++) {
			int dn = b[i] - a[i];
			
			if (dn != 0) {
				a[i+1] -= dn;
				a[i] += dn;
				moves += Math.abs(dn);
			}
		}
		
		if (a[n] != b[n])
			return -1;
		else
			return moves;
	}
	
	/*
	public static int get(int[] a, int[] b) {
		int n = a.length - 1;
		int moves = 0;
		
		for (int i = 0; i < n; i++) {
			while (a[i] < b[i]) {
				a[i+1]--;
				a[i]++;
				moves++;
			}
			while (a[i] > b[i]) {
				a[i+1]++;
				a[i]--;
				moves++;
			}
		}
		
		if (a[n] != b[n])
			return -1;
		else
			return moves;
	}
	*/
	
}
