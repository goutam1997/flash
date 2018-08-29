import java.util.Scanner;

public class FindingRectangle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0;t<tc;t++) {
			int n=sc.nextInt();
			int [][]a=new int[n][n];
			for(int i=0;i<n;i++)	for(int j=0;j<n;j++)	a[i][j]=sc.nextInt();
			findRectangle(a, n);
		}
	}

	private static void findRectangle(int[][] a, int n) {
		// TODO Auto-generated method stub
		int row[]=new int[101];
		int col[]=new int[101];
//		for(int i=0;i<=100;i++)		
		int rec=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]>0) {
					int r,c;	
					go(a, i, j, n);		rec++;
				}
			}
		}
	}

	private static void go(int[][] a, int x, int y, int n) {
		// TODO Auto-generated method stub
		//if(x+1<n)
	}
}
