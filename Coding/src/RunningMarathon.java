
import java.util.*;

public class RunningMarathon {
	static int ans;

	static void getMinTime(int time[], int energy[], int D, int E, int total, int start) {
		// D is the remaining distance
		// E is the remaining energy
		// total is the time elapsed so far. We have to do this in minimum time
		if (D == 0) {
			ans = Math.min(ans, total);
			return;
		}
		if (total > ans)	// If total > already computed ans then return
			return;
		if (E == 0)		// If remaining energy is zero
			return;

		for (int i = start; i < 5; i++) {
			// i denotes the profile we are choosing
			for (int j = 1;; j++) {
				// j is the distance in km that can be traversed using ith profile
				if (E >= j * energy[i] && D >= j) {
					// Energy required for j km using ith profile is j*energy[i]
					// If remaining energy >= j*energy[i] and remaining distance >= j km
					getMinTime(time, energy, D - j, E - j * energy[i], total + j * time[i], i + 1);
				} else
					break;
			}   
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int a = 0; a < t; a++) {
			int E = sc.nextInt();
			int D = sc.nextInt();

			int min[] = new int[5];
			int sec[] = new int[5];
			int energy[] = new int[5];
			int time[] = new int[5];
			for (int i = 0; i < 5; i++) {
				min[i] = sc.nextInt();
				sec[i] = sc.nextInt();
				time[i] = min[i] * 60 + sec[i];
				energy[i] = sc.nextInt();
			}

			ans = Integer.MAX_VALUE;
			getMinTime(time, energy, D, E, 0, 0);
			int mns = ans / 60;
			int second = ans % 60;
			System.out.print(mns + " " + second);
			System.out.println();
		}
	}
}
