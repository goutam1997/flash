import java.util.*;

public class CPU_Selling {
	static int model[][], d, e, ans, N;
	static boolean visited[];

	static void getMaxCost(int D, int E, int F, int n, int total) {
		ans = Math.max(ans, total + D * d + E * e);

		if (n == 4 || D == 0 || E == 0 || F == 0) {
			return;
		}
		int i, j;
		for (i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				j = 1;
				while (true) {
					if (j * model[i][0] <= D && j * model[i][1] <= E && j * model[i][2] <= F) {
						getMaxCost(D - j * model[i][0], E - j * model[i][1], F - j * model[i][2], n + 1,
								total + j * model[i][3]);
					} else
						break;
					j++;
				}
			}
			visited[i] = false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int a = 0; a < t; a++) {
			int D = sc.nextInt();
			int E = sc.nextInt();
			int F = sc.nextInt();
			d = sc.nextInt();
			e = sc.nextInt();
			N = sc.nextInt();
			model = new int[N][4];
			for (int i = 0; i < N; i++) {
				model[i][0] = sc.nextInt();
				model[i][1] = sc.nextInt();
				model[i][2] = sc.nextInt();
				model[i][3] = sc.nextInt();
			}
			ans = 0;
			visited = new boolean[N];
			getMaxCost(D, E, F, 1, 0);
			System.out.println(ans);
		}
	}
}
