import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS_Up_Down {
	int V;
	static int ans=0;
	LinkedList<Integer> AdjList[];

	@SuppressWarnings("unchecked")
	DFS_Up_Down(int v) {
		V = v;
		AdjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			AdjList[i] = new LinkedList<>();
		}
	}

	void addEdge(int u, int v) {
		AdjList[u].add(v);
		AdjList[v].add(u);
	}

	void DFS_up(boolean visited[], int cur, int total) {
		if (cur == 0) {
			ans = Math.max(ans, total);
			return;
		}
		for (int neighbour : AdjList[cur]) {
			if (!visited[neighbour] && neighbour < cur) {
				visited[neighbour] = true;
				DFS_up(visited, neighbour, total + 1);
				visited[neighbour] = false;
			}
		}
	}

	void DFS_down(boolean visited[], int cur, int total, int n) {
		if (cur == n - 1) {
			DFS_up(visited, n - 1, total);
			return;
		}
		for (int neighbour : AdjList[cur]) {
			if (!visited[neighbour] && neighbour > cur) {
				visited[neighbour] = true;
				DFS_down(visited, neighbour, total + 1, n);
				visited[neighbour] = false;
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int a = 0; a < T; a++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			DFS_Up_Down g = new DFS_Up_Down(n);
			ans = 0;
			boolean visited[] = new boolean[n];
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int count = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				hm.put(s, count);
				count++;
			}
			/*for(int i=0;i<hm.size();i++)
			{
				System.out.println(hm.get(i));
			}*/
			for (int i = 0; i < m; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				/*String []city=new String[2];
				String []splitted=s.split(" ");
				StringBuilder start = new StringBuilder();
				int index=0;
				for(index=0;index < splitted.length;index++) {
					start = start.append(splitted[index]);
					if(hm.containsKey(start)) {
						city[0]=start.toString();
						break;
					}
					start=start.append(" ");
					System.out.println("Start: "+start);
				}
				StringBuilder start1 = new StringBuilder();
				for(int k=index+1;k<splitted.length;k++) {
					start1=start1.append(splitted[k]);
					if(k!=index-1)
						start1=start1.append(" ");
				}
				city[1]=start1.toString();
				System.out.println("1st city: "+city[0]+" 2nd city: "+city[1]);
				g.addEdge(hm.get(city[0]), hm.get(city[1]));*/
				g.addEdge(hm.get(s1), hm.get(s2));
			}
			g.DFS_down(visited, 0, 0, n);
			System.out.println(ans);
		}
	}
}
