public class ParenthesesDiv1Medium {

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(range(5,15)));
		System.out.println((minSwaps(")(", new int[]{0,0,0,0}, new int[]{1,1,1,1})));
		System.out.println((minSwaps("(())", new int[]{0,2}, new int[]{1,3})));
	 	System.out.println((minSwaps(")()(()()((())()()()()()()))(()())()()()(", new int[]{3,5,17,25,35}, new int[]{12,10,30,30,38})));
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
	
	public static int minSwaps(String s, int[] L, int[] R) {
		boolean[] bar = new boolean[s.length()];
		boolean[] swapped = new boolean[s.length()];
		
		int n = s.length();
		//if (n % 2 == 1)
		//	return -1;
		
		for (int c : range(n)) {
			bar[c] = s.charAt(c) == '(';
		}
		
		for (int c : range(0,L.length)) {
			int st = 0;
			for (int i : range(L[c], R[c]+1)) {
				if (bar[i])
					st++;
				if (!bar[i]) {
					st--;
				}
    
            if (st < 0 || st>R[c]-i) {
					int j = i;
					while (j < n && (bar[i]==bar[j])) {
						j++;
					}
					
					if (j == n)
						return -1;
                  
					bar[i] ^= true;
					bar[j] ^= true;
					swapped[i] ^= true;
					swapped[j] ^= true;
				   
               if (bar[i])
   					st+=2;
   				else if (!bar[i]) {
   					st-=2;
   				}
            }

            
            /*for (int r = R[c]-1; r+r > (R[c]-L[c]); --r) {
               
            }*/
			}
		}
		
		int count = 0;
		for (int c : range(n)) {
			if (swapped[c])
				count++;
		}
		
		if (count % 2 == 1)
			return -1; // WHAT HAPPENED
		return count / 2;
	}
	
	
}
