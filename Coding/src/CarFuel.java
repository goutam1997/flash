import java.util.*;

public class CarFuel {
	static int N, cars[], ans;

	static int findNextRight(int pos) {
		int i = pos + 1;
		while (i <= N && cars[i] == 0) {
			i++;
		}
		if (i != N + 1)
			return i;
		else {
			return -1;
		}
	}

	static int findNextLeft(int pos) {
		int i = pos - 1;
		while (i >= 1 && cars[i] == 0) {
			i--;
		}
		if (i != 0)
			return i;
		else {
			return -1;
		}
	}

	static int findNextRight(int pos, int type) {
		int i = pos + 1;
		while (i <= N && cars[i] != type) {
			i++;
		}
		if (i != N + 1)
			return i;
		else {
			return -1;
		}
	}

	static int findNextLeft(int pos, int type) {
		int i = pos - 1;
		while (i >= 1 && cars[i] != type) {
			i--;
		}
		if (i != 0)
			return i;
		else
			return -1;
	}

	static void MinCost(int pos, int type, int remfuel, int filled, int dist) {
		if (filled == N) {
			ans = Math.min(ans, dist);
			return;
		}
		if (dist > ans)
			return;

		if (remfuel == 0) {
			MinCost(0, type, 2, filled, dist + pos);
			MinCost(N + 1, type, 2, filled, dist + N + 1 - pos);
		}

		if (pos == 0) {

			int next = findNextRight(0, 1);
			if (next != -1) {
				MinCost(next, 1, 2, filled, dist + next);
			} else {
				MinCost(N + 1, 1, 2, filled, dist + N + 1);
			}

		}

		else if (pos == N + 1) {

			int next = findNextLeft(N + 1, 2);
			if (next != -1) {
				MinCost(next, 2, 2, filled, dist + N + 1 - next);
			} else {
				MinCost(0, 2, 2, filled, dist + N + 1);
			}

		}

		else {
			if (cars[pos] == 0) // filled car
			{
				// System.out.println("YES");
				int x = findNextLeft(pos);
				if (x != -1)
					MinCost(x, type, remfuel, filled, dist + pos - x);
				else
					MinCost(0, type, remfuel, filled, dist + pos);

				x = findNextRight(pos);
				if (x != -1)
					MinCost(x, type, remfuel, filled, dist + x - pos);
				else
					MinCost(N + 1, type, remfuel, filled, dist + N + 1 - pos);
			} 
			else if (cars[pos] == type && remfuel > 0) {

				int temp = cars[pos];
				cars[pos] = 0;
				MinCost(pos + 1, type, remfuel - 1, filled + 1, dist + 1);
				MinCost(pos - 1, type, remfuel - 1, filled + 1, dist + 1); // added after
				cars[pos] = temp;

				MinCost(pos + 1, type, remfuel, filled, dist + 1);
				// MinCost(pos+1,type,remfuel,filled,dist+1);
			}

			else if (/*cars[pos] != 0 && */cars[pos] != type) {
				MinCost(pos + 1, type, remfuel, filled, dist + 1);
				MinCost(pos - 1, type, remfuel, filled, dist + 1);
			}

		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			N = sc.nextInt();
			cars = new int[N + 2];
			for (int i = 1; i <= N; i++) {
				cars[i] = sc.nextInt();
			}
			ans = 99999;
			MinCost(0, 1, 2, 0, 0);
			MinCost(N + 1, 2, 2, 0, N + 1);
			System.out.println("#" + k + " " + ans);
		}
	}
}