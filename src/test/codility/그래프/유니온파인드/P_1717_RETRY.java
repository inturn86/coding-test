package test.codility.그래프.유니온파인드;

import java.util.Scanner;

public class P_1717_RETRY {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int q = sc.nextInt();

		int[] A = new int[N + 1];

		for(int i = 0; i < A.length; i++) {
			A[i] = i;
		}

		for(int i = 0; i < q; i++) {
			int question = sc.nextInt();
			int startNode = sc.nextInt();
			int endNode = sc.nextInt();

			//합집합 union
			if(question == 0) {
				union(A, startNode, endNode);
			}
			//find
			else {
				if(find(A, startNode) == find(A, endNode)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	public static void union (int[] A, int X, int Y) {

		X = find(A, X);
		Y = find(A, Y);

		//TODO - 해당문제는 X == Y를 사용하는 경우도 있는데 이건 왜 그럴까 ?
		if(A[Y] == X) {
			return;
		}

		// X / Y의 값을 연결해준다.
		A[Y] = X;
	}

	public static int find(int[] A, int target) {
		if(A[target] == target) return target;
		return find(A, A[target]);
	}
}
