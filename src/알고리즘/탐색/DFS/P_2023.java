package 알고리즘.탐색.DFS;

import java.util.Scanner;

public class P_2023 {

//	문제
//	수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
//
//  7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
//
//	수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
//
//			입력
//	첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
//
//	출력
//	N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
//
//	예제 입력 1
//			4
//	예제 출력 1
//			2333
//			2339
//			2393
//			2399
//			2939
//			3119
//			3137
//			3733
//			3739
//			3793
//			3797
//			5939
//			7193
//			7331
//			7333
//			7393

	static int N;
	public static void main(String[] args) {
		//소수를 구하여 첫번쨰 자리부터 소수인지 여부 판별
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}

	//첫번째 자리수가 있고 순차적으로 자리수를 늘리면서 전진.
	private static void DFS(int sosu, int jari) {

		//자리수가 N이면 해당 소수 인지 확인 후 출력
		if(N == jari) {
			if(isPrime(sosu)) {
				System.out.println(sosu);
				return;
			}
		}

		int sosuJari = (sosu * 10);
		jari += 1;

		for(int i = 1; i < 10; i++) {
			int newSosu = sosuJari;
			newSosu += i;
			if(isPrime(newSosu)) {
				DFS(newSosu, jari);
			}
		}
	}

	//소수 판별. 루트 계산에 따른
	private static boolean isPrime(int num){
		for(int i=2; i<=num / 2; i++){
			if(num % i == 0) return false;
		}
		return true;
	}
}
