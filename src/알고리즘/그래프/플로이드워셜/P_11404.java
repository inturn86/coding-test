package 알고리즘.그래프.플로이드워셜;

import java.util.Scanner;

public class P_11404 {


	static int INF = 100000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cityCnt = sc.nextInt();
		int edgeCnt = sc.nextInt();

		int[][] disArr = new int[cityCnt + 1][cityCnt + 1];

		for(int i = 1; i <= cityCnt; i++) {
			for(int j = 1; j <= cityCnt; j++) {
				if(i == j) {
					disArr[i][j] = 0;
				}
				else {
					disArr[i][j] = INF;
				}
			}
		}

		for(int i = 0; i < edgeCnt; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int d = sc.nextInt();
			disArr[s][e] = Math.min(disArr[s][e], d);
		}

		for(int k = 1; k <= cityCnt; k++) {
			for(int i = 1; i <= cityCnt; i++) {
				for (int j = 1; j <= cityCnt; j++) {
					//플로이드 워셜 공식.
					disArr[i][j] = Math.min(disArr[i][j], disArr[i][k] + disArr[k][j]);
				}
			}
		}

		for(int i = 1; i <= cityCnt; i++) {
			for(int j = 1; j <= cityCnt; j++) {
				if(disArr[i][j] == INF) {
					System.out.print("0 ");
				}
				else {
					System.out.print(disArr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
