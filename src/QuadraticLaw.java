public class QuadraticLaw {
	
	public static void main(String[] args) {
		System.out.println(getTime(1) == 0);
		System.out.println(getTime(2) == 1);
		System.out.println(getTime(5) == 1);
		System.out.println(getTime(6) == 2);
		System.out.println(getTime(7) == 2);
		System.out.println(getTime(1482) == 38);
		System.out.println(getTime(1000000000000000000L) == 999999999);
		System.out.println(getTime(31958809614643170L) == 178770270);
		
	}
	
	public static long getTime(long d) {
		return (long) Math.floor(quadratic(1, 1, -d));
	}
	
	public static double quadratic(double a, double b, double c) {
		return (-b + Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
	}
}
