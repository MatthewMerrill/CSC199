public class V {
	
	public static void main(String[] args) {
		verify("A", "A");
		verify("A", "B");
	}
	
	public static <T> void verify(T emp, T act) {
		if (emp.equals(act)) {
			System.out.printf("\t%s == %s\n", emp, act);
		} else {
			System.out.printf("%s != %s\n", emp, act);
		}
		
	}

}
