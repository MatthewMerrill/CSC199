import java.util.Arrays;

public class ParenthesisDiv1Easy {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(range(5,15)));
		System.out.println(Arrays.toString(correct(")(")));
	}

	public static int[] range(int max) {
		return range(0,max);
	}
	public static int[] range(int a, int max) {
		int[] arr = new int[max-a];
		for (int i = a; i < max; i++)
			arr[i-a] = i;
		return arr;
	}
	
	public static int[] correct(String s) {
		boolean[] bar = new boolean[s.length()];
		int n = s.length();
		if (s.length() % 2 == 1)
			return new int[]{-1};
		
		for (int i : range(0,s.length())) {
			
		}
		
		return null;
	}
	
	
}
