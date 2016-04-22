
public class ParenthesesDiv1Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int minCost(String s) {
		int st = 0;
		if (s.length() % 2 == 1)
			return -1;
		for (int i = 0; i < s.length(); i++) {
			st += (s.charAt(i) == '(') ? 1 : -1;
			
			if (st < 0 || st > s.length()-i) {
				return -1;
			}
		}
		st = 0;
		
		
		if (s.length() == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int cut = 0; cut < s.length(); cut++) {
			int mcA = minCost(s.substring(0, cut));
			if (mcA < 0)
				continue;
			
			int mcB = minCost(s.substring(cut));
			
		}
		
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
	
}
