import java.util.Arrays;

/**
 * From SRM 689
 * Created by merrillm on 4/24/16.
 */
public class SimilarUserDetection {

    private static final String TRUE = "Similar handles found";
    private static final String FALSE = "Similar handles not found";

    private static final String[] sim = new String[] {"0O","1Il"};

    public static String haveSimilar(String[] handles) {
        for (int i : xrange(handles.length)) {
            for (int j : range(i+1, handles.length)) {
                if (isSimilar(handles[i], handles[j])) {
                    return TRUE;
                }
            }
        }
        return FALSE;
    }

    public static void main(String[] args) {
        debug(haveSimilar(new String[]{"Topcoder", "topcoder"}));
        debug(isSimilar("ooo", "000"));
        debug(isSimilar("Topcoder", "topcoder"));
    }

    private static boolean isSimilar(String s0, String s1) {
        if (s0.length() != s1.length())
            return false;

        for (int i : xrange(s0.length())) {
            char c0 = s0.charAt(i);
            char c1 = s1.charAt(i);

            if (((int)c0 == (int)c1) || Arrays.stream(sim)
                    .anyMatch((str) -> str.contains(c0 + "") && str.contains(c1 + "")))
                continue;

            return false;
        }
        return true;
    }



    private static int[] xrange(int t) {
        return range(0, t, 1);
    }
    private static int[] range(int f, int t) {
        return range(f, t, 1);
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
