package 알고리즘.조합;

import java.util.Scanner;

public class P_11050_RETRY {

//	이항 계수 1
//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	80823	52358	45273	64.581%
//	문제
//			자연수
//\(N\)과 정수
//\(K\)가 주어졌을 때 이항 계수
//\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
//
//	입력
//	첫째 줄에
//\(N\)과
//\(K\)가 주어진다. (1 ≤
//			\(N\) ≤ 10, 0 ≤
//			\(K\) ≤
//			\(N\))
//
//	출력
//
//\(\binom{N}{K}\)를 출력한다.
//
//	예제 입력 1
//			5 2
//	예제 출력 1
//			10



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//총 수의 개수
		int n = sc.nextInt();
		//총 선택 수
		int k = sc.nextInt();

		//i 개 중에 0개를 선택할 경우의 수
		//D[i][0] = 1;

		//i개 중에 i개를 선택할 경우의 수
		//D[i][i] = 1;

		//i개 중에 1개를 선택할 경우의 수
		//D[i][1] = i;
 		int[][] D = new int[n + 1][n + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(j == 0) {
					D[i][j] = 1;
				}
				else if(j == 1){
					D[i][j] = i;
				}
				else if(j == i) {
					D[i][j] = 1;
				}
				else {
					//숫자의 수보다 선택의 수가 많으면 넘어간다.
					if(i > j) {
						D[i][j] = D[i-1][j] + D[i-1][j-1];
					}
				}
			}
		}

		System.out.println(D[n][k]);
 	}
}
