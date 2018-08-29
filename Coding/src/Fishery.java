import java.util.Scanner;

public class Fishery {
	static void go(boolean g1,boolean g2,boolean g3) {
		//coding
		if(g1==false) {
			go(true,g2,g3);
		}
		if(g2==false) {
			go(g1,true,g3);
		}
		if(g3==false) {
			go(g1,g2,true);
		}
		if(g1 && g2 && g3) {
			//base
			return;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		go(true,false,false);
		go(false,true,false);
		go(false,false,true);
	}

}