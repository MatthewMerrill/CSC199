import java.util.HashSet;
import java.util.Set;

/**
 * From SRM 689
 * Created by merrillm on 4/24/16.
 */
public class NonDeterministicSubstring {

    public static long ways(String a, String b) {
        if (a.length() < b.length())
            return 0;

        Set<Long> ways = new HashSet<>();

        posLoop:
        for (int i : xrange(a.length() - b.length() + 1)) {

            for (int j : xrange(b.length())) {
                if (b.charAt(j) == '?')
                    continue;

                if (b.charAt(j) != a.charAt(i))
                    continue posLoop;
            }
            ways.add(Long.parseLong(a.substring(i, i+b.length()), 2));
        }
        return ways.size();
    }

    public static void main(String[] args) {
        debug(ways("00010001","??"));
        debug(ways("1101010101111010101011111111110001010101", "???????????????????????????????????"));
    }


    private static int[] xrange(int t) {
        return range(0, t, 1);
    }
    private static int[] range(int f, int t, int step) {
        int[] arr = new int[t-f];
        if (t - f > 0 != step > 0)
            step *= -1;
        for (int i = f; i < t; i += step) {
            arr[i-f] = i;
        }
        return arr;
    }

    private static boolean DEBUGGING = true;
    private static void debug(Object obj) {
        if (!DEBUGGING)
            return;
        System.out.println(obj.toString());
    }

    public static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
        return a * (b / gcd(a,b));
    }

}
