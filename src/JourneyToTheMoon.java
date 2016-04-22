import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class JourneyToTheMoon {

	@SuppressWarnings({"serial", "unchecked"})
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int I = scn.nextInt();
		
		int[][] country = new int[N][];
		
		for (int i : range(N))
			country[i] = new int[N];
		
		for (int i : range(I)) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			
			country[a][b] = 1;
			country[b][a] = 1;
		}

		List<Integer> sizes = new ArrayList<Integer>();
		boolean[] seen = new boolean[N];
		for (int i : range(I)) {
			if (!seen[i])
				sizes.add(dfs(i, 1, country, seen));
		}
		
		int ways = 0;
		for (int i : range(sizes.size()))
			for (int j : range(i+1, sizes.size()))
				ways += (sizes.get(i) * sizes.get(j));
		
		System.out.println(ways);
		
		scn.close();
	}

	private static int dfs(int i, int count, int[][] country, boolean[] seen) {
		for (int n : country[i]) {
			if (!seen[n]) {
				seen[n] = true;
				count += dfs(n, 1, country, seen);
			}
		}
		return count;
	}

	public static int[] range(int m) {
		return range(0,m);
	}
	public static int[] range(int a, int m) {
		int[] arr = new int[m-a];
		for (int i = a; i < m; i++)
			arr[i-a] = i;
		return arr;
	}
	
}
