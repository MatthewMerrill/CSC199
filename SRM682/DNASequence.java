
/**
 * 
 * @author merrillm, Matthew Merrill 26-FEB-2016
 */
public class DNASequence {

	//public static void main(String[] args) {
	//	System.out.println(longestDNASequence("VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"));
	//}
	
	public static int longestDNASequence(String sequence) {
		
		int max = 0;
		int cur = 0;
		for (int i = 0; i < sequence.length(); i++) {
			
			switch (sequence.charAt(i)) {
				case('A'):
				case('T'):
				case('G'):
				case('C'):
					cur++;
					break;
				default:
					cur = 0;
			}
			
			if (cur > max)
				max = cur;
			
		}
		
		return max;
	}
}