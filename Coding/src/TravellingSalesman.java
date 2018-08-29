
//Travelling SalesMan Problem
import java.util.*;

public class TravellingSalesman {

	int MinFare(int cost[][], int mask, int pos, int N) {
		if (mask == (1 << N) - 1)
			return cost[pos][0];

		// Visit all the Unvisited cities and calculate the min cost route
		int ans = 9999999;
		for (int city = 0; city < N; city++) {
			if ((mask & (1 << city)) == 0 && cost[pos][city] != 0) // These are the possible unvisited cities and
																	// therefore update the cost
			{
				int newAns = cost[pos][city] + MinFare(cost, mask | (1 << city), city, N);
				ans = Math.min(ans, newAns);
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int cost[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					cost[j][k] = sc.nextInt();
				}
			}
			TravellingSalesman ob = new TravellingSalesman();
			System.out.println(ob.MinFare(cost, 1, 0, N));
		}
	}
}
