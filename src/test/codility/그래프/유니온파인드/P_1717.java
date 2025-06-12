package test.codility.그래프.유니온파인드;

import java.util.Scanner;

public class P_1717 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int q = sc.nextInt();

		int[] A = new int[N + 1];

		for(int i = 1; i < N + 1; i++) {
			A[i] = i;
		}

		for(int i = 0; i < q; i++) {
			int question = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();

			//union
			if(question == 0) {
				union(A, X, Y);
			}
			//find
			else {
				if(find(A, X) == find(A, Y)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int[] A, int X, int Y) {
		X = find(A, X);
		Y = find(A, Y);

		if(X <= Y) {
			A[Y] = X;
		}
		else {
			A[X] = Y;
		}
	}

	private static int find(int[] A, int X) {
		if(A[X] == X) {
			return X;
		}
		//중요한 부분
		return A[X] = find(A, A[X]);
	}
}
