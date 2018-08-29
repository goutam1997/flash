import java.util.Scanner;

public class ClusterFilling {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int freq[];
	static int[][] a;
	static int n;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			n = sc.nextInt();
			a = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == 0 && !visited[i][j]) {
						freq = new int[6];
						dfsZero(i, j);
						int maxi = 0, maxIndex = 0;
						for (int i1 = 0; i1 < 6; i1++) {
//							System.out.println("freq["+i1+"]: "+freq[i1]);
							if(freq[i1]>=maxi) {
								maxi=freq[i1];	maxIndex=i1;
							}
						}
						putDfs(i, j, maxIndex);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
		}
	}

	private static void putDfs(int i, int j, int maxi) {
		// TODO Auto-generated method stub
		a[i][j] = maxi;
		for (int k = 0; k < 4; k++) {
			int row = i + dx[k], col = j + dy[k];
			if (safe(row, col) && a[row][col] == 0)
				putDfs(row, col, maxi);
		}
	}

	private static void dfsZero(int i, int j) {
		// TODO Auto-generated method stub
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int row = i + dx[k], col = j + dy[k];
			if (safe(row, col) && !visited[row][col]) {
				if (a[row][col] > 0)
					dfsPos(row, col);
				else
					dfsZero(row, col);
			}
		}
	}

	private static void dfsPos(int i, int j) {
		// TODO Auto-generated method stub
		freq[a[i][j]]++;		visited[i][j]=true;
		for (int k = 0; k < 4; k++) {
			int row = i + dx[k], col = j + dy[k];
			if (safe(row, col) && !visited[row][col] && a[row][col] == a[i][j]) {
				dfsPos(row, col);
			}
		}
		visited[i][j]=false;
	}

	private static boolean safe(int row, int col) {
		// TODO Auto-generated method stub
		return row >= 0 && row < n && col >= 0 && col < n;
	}
}
