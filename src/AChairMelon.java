import java.awt.Point;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Created by merrillm on 4/22/16.
 */
public class AChairMelon {

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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        caseLoop:
        for (int $ : xrange(scn.nextInt())) {
            int R = scn.nextInt();
            int C = scn.nextInt();

            int[][] spin = new int[R][];
            int[][] positions = new int[R][];
            boolean[][] reached = new boolean[R][];

            for (int r : xrange(R)) {
                spin[r] = IntStream.generate(scn::nextInt).limit(C).toArray();
                positions[r] = IntStream.generate(scn::nextInt).limit(C).toArray();
                reached[r] = new boolean[C];
            }

            //debug(Arrays.deepToString(positions));

            Point heurPoint = new Point(R-1,C-1);
            ArrayList<Point> list = new ArrayList<>();

            list.add(new Point(0,0));
            reached[0][0] = true;

            Function<Point, Integer> getSpin = (point) -> spin[point.x][point.y];

            aStar:
            while (!list.isEmpty()) {
                Collections.sort(list,
                        (a, b) -> (int) (b.distanceSq(R-1, C-1) - a.distanceSq(R-1, C-1)));

                Point popped = list.remove(0);

                for (int dx : range(-1,2,1)) {
                    for (int dy : range(-1,2,1)) {
                        if (Math.abs(dx + dy) != 1) {
                            continue;
                        }

                        Point to = new Point(popped.x + dx, popped.y + dy);

                        for (int rep : xrange(
                                lcm(getSpin.apply(popped), getSpin.apply(to)))) {

                        }


                    }
                }



            }
            System.out.println(reached[R-1][C-1]);
        }


    }



}
