import java.util.*;

public class XorLists {
    private static final String zeros = "00000000000000000000000000000000";
    
    public static void main(String[] args) {
    	System.out.println(countLists(new int[]{0,1,2, 1,0,3, 2,3,0}, 5));
    }
    
    public static int countLists(int[] s, int max) {
        
        int n = (int) Math.sqrt(s.length);
      	List<Integer> l = new ArrayList<Integer>();
      	
        for (int i = 0; i < n; i++) {
        	
        	if (s[i*n + i] != 0)
        		return 0;
        	
        	for (int j = 0; j < i; j++) {
        		if (s[i*n + j] != s[j*n + i])
        			return 0;
        		
        		l.add(s[i*n + j]);
        	}
        }

        int[] m = new int[l.size()];
        Arrays.fill(m, max);
        int[] s2 = new int[l.size()];
        
        for (int i = 0; i < l.size(); i++) {
        	s2[i] = l.get(i);
        }
        
        return count(s2, m, 30);
    }
    
    public static int count(int[] s, int[] m, int in) {
        int ret = 0;
        
        if (s.length == 0) {
        	return maxVal(m) + 1;
        }
        
        decLoop:
        while (true) {
        	int n = 1 << in;
        	for (int i : m) {
        		if (i >= n)
        			break decLoop;
        	}
        	for (int i : s) {
        		if (i >= n)
        			break decLoop;
        	}
        	
        	in--;
        }

        if (in < 0)
            return 1;
        
        if (maxVal(m) < (1 << in - 1) - 1)
            return 1 << in;
        
        if (valid(s, m)) {
            int[] s2 = Arrays.copyOf(s, s.length);
            int[] m2 = Arrays.copyOf(m, s.length);
            
            prepare(s2, m2, in);
            ret += count(s2, m2, in-1);
        }
        
        if (valid(flip(s, in), m)) {
            int[] s2 = new int[s.length];
            int[] m2 = new int[s.length];
            
            prepare(s2, m2, in);
            ret += count(s2, m2, in-1);
        }
        
        return ret;
    }
    
    public static int maxVal(int[] m) {
        int maxVal = m[0];
        for (int i : m)
            maxVal = (i > maxVal) ? i : maxVal;
        
        return maxVal;
    }
    
    public static void prepare(int[] s, int[] m, int in) {
        for (int i = 0; i < s.length; i++) {
            s[i] %= 1 << in;
            m[i] %= 1 << in;
        }
    }
    
    public static int[] flip(int[] s, int in) {
        int[] ret = Arrays.copyOf(s, s.length);
        for (int i = 0; i < s.length; i++) {
            ret[i] ^= 1 << in;
        }
        return ret;
    }
    
    public static boolean valid(int[] s, int[] m) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] > m[i]) {
            	return false;
            }
        }
        
        return true;
    }
}