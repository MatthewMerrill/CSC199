import java.util.ArrayList;

/**
 * FiringEmployees.java
 * 26-FEB-2016
 * @author merrillm, Matthew Merrill
 */
public class FiringEmployees {

	public static void main(String[] args) {
		System.out.println(fire(new int[]{0,0,0}, new int[]{1,2,3}, new int[]{3,2,1}));
		System.out.println(fire(
				new int[]{0,1,2,1,2,3,4,2,3}, 
				new int[]{5,3,6,8,4,2,4,6,7}, 
				new int[]{2,5,7,8,5,3,5,7,9}
		));
		System.out.println(fire(
				new int[]{0,0,1,1,2,2}, 
				new int[]{1,1,1,2,2,2}, 
				new int[]{2,2,2,1,1,1}));
	}
	
	
	private static class Employee {
		
		ArrayList<Employee> children = new ArrayList<Employee>();
		int s = 0;
		int p = 0;
		
		public int profit() {
			return p - s;
		}
		
		public int maxProfit() {
			int prof = profit();
			for (Employee e : children)
				prof += e.maxProfit();
			return Math.max(prof, 0);
		}
		
	}

	public static int fire(int[] m, int[] s, int[] p) {
		Employee[] e = new Employee[m.length+1];
		e[0] = new Employee();
		for (int i = 0; i < m.length; i++) {
			e[i+1] = new Employee();
			e[i+1].s = s[i];
			e[i+1].p = p[i];
			e[m[i]].children.add(e[i+1]);
		}
		return e[0].maxProfit();
	}
	
}
