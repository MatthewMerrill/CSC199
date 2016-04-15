/*
 * https://community.topcoder.com/stat?c=problem_statement&pm=14167
 */
public class Queueing {

	public static void main(String[] args) {
		probFirst(1, 2, 2, 1);
		probFirst(1, 3, 3, 7);
	}
	
	public static double probFirst(int len1, int len2, int p1, int p2) {
		
		double a1 = 0;
		double a2 = 0;
		
		for (int i = 1; i <= 1000; ++i) {
			a1 += i*prob(p1, i);
			a2 += i*prob(p2, i);
		}
		System.out.printf("%s, %s\n", a1, a2);
		
	    //a1 = Math.round (a1 * 10000.0) / 10000.0;
		//a1 /= 1000;
		//a2 /= 1000;

		boolean swap = a2 > a1;
		double prob  = 0.0;
		
		if (swap) {
			double tmp = a1;
			a1 = a2;
			a2 = tmp;
			p2 = p1;
		}
		
		for (int i = 1; i <= a1; ++i) {
			prob += prob(p2, i);
		}
		System.out.println(prob);
		
		System.out.printf("%s, %s\n", a1, a2);
		a1 *= len1;
		a2 *= len2;
		System.out.printf("%s, %s\n", a1, a2);
		
		return swap ? prob : 1 - prob;
	}
	
	public static double prob(double p, double k) {
		return ((1/p) * Math.pow(1 - 1/p,k-1));
	}
	
	

}
