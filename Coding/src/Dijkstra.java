import java.util.Scanner;
class Pair1 {
	int x,y;
	Pair1(int a,int b) {
		x=a;	y=b;
	}
}
public class Dijkstra {
	static int dx[]= {1,0,0,-1};
	static int dy[]= {0,1,-1,0};
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			//int n=sc.nextInt(), m=sc.nextInt();
			int [][]a={ 
			        { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
			        { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			        { 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			        { 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
			        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
			    };
			/*for(int i=0;i<n;i++)	for(int j=0;j<m;j++) {	
				a[i][j]=sc.nextInt();
			}*/
			int n=a.length, m=a[0].length;
			dijkstra(a,n,m);
		}
	}
	private static void dijkstra(int[][] a, int n, int m) {
		// TODO Auto-generated method stub
		int [][]dis=new int[n][m];
		for(int i=0;i<n;i++)	for(int j=0;j<m;j++)	dis[i][j]=Integer.MAX_VALUE;
		boolean [][]done=new boolean[n][m];
		dis[0][0]=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				Pair1 u=minVertex(dis, done, n, m);
				done[u.x][u.y]=true;
				for(int k=0;k<4;k++) {
					int row=u.x+dx[k], col=u.y+dy[k];
					if(row>=0 && row<n && col>=0 && col<m && !done[row][col] && dis[u.x][u.y]+a[row][col]<dis[row][col])
						dis[row][col]=dis[u.x][u.y]+a[row][col];
				}
			}
		}
		System.out.println(dis[n-1][m-1]);
	}
	private static Pair1 minVertex(int[][] dis, boolean[][] done, int n, int m) {
		// TODO Auto-generated method stub
		int mini=Integer.MAX_VALUE, sx = 0, sy = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!done[i][j] && dis[i][j]<mini) {
					sx=i;	sy=j;	mini=dis[i][j];
				}
			}
		}
		return new Pair1(sx,sy);
	}
}
