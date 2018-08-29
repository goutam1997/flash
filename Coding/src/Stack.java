
public class Stack {
	int top, size;
	private Object[] array;
	Stack(int sz) {
		top=-1;		size=sz;		array=new Object[sz];
	}
	boolean empty() {
		return top==-1;
	}
	Object top() {
		if(empty())		return Integer.MIN_VALUE;
		return array[top];
	}
	void push(Object e) {
		if(top==size)	System.out.println("Stack Overflow");
		array[++top]=e;
	}
	Object pop() {
		if(empty())		return Integer.MIN_VALUE;
		return array[top--];
	}
	public static void main(String[] args) {
		Stack s=new Stack(20);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		while(!s.empty()) {
			System.out.println(s.pop());
		}
		Stack s1=new Stack(20);
		s1.push("Goutam"); 		s1.push("Kundu"); 	s1.push("Piyush");
		while(!s1.empty()) {
			System.out.println(s1.pop());
		}
	}
}
