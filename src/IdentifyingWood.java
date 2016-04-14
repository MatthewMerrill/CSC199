public class IdentifyingWood {
	
	public static void main(String[] args) {
		// Since I'm returning the static object, "==" operator works fine.
		System.out.println(check("absdefgh", "asdf") == WOOD);
		System.out.println(check("oxoxoxox", "ooxxoo") == NOT_WOOD);
		System.out.println(check("oxoxoxox", "xxx") == WOOD);
		System.out.println(check("qwerty", "qwerty") == WOOD);
		System.out.println(check("string", "longstring") == NOT_WOOD);
	}
	
	private static final String WOOD = "Yep, it's wood.";
	private static final String NOT_WOOD = "Nope.";
	
	public static String check(String s, String t) {
		
		//  |sl -->
		// "THIS IS MY STRING FOR S"
		//                    <-- |sh
		//
		//  |tl -->
		// "THIS IS T"
		//      <-- |th     
		//
		// If tl passes th before sl passes sh, T was in S.
		
		int sl = 0, sh = s.length() - 1;
		int tl = 0, th = t.length() - 1;
		
		while (tl <= th) {
			
			if (sl > sh || sl >= s.length() || sh < 0)
				return NOT_WOOD;
			
			if (t.charAt(tl) == s.charAt(sl))
				tl++;

			if (t.charAt(th) == s.charAt(sh))
				th--;

			++sl;
			--sh;
		}
		
		return WOOD;
	}
}
