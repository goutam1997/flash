public class Queue {
	int front, rear, size, capacity;
	Object []array;
	Queue(int sz) {
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
	public static void main(String[] args) {
		Queue q=new Queue(100);
		q.push(1);	q.push(2); 	q.push(3); 	q.push(4); 	q.push(5);
		System.out.println(q.front());
		System.out.println(q.pop());
		System.out.println((q.front()));
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		
		Queue q1=new Queue(14);
		q1.push('A'); 	q1.push('B');  q1.push('C');
		System.out.println(q1.pop());
		q1.push('D'); 	q1.push('E');
		while(!q1.empty()) {
			System.out.println(q1.pop());
		}
		
		Queue u = new Queue(15);
		u.push("Goutam"); 	u.push("Kundu"); 	u.push("Suman"); 	
		while(!u.empty()) {
			System.out.println(u.pop());
		}
	}
}