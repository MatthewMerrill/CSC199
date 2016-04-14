import java.util.HashSet;
import java.util.Set;

/**
 * TopBiologist.java
 * 26-FEB-2016
 * @author merrillm, Matthew Merrill
 */
public class TopBiologist {

	public static void main(String[] args) {
		System.out.println(findShortestNewSequence("VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"));
	}
	
	public static final char[] d = new char[]{'0', '1', '2', '3'};
	public static String findShortestNewSequence(String sequence) {
		sequence.replaceAll("G", "0");
		sequence.replaceAll("A", "1");
		sequence.replaceAll("T", "2");
		sequence.replaceAll("C", "3");
		
		boolean containsAll = true;
		int n = 1;
		Set<String> nSet;
		while (containsAll) {
			nSet = new HashSet<String>();
			n++;
			
			for (int i = 0; i < sequence.length()-3; i++) {
				nSet.add(sequence.substring(i, i+4));
			}
			
			System.out.println(Integer.toString(n, 4));
			
			//containsAll = nSet.size() == Math.pow(4, 4);
		}
		
		
		return bfs(sequence);
	}
	
	public static String bfs(String sequence) {
		
		String a = "A", c = "C", g = "G", t = "T";
		
		if (sequence.contains("A"))
			a += bfs(sequence.substring(sequence.indexOf('A') + 1));
		
		if (sequence.contains("T"))
			t += bfs(sequence.substring(sequence.indexOf('T') + 1));

		if (sequence.contains("G"))
			g += bfs(sequence.substring(sequence.indexOf('G') + 1));
		
		if (sequence.contains("C"))
			c += bfs(sequence.substring(sequence.indexOf('C') + 1));
		
		String shortest = a;
		shortest = (shortest.length() < c.length()) ? shortest : c;
		shortest = (shortest.length() < g.length()) ? shortest : g;
		shortest = (shortest.length() < t.length()) ? shortest : t;
		
		return shortest;
	}
	
}