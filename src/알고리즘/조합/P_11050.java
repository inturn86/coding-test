package 알고리즘.조합;

import java.util.Scanner;

public class P_11050 {

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


	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		arr = new int[n + 1][n +1];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i == j || (j == 0)) {
					arr[i][j] = 1;
				}
				else {
					if(j == 1) {
						arr[i][j] = i;
					}
				}
			}
		}

		for(int i = 3; i < arr.length; i++) {
			for(int j = 2; j < arr[i].length; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}

		System.out.println(arr[n][k]);
 	}
}
