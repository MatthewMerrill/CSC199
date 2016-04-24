import java.util.ArrayList;
import java.util.Arrays;

/**
 * From SRM 689
 * Created by merrillm on 4/24/16.
 *
 * Fails for large inputs. I'm looking into a way
 * to use permutations / memoize to reduce complexity.
 */
public class xColorfulGardenHard {

    public static int count(String garden, String forbid) {
        char[] g = garden.toCharArray();
        char[] f = forbid.toCharArray();

        ArrayList<Integer> count = new ArrayList<>(26);
        for (int i : xrange(27))
            count.add(0);

        for (int i : xrange(g.length)) {
            count.set(((int)g[i])-97, count.get(((int)g[i])-97)+1);
        }

        return countr('\0', f, count, 0);
    }

    public static int countr(char last, char[] f, ArrayList<Integer> counts, int depth) {
        if (depth >= f.length)
            return 1;

        int ways = 0;
        for (int i : xrange(counts.size())) {
            if (counts.get(i) <= 0)
                continue;

            if (i == (int)last - 97 || i == f[depth]-97)
                continue;

            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.addAll(counts);
            sublist.set(i, counts.get(i) - 1);
            ways += countr((char)(i+97), f, sublist, depth+1);
            ways %= 1_000_000_007;
        }
        //debug(depth);
        return ways;
    }

    public static void main(String[] args) {
        debug(count("aaabbb", "cccccc"));
        debug(count("aabbcc", "aabbcc"));
        debug(count("aaaabb", "xxxxxx"));
    }

    // DEBUG PRINTING
    public static boolean DEBUGGING = true;
    public static void debug(Object obj) {
        if (!DEBUGGING)
            return;
        System.out.println(obj.toString());
    }


    // ITERATION
    public static int[] xrange(int t) {
        return range(0, t, 1);
    }
    public static int[] range(int f, int t, int step) {
        int[] arr = new int[t-f];
        if (t - f > 0 != step > 0)
            step *= -1;
        for (int i = f; i < t; i += step) {
            arr[i-f] = i;
        }
        return arr;
    }


    // MATH
    private static long[] $fact_mem = null;
    private static int $fact_known = 0;
    public static long factorial(int n) {
        // [Optional] If you set max size and initialize $fact_mem[0] to 1, ignore this.
        if ($fact_mem == null) {
            $fact_mem = new long[n+1];
            $fact_mem[0] = 1;
        }
        if ($fact_mem.length <= n) {
            $fact_mem = Arrays.copyOf($fact_mem, n+2);
        }
        $fact_mem[0] = 1;
        // [/Optional]
        long res = $fact_mem[$fact_known];
        while ($fact_known < n) {
            $fact_known++;
            res *= $fact_known;
            debug("$" + Arrays.toString($fact_mem));
            $fact_mem[$fact_known] = res;
        }
        return res;
    }

    public static long Perm(int n, int r) {
        return factorial(n) / factorial(n-r);
    }
    public static long Comb(int n, int r) {
        return factorial(n) / (1L * factorial(r) * factorial(n-r));
    }

    public static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
        return a * (b / gcd(a,b));
    }

}