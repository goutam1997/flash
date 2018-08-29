
public class TSP {
	final static int n = 4;
	private static final int VISITED_ALL = (1 << n) - 1;
	static int dist[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };

	public static void main(String[] args) {
		System.out.println(tsp(1, 0));
	}

	private static int tsp(int mask, int pos) {
		// TODO Auto-generated method stub
		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		int ans = Integer.MAX_VALUE;
		for (int city = 0; city < n; city++) {
			if (((1 << city) & mask) == 0) {
				int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
				ans = Math.min(newAns, ans);
			}
		}
		return ans;
	}
}
