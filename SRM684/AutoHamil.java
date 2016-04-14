import java.util.*;
import java.util.function.Consumer;

/**
 * Created by merrillm on 4/1/16.
 */
public class AutoHamil {

    public static final String EXISTS = "Exists";
    public static final String DNE = "Does not exists";

    int[] z0;
    int[] z1;
    int[][] canReach;
    int leafCount;

    public void dfsA(int a, int b, int c) {
        if (canReach[a][b] > 0)
            return;
        else {
            canReach[a][b] = c;
            dfsA(a, z0[b], c+1);
            dfsA(a, z1[b], c+1);
        }
    }

    public static void main(String[] args) {
        AutoHamil ah = new AutoHamil();
        System.out.println(ah.check(
                new int[]{1,2,3,4,3,1,6,7},
                new int[]{6,2,2,5,4,7,2,7}
        ));

        for (int m = 0; m < ah.z0.length; m++) {
            for (int n = 0; n < ah.z0.length; n++) {
                System.out.print(ah.canReach[m][n] + " ");
            }
            System.out.println();
        }
    }

    public String check(int[] z0, int[] z1) {
        int n = z0.length;
        this.z0 = z0;
        this.z1 = z1;
        canReach = new int[n][];
        leafCount = 0;

        Set<Integer> needed = new HashSet<>();

        for (int i = 0; i < n; i++) {
            needed.add(i);
            canReach[i] = new int[n];
            dfsA(i, i, 1);
        }
        for (int i = 1; i < n; i++) {
            if (canReach[0][i] == 0)
                return DNE;
        }

        int cur = 0;
        List<List<Integer>> lists = new ArrayList<>();
        while (cur >= 0 && !needed.isEmpty()) {
            List<Integer> list = lists.remove(0);
            Consumer<List<Integer>> c = (l) -> {
                s
            };

            c.accept(new ArrayList<Integer>(){{addAll(list);add(z0[cur]);}});
            c.accept(new ArrayList<Integer>(){{addAll(list);add(z1[cur]);}});

            break;
        }

        return EXISTS;
    }

    public int count() {
		return 0;
    }

    public void bubble(List<List<Integer>> list, Set<Integer> needed) {
        boolean flag = true;
        for (int i = 0; flag || i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                flag = false;
                if (heur(list.get(j + 1), needed) < heur(list.get(j), needed)) {
                    list.add(j, list.remove(j + 1));
                    flag = true;

                }
            }
        }
    }

    public int heur(List<Integer> list, Set<Integer> needed) {
        int h = list.size();
        int f = list.get(list.size()-1)
        for (int i : needed) {
            h += canReach[f][i];
        }
        return h;
    }

    public boolean containsAll(int[] arr, Set<Integer> set) {
        Set<Integer> tmp = new HashSet<>();
        tmp.addAll(set);

        for (int i : arr)
            if (i > 0)
                tmp.remove(i);

        return tmp.isEmpty();
    }
}
