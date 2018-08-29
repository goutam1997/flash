import java.util.Scanner;

class Q {
	int front,rear,capacity,size;
	Object []array;
	Q(int sz) {
		capacity=sz;
		front=size=0;
		rear=capacity-1;
		array=new Object[capacity];
	}
	boolean empty() {
		return size==0;
	}
	Object front() {
		if(empty())		return Integer.MIN_VALUE;
		return array[front];
	}
	void push(Object e) {
		if(size==capacity)		return ;
		rear=(rear+1)%capacity;
		array[rear]=e;
		size++;
	}
	Object pop() {
		if(empty())		return Integer.MIN_VALUE;
		Object item=array[front];
		front=(front+1)%capacity;
		size--;
		return item;
	}
}
class Triplet {
	int x,y,z;
	Triplet(int a,int b,int c) {
		x=a;	y=b;	z=c;
	}
}
public class KnightTour {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []dx= {1,1,-1,-1,2,2,-2,-2};
		int []dy= {2,-2,2,-2,1,-1,1,-1};
		int n=sc.nextInt(), m=sc.nextInt(), sx=sc.nextInt(), sy=sc.nextInt();
		int ex=sc.nextInt(), ey=sc.nextInt();
		sx--;	sy--;	ex--;	ey--;
		Q q=new Q(100);
		q.push(new Triplet(sx,sy,0));
		boolean [][]visited=new boolean[n][m];
		int ans=Integer.MAX_VALUE;
		while(!q.empty()) {
			Triplet t=(Triplet) q.pop();
			if(t.x==ex && t.y==ey) {
				ans=Math.min(ans, t.z); 		continue;
			}
			visited[t.x][t.y]=true;
			for(int k=0;k<8;k++) {
				int row=t.x+dx[k], col=t.y+dy[k];
				if(row>=0 && row<n && col>=0 && col<m && !visited[row][col])
					q.push(new Triplet(row, col, t.z+1));
			}
		}
		System.out.println(ans);
	}
}
