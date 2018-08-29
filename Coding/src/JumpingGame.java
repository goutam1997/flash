import java.util.*;

public class JumpingGame {
	static int n, m, grid[][], des_x, des_y;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static boolean visited[][];

	static boolean isSafe(int x, int y) {
		return (x >= 1 && x <= n && y >= 1 && y <= m);
	}

	static boolean DFS(int cur_x, int cur_y, int jump) {
		if (cur_x == des_x && cur_y == des_y) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= jump; j++) {
				int x = cur_x + j * dx[i];
				int y = cur_y + j * dy[i];

				if (isSafe(x, y) && !visited[x][y] && (grid[x][y] == 1 || grid[x][y] == 3)) {
					visited[x][y] = true;
					if (DFS(x, y, jump))
						return true;
					else
						visited[x][y] = false;
				}

			}
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int a = 0; a < t; a++) {
			n = sc.nextInt();
			m = sc.nextInt();
			des_x = 0;
			des_y = 0;
			grid = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					grid[i][j] = sc.nextInt();
					if (grid[i][j] == 3) {
						des_x = i;
						des_y = j;
					}
				}
			}

			if (des_x == n)
				System.out.println("0");
			else {
				for (int jump = 1; jump <= 50; jump++) {
					visited = new boolean[n + 1][m + 1];
					visited[n][1] = true;
					if (DFS(n, 1, jump)) {
						System.out.println(jump);
						break;
					}

				}

			}
		}
	}
}