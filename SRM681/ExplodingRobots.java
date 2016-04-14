public class ExplodingRobots {
	
	public static void main(String[] args) {
		System.out.println(canExplode(10, 5, -9, -10, "LULULULLLUULRULULULULULULLULULLULD") == EXPLODE);
		System.out.println(canExplode(10, 5, -9, -10, "LULULULLLUULRULLULLLD") == SAFE);
		System.out.println(canExplode(0,  0,  0,   0, "") == EXPLODE);
	}
	
	public static final String EXPLODE = "Explosion";
	public static final String SAFE = "Safe";
	
	public static String canExplode(int x1, int y1, int x2, int y2, String directions) {
		
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);

		if (dx <= 0 && dy <= 0) {
			return EXPLODE;
		}
		
		for (int i = 0; i < directions.length(); i++) {
			char c = directions.charAt(i);
			
			if (c == 'U' || c == 'D')
				dy--;
			
			if (c == 'L' || c == 'R')
				dx--;
			
			if (dx <= 0 && dy <= 0) {
				return EXPLODE;
			}
		}
		
		return SAFE;
	}
}
