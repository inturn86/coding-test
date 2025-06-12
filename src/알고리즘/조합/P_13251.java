package 알고리즘.조합;

import java.util.Scanner;

public class P_13251 {

//	문제
//	효빈이의 비밀 박스에는 조약돌이 N개 들어있다. 조약돌의 색상은 1부터 M까지 중의 하나이다.
//
//	비밀 박스에서 조약돌을 랜덤하게 K개 뽑았을 때, 뽑은 조약돌이 모두 같은 색일 확률을 구하는 프로그램을 작성하시오.
//
//			입력
//	첫째 줄에 M (1 ≤ M ≤ 50)이 주어진다.
//
//	둘째 줄에는 각 색상의 조약돌이 몇 개 있는지 주어진다. 각 색상의 조약돌 개수는 1보다 크거나 같고 50보다 작거나 같은 자연수이다.
//
//	셋째 줄에는 K가 주어진다. (1 ≤ K ≤ N)
//
//	출력
//	첫째 줄에 뽑은 조약돌이 모두 같은 색일 확률을 출력한다. 정답과의 절대/상대 오차는 10-9까지 허용한다.
//
//	예제 입력 1
//			1
//			13
//			8
//	예제 출력 1
//			1.0
//	예제 입력 2
//			2
//			5 7
//			1
//	예제 출력 2
//			1.0
//	예제 입력 3
//			3
//			5 6 7
//			2
//	예제 출력 3
//			0.3006535947712418
//	예제 입력 4
//			5
//			12 2 34 13 17
//			4
//	예제 출력 4
//			0.035028830818304504

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();

		int[] DM = new int[M];

		int T = 0;
		for(int i = 0; i < M; i++) {
			DM[i] = sc.nextInt();
			T += DM[i];
		}

		int K = sc.nextInt();

		double[] pr = new double[M];

		double result = 0;
		for(int i = 0; i < M; i++) {

			//선택 조약돌의 개수보다 현재 색 조약돌 개수가 적으면 모두 같은 색으로 뽑을 확률은 0
			if(DM[i] < K) {
				continue;
			}
			pr[i] = 1.0;
			for(int j = 0; j < K; j++) {
				pr[i] *= ((double) (DM[i] - j) / (T - j));
			}
			result += pr[i];
		}

		System.out.println(result);
	}
}
