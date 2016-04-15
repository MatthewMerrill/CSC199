import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by merrillm on 4/1/16.
 */
public class AutoHamil {

    public static final String EXISTS = "Exists";
    public static final String DNE = "Does not exist";

    int[] z0;
    int[] z1;
    int[][] canReach;

    public void dfsA(int a, int b, int c) {
        if (canReach[a][b] > 0)
            return;
        else {
            canReach[a][b] = c;
            dfsA(a, z0[b], c+1);
            dfsA(a, z1[b], c+1);
        }
    }

    public String check(int[] z0, int[] z1) {
        int n = z0.length;
        this.z0 = z0;
        this.z1 = z1;
        canReach = new int[n][];

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

        for (int i = 0; i < n; i++) {
        	for (int j = i; j < n; j++) {
        		if (canReach[i][j] + canReach[j][i] == 0)
        			return DNE;
        	}
        }

        return EXISTS;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        AutoHamil ah = new AutoHamil();
        Scanner scn = new Scanner(new File("AutoHamilIn.in"));
        
        //*
        int count = 0;
        while (scn.hasNextLine()) {
        	count++;
        	
        	String line = scn.nextLine();
        	String caseStr = line.substring(line.indexOf('{') + 1, line.lastIndexOf('}'));
        	String[] splt = caseStr.split("\\}, \\{");
        	
        	int[][] arr = new int[2][];
        	
        	for (int i = 0; i <= 1; i++) {
        		String[] numStrs = splt[i].split(", ");
        		arr[i] = new int[numStrs.length];
        		for (int n = 0; n < numStrs.length; n++) {
        			arr[i][n] = Integer.parseInt(numStrs[n]);
        		}
        	}
        	
        	String expected = line.substring(line.indexOf('"')+1, line.lastIndexOf('"'));
        	long pre = System.currentTimeMillis();
        	String emperical = ah.check(arr[0], arr[1]);
        	long post = System.currentTimeMillis();
        	
        	long elapsed = post - pre;
        	System.out.printf("%s\t%s%s%s\t%s\n", count,
        			expected.equals(emperical) ? "   " : " # ",
   					elapsed < 2000 ? "   " : " # ",
   					emperical, elapsed);
        	
        }
        scn.close();
        
        /*/
        System.out.println(ah.check(
                new int[]{0, 2, 3, 0},
                new int[]{2, 3, 0, 3}
        ));
        
        for (int m = 0; m < ah.z0.length; m++) {
            for (int n = 0; n < ah.z0.length; n++) {
                System.out.print(ah.canReach[m][n] + " ");
            }
            System.out.println();
        }//*/
    }

}
