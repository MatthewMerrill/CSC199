import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MountainClimbing_old {

	private static final String NPU = "NO PATH UP";
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scn = new Scanner(new File("elev.dat"));
		for (int cases = scn.nextInt(); cases > 0; --cases) {
			int[][] h = new int[8][8];
			int mx = 1, my = 1;
			
			{ // SET UP GRID
				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						h[x][y] = scn.nextInt();
						if (h[x][y] > h[mx][my]) {
							mx = x;
							my = y;
						}
					}
				}
			}
			
			{ // FIND PATH
				runCase(h, 1, 1, mx, my);
			}
		}
	}
	
	public static void runCase(int[][] h, int fx, int fy, int tx, int ty) {
		int[][] c = new int[8][8];
		int[][] p = new int[8][8];
		for (int[] i : c)
			Arrays.fill(i, Integer.MAX_VALUE);
		for (int[] i : p)
			Arrays.fill(i, -1);
		
		ArrayList<Point> arrs = new ArrayList<>();
		arrs.add(new Point(fx, fy));
		ArrayList<Point> pathUp;
		
		while (!arrs.isEmpty()) {
			arrs.sort((p0,p1) -> {return c[p1.x][p1.x] - c[p0.x][p0.y];});
			Point pnt = arrs.remove(0);
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					int x = pnt.x + dx;
					int y = pnt.y + dy;
					if (Math.abs(dx + dy) != 1 || h[x][y] - h[pnt.x][pnt.y] > 100 || h[pnt.x][pnt.y] - h[x][y] > 50)
						continue;
					c[x][y] = Math.min(c[x][y], c[pnt.x][pnt.y] + 1);
				}
			}
		}
		
	}

}
