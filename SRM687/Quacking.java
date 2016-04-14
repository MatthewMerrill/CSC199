import java.util.ArrayList;

public class Quacking {
	
	public static final String QUACK = "quack";
	
	public static void main(String[] args) {
		System.out.println(quack("quqaquuacakcqckkuaquckqauckack"));
	}
	
	public static int quack(String s) {
		int max = 0;
		ArrayList<String> arr = new ArrayList<String>();
		itrLoop:
		for (char ch : s.toCharArray()) {
			if (ch == 'q') {
				arr.add("q");
				if (arr.size() > max)
					max = arr.size();
				continue;
			}
			int ind = QUACK.indexOf(ch);
			char pr = QUACK.charAt(ind-1);
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).endsWith(pr + "")) {
					String str = (arr.remove(i) + ch);
					if (ch != 'k')
						arr.add(i, str);
					continue itrLoop;	
				}
			}
			return -1;
		}
		return max;
	}

}
