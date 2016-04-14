public class CoinFlips {

	public static void main(String[] args) {
		System.out.println(countCoins("HHTTTH") == 4);
		System.out.println(countCoins("HHTH") == 3);
		System.out.println(countCoins("HHH") == 0);
		System.out.println(countCoins("HTTTTH") == 4);
		System.out.println(countCoins("HHTHTH") == 5);
	}
	
	public static int countCoins(String str) {
		int count = 0;
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; ++i) {
			char c = arr[i];
			
			if (i > 0) {
				if ((char)(c | arr[i-1]) == '\\') { // 'H' (1001000) | 'T' (1010100) == '\\' (1011100)
					count++;
					continue;
				}
			}
			
			if (i+1 <  arr.length) {
				if ((char)(c | arr[i+1]) == '\\') { // 'H' (1001000) | 'T' (1010100) == '\\' (1011100)
					count++;
					continue;
				}
			}
		}
		
		return count;
		
	}
}
