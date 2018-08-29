import java.util.Scanner;
class Pari {
	int x,y;
	Pari(int a,int b) {
		x=a;	y=b;
	}
}
public class MrKim {
	static int n, visitedAll;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			n=sc.nextInt();
			int sx=sc.nextInt(), sy=sc.nextInt(), ex=sc.nextInt(), ey=sc.nextInt();
			Pari[] cust=new Pari[n];
			for(int i=0;i<n;i++) {
				int a=sc.nextInt(), b=sc.nextInt();
				cust[i]=new Pari(a,b);
			}
			visitedAll=(1<<n)-1;
			System.out.println("\n#"+(t+1)+" "+go(sx,sy,ex,ey,cust,n,0));
		}
	}

	private static int go(int sx, int sy, int ex, int ey, Pari[] cust, int n, int mask) {
		// TODO Auto-generated method stub
		if(mask==visitedAll) {
			return Math.abs(ex-sx)+Math.abs(ey-sy);
		}
		int ans=Integer.MAX_VALUE;
		for(int city=0;city<n;city++) {
			if((mask & (1<<city))==0) {
				int newAns=Math.abs(sx-cust[city].x) + Math.abs(sy-cust[city].y) + 
							go(cust[city].x, cust[city].y, ex, ey, cust, n, mask | (1<<city));
				ans=Math.min(ans, newAns);
			}
		}
		return ans;
	}
}
