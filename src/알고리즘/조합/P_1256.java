package 알고리즘.조합;

import java.util.Scanner;

public class P_1256 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int aCnt = sc.nextInt();
		int zCnt = sc.nextInt();
		int k = sc.nextInt();
		int[][] A = new int[202][202];

		for(int i = 0; i <= 200; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) {
					A[i][j] = 1;
				}
				else {
					A[i][j] = A[i - 1][j - 1] + A[i - 1][j];
					if(A[i][j] > 1000000000) {
						A[i][j] = 1000000001;
					}
				}
			}
		}

		//만들 수 있는 조합의 수인지 확인
		if(A[aCnt + zCnt][zCnt] < k) {
			System.out.println("-1");
		}
		else {
			while (!(aCnt == 0 && zCnt == 0)) {
				if(A[aCnt - 1 + zCnt][zCnt] >= k) {
					System.out.print("a");
					aCnt--;
				}else {
					System.out.print("z");
					k = k - A[aCnt - 1 + zCnt][zCnt];
					zCnt--;
				}
			}
		}
	}
}
