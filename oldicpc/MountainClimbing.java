import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * It's not pretty, but it works.
 * Strange I/O for a BFS.
 * @author merrillm
 * Matthew Merrill 14 April 2016
 */
public class MountainClimbing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		for (int cases = scn.nextInt(); cases > 0; --cases) {
			
			int[][] con = new int[8][8];
			int[][] canvas = new int[8][];
			
			Point highest = new Point(0,0);
			for (int r : range(8)) {
				con[r] = new int[8];
				canvas[r] = new int[8];
				for (int c : range(8)) {
					con[r][c] = scn.nextInt();
					if (con[r][c] > con[highest.x][highest.y])
						highest = new Point(r, c);
				}
			}
			
			int si = 1;
			si = bfs(con, new Point(0,0), highest, canvas, 1);
			if (si < 0) {
				System.out.println("NO PATH UP");
				continue;
			}

			for (int r : range(8)) {
				StringBuilder sb = new StringBuilder();
				for (int c : range(8))
					sb.append(canvas[r][c] + " ");
				System.out.println(sb.toString().trim());
				canvas[r] = new int[8];
			}
			System.out.println();
			
			si = bfs(con, highest, new Point(0,0), canvas, 1);
			if (si < 0) {
				System.out.println("NO PATH DOWN\n");
				continue;
			}
			
			for (int r : range(8)) {
				StringBuilder sb = new StringBuilder();
				for (int c : range(8))
					sb.append(canvas[r][c] + " ");
				System.out.println(sb.toString().trim());
			}
			System.out.println();
			
		}
		scn.close();
	}
	
	public static int bfs(int[][] con, Point from, Point to, int[][] canvas, int si) {
		Set<Point> q = new HashSet<>();
		Point[][] pnt = new Point[8][];
		for (int i : range(8))
			pnt[i] = new Point[8];
		
		q.add(from);
		while (!q.isEmpty()) {
			Set<Point> q2 = new HashSet<>();
			
			Iterator<Point> itr = q.iterator();
			while (itr.hasNext()) {
				Point p = itr.next();
				for (int dr = -1; dr <= 1; dr++) {
					for (int dc = -1; dc <= 1; dc++) {
						if (Math.abs(dr + dc) != 1)
							continue;
						Point p2 = new Point(p.x + dr, p.y + dc);
						
						if (p2.equals(from) || p2.x < 0 || p2.x >= 8 || p2.y < 0 || p2.y >= 8)
							continue;
						
						if (con[p.x][p.y] - con[p2.x][p2.y] > 50 ||
								con[p2.x][p2.y] - con[p.x][p.y] > 100)
							continue;
						
						if (pnt[p2.x][p2.y] == null) {
							pnt[p2.x][p2.y] = p;
							q2.add(p2);	
						} else {
							continue;
						}
						
						if (p2.equals(to)) {
							Stack<Point> stack = new Stack<>();
							Point i = to;
							
							do {
								stack.push(i);
								i = pnt[i.x][i.y];
							}
							while (i != null);
							
							while (!stack.isEmpty()) {
								Point point = stack.pop();
								canvas[point.x][point.y] = si++;
							}
							return si;
						}
						
					}
				}
				
				
			}
			q = q2;
		}
		return -1;
	}
	
	public static int[] range(int max) {
		int[] arr = new int[max];
		for (int i = 0; i < max; i++)
			arr[i] = i;
		return arr;
	}

}
