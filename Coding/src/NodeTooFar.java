import java.util.HashMap;
import java.util.Scanner;
class Queue1 {
	int front, rear, size, capacity;
	Object []array;
	Queue1(int sz) {
		front=size=0;
		capacity=sz;
		rear=capacity-1;
		array=new Object[capacity];
	}
	boolean empty() {
		return size==0;
	}
	void push(Object e) {
		if(size==capacity)	return;
		rear=(rear+1)%capacity;
		array[rear]=e;
		size++;
	}
	Object pop() {
		if(empty())	return Integer.MIN_VALUE;
		Object e=array[front];
		front=(front+1)%capacity;
		size--;
		return e;
	}
	Object front() {
		if(empty())		return Integer.MIN_VALUE;
		return array[front];
	}
}
class Pair {
	int x, y;
	Pair(int a, int b) {
		x=a;	y=b;
	}
}
public class NodeTooFar {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int caseno=1;
		while(true) {
			int nc=sc.nextInt();
			if(nc==0)	break;
			HashMap<Integer,Integer> h=new HashMap<>();
			Pair []p=new Pair[nc];
			int no=0;
			for(int i=0;i<nc;i++) {
				int u=sc.nextInt();	int v=sc.nextInt();
				if(h.containsKey(u)==false) {
					h.put(u, no);
					no++;
				}
				if(h.containsKey(v)==false) {
					h.put(v, no);
					no++;
				}
				p[i]=new Pair(h.get(u), h.get(v));
			}
			while(true) {
				int q=sc.nextInt();		int u=sc.nextInt();
				if(q==0 && u==0)	break;
				boolean []visited=new boolean[no];
				int noOfNodes=h.size();
				Queue1 s=new Queue1(100);
				int startnode=h.get(q);
				s.push(new Pair(startnode,u));
				while(!s.empty()) {
					Pair t=(Pair) s.pop();
					visited[t.x]=true;
					noOfNodes--;
					if(t.y>0) {
						for(int i=0;i<no;i++) {
							if(p[i].x==t.x && !visited[p[i].y])
								s.push(new Pair(p[i].y, t.y-1));
							if(p[i].y==t.x && !visited[p[i].x])
								s.push(new Pair(p[i].x, t.y-1));
						}
					}
				}
				System.out.println("Case "+caseno+": "+noOfNodes+" nodes are not reachable from node "+q+" with TTL = "+u);
				caseno++;
			}
		}
	}
}
