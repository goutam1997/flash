public class MarbleProblem {
	static int ans;
	// 1-up 2-down 3-left 4-right(column)
	/*
	 * int[][] block= { {0,0,0,0}, {0,4,1,0}, {4,0,2,0}, {3,0,0,2}, {0,3,0,1},
	 * {0,0,0,0}};
	 */
	static int[][] a = { { 0, 0, 31, 0, 0 }, { 51, 31, 0, 0, 0 }, { 0, 0, 42, 31, 32 }, { 0, 0, 21, 0, 0 },
			{ 0, 11, 0, 0, 32 } };

	public static void main(String[] args) {
		ans = -9999;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (a[i][j] == 0) {
					boolean[][] visited = new boolean[5][5];
					visited[i][j] = true;
					go(i - 1, j, true, false, false, false, visited, 0);
					go(i + 1, j, false, true, false, false, visited, 0);
					go(i, j - 1, false, false, true, false, visited, 0);
					go(i, j + 1, false, false, false, true, visited, 0);
				}
			}
		}
		System.out.println(ans);
	}

	private static void go(int i, int j, boolean up, boolean down, boolean left, boolean right, boolean[][] visited,
			int disap) {
		if (i == 5)
			i = 0;
		if (i == -1)
			i = 4;
		if (j == -1)
			j = 4;
		if (j == 5)
			j = 0;
		if (visited[i][j]) {
			int x = 0, y = 0;
			if (up || down) {
				for (x = 0; x < 5; x++)
					if ((a[x][j] % 10) != 0)
						break;
				if (x == 5) {
					ans = Integer.max(ans, disap);
					return;
				}
			} else if (left || right) {
				for (y = 0; y < 5; y++)
					if ((a[i][y] % 10) != 0)
						break;
				if (y == 5) {
					ans = Integer.max(ans, disap);
					return;
				}
			}
		}
		visited[i][j] = true;
		int last = a[i][j] % 10;
		if (last == 0) {
			if (up)
				go(i - 1, j, up, down, left, right, visited, disap);
			else if (down)
				go(i + 1, j, up, down, left, right, visited, disap);
			else if (left)
				go(i, j - 1, up, down, left, right, visited, disap);
			else if (right)
				go(i, j + 1, up, down, left, right, visited, disap);
			return;
		}
		int first = a[i][j] / 10;/* if(a[i][j]>0) */
		a[i][j]--;
		boolean f = false;
		if ((a[i][j] % 10) == 0)
			f = true;
		if (up) {
			if (first == 2) {
				if (f)
					go(i, j + 1, false, false, false, true, visited, disap + 1); // right
				else
					go(i, j + 1, false, false, false, true, visited, disap); // right
			} else if (first == 3) {
				if (f)
					go(i, j - 1, false, false, true, false, visited, disap + 1); // left
				else
					go(i, j - 1, false, false, true, false, visited, disap); // left
			} else {
				if (f)
					go(i + 1, j, false, true, false, false, visited, disap + 1); // down
				else
					go(i + 1, j, false, true, false, false, visited, disap); // down
			}
		} else if (down) {
			if (first == 1) {
				if (f)
					go(i, j + 1, false, false, false, true, visited, disap + 1); // right
				else
					go(i, j + 1, false, false, false, true, visited, disap); // right
			} else if (first == 4) {
				if (f)
					go(i, j - 1, false, false, true, false, visited, disap + 1); // left
				else
					go(i, j - 1, false, false, true, false, visited, disap); // left
			} else {
				if (f)
					go(i - 1, j, true, false, false, false, visited, disap + 1); // up
				else
					go(i - 1, j, true, false, false, false, visited, disap); // up
			}
		} else if (left) {
			if (first == 1) {
				if (f)
					go(i - 1, j, true, false, false, false, visited, disap + 1); // up
				else
					go(i - 1, j, true, false, false, false, visited, disap); // up
			} else if (first == 2) {
				if (f)
					go(i + 1, j, false, true, false, false, visited, disap + 1); // down
				else
					go(i + 1, j, false, true, false, false, visited, disap); // down
			} else {
				if (f)
					go(i, j + 1, false, false, false, true, visited, disap + 1); // right
				else
					go(i, j + 1, false, false, false, true, visited, disap); // right
			}
		} else if (right) {
			if (first == 4) {
				if (f)
					go(i - 1, j, true, false, false, false, visited, disap + 1); // up
				else
					go(i - 1, j, true, false, false, false, visited, disap); // up
			} else if (first == 3) {
				if (f)
					go(i + 1, j, false, true, false, false, visited, disap + 1); // down
				else
					go(i + 1, j, false, true, false, false, visited, disap); // down
			} else {
				if (f)
					go(i, j - 1, false, false, true, false, visited, disap + 1); // left
				else
					go(i, j - 1, false, false, true, false, visited, disap); // left
			}
		}
		visited[i][j] = false;
		a[i][j]++;
	}
}
