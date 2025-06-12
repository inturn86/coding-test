package 알고리즘.조합;

import java.util.Scanner;

public class P_2775 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int f = 15;
		int h = 15;
		int[][] D = new int[f][h];
		for(int i = 0; i < h; i++) {
			D[0][i] = i;
		}

		for(int i = 1; i < f; i++) {
			for(int j = 1; j < h; j++) {
				D[i][j] = D[i-1][j] + D[i][j - 1];
			}
		}

		int q = sc.nextInt();

		for(int i = 0; i < q; i++) {
			int floor = sc.nextInt();
			int ho = sc.nextInt();
			System.out.println(D[floor][ho]);
		}

	}
}
