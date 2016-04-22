import java.awt.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by merrillm on 4/20/16.
 */
public class MyProblem {

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
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
        return a * (b / gcd(a,b));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        debug(gcd(24,6));
        debug(gcd(14,21));
        debug(gcd(24,6));
        debug(gcd(22,145));

        caseLoop:
        for (int $ : xrange(scn.nextInt())) {
            // Number of Rows and Columns
            int R = scn.nextInt(), C = scn.nextInt();
            // Spin Rates
            int[][] spin = new int[R][];
            // First time can get the melon
            int[][] time = new int[R][];

            // Initialize array
            for (int r : xrange(R)) {
                spin[r] = IntStream.generate(scn::nextInt).limit(C).toArray();
                time[r] = IntStream.generate((    ) -> -1).limit(C).toArray();
            }
            debug("spin: " + Arrays.deepToString(spin));

            time[0][0] = 0;

            int[][] d_arr = new int[][]{
                    new int[]{-1,0}, new int[]{0,1},
                    new int[]{1,0}, new int[]{0,-1}
            };

            for (int rep : xrange(R*C)) {
                boolean changesMade = false;
                for (int r : xrange(R)) {
                    for (int c : xrange(C)) {
                        if (time[r][c] < 0)
                            continue;

                        dirLoop:
                        for (int dir : xrange(4)) {
                            int dr = d_arr[dir][0], dc = d_arr[dir][1];

                            if (r+dr < 0 || r+dr >= R || c+dc < 0 || c+dc >= C) {
                                continue dirLoop;
                            }

                            // We're spinning at same rate, never meet.
                            if (spin[r+dr][c+dc] == spin[r][c])
                                continue dirLoop;

                            // They're already passing to me, can't improve them.
                            if (time[r+dr][c+dc] >= 0 && time[r+dr][c+dc] <= time[r][c])
                                continue dirLoop;

                            // Initial time I have melon
                            int t = time[r][c];
                            int d0, d1;

                            for (int i : xrange(5)) {
                                // Direction faced at t0
                                d0 = (spin[r][c] * t) % 4;
                                d1 = (spin[r + dr][c + dc] * t) % 4;

                                // If we don't meet, increment time by lesser of our rotation times.
                                if (d0 == dir && d1 == (dir+2)%4)
                                    break;
                                t++;
                                debug(dir + " " + t);

                                if (i == 4)
                                    continue dirLoop;
                            }

                            if (time[r+dr][c+dc] < 0 || t < time[r+dr][c+dc]) {
                                changesMade = true;
                                time[r+dr][c+dc] = t;
                            }
                        }
                    }
                }
                debug(Arrays.deepToString(time));
                if (!changesMade)
                    break;
            }
            debug(Arrays.deepToString(time));
            System.out.println(time[R-1][C-1]);
        }

    }

}
