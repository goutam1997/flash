import java.util.Scanner;

class Qu {
	int front, rear, size, capacity;
	Object[] array;

	Qu(int sz) {
		front = size = 0;
		capacity = sz;
		rear = capacity - 1;
		array = new Object[capacity];
	}

	boolean empty() {
		return size == 0;
	}

	void push(Object e) {
		if (size == capacity)
			return;
		rear = (rear + 1) % capacity;
		array[rear] = e;
		size++;
	}

	Object pop() {
		if (empty())
			return Integer.MIN_VALUE;
		Object e = array[front];
		front = (front + 1) % capacity;
		size--;
		return e;
	}

	Object front() {
		if (empty())
			return Integer.MIN_VALUE;
		return array[front];
	}
}

class Tripl {
	int x, y, z;

	Tripl(int a, int b, int c) {
		x = a;
		y = b;
		z = c;
	}
}

public class LaughingBomb {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int dx[] = { 1, 0, 0, -1 };
		int dy[] = { 0, 1, -1, 0 };
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[][] a = new int[n][m];
			boolean[][] visited = new boolean[n][m];
			int people = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] == 1)
						people++;
				}
			System.out.println("People: " + people);
			int time = 0;
			int sx = sc.nextInt(), sy = sc.nextInt();
			sx--;
			sy--;
			Qu q = new Qu(100);
			q.push(new Tripl(sx, sy, 1));
			while (!q.empty()) {
				Tripl r = (Tripl) q.pop();
				time = Math.max(time, r.z);
				if (!visited[r.x][r.y]) {
					people--;
					if (people == 0)
						break;
					visited[r.x][r.y] = true;
					a[r.x][r.y] = r.z;
					for (int k = 0; k < 4; k++) {
						int row = r.x + dx[k], col = r.y + dy[k];
						if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col] && a[row][col] == 1)
							q.push(new Tripl(row, col, r.z + 1));
					}
				}
			}
			System.out.println(time);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
		}
	}
}
