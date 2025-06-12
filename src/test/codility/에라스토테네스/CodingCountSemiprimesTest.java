package test.codility.에라스토테네스;

import java.util.Arrays;

public class CodingCountSemiprimesTest {

//	소수는 정확히 두 개의 서로 다른 약수를 가진 양의 정수 X입니다: 1과 X. 처음 몇 개의 소수 정수는 2, 3, 5, 7, 11, 13입니다.
//
//	세미프라임은 두 개의 (반드시 구별되는 것은 아니지만) 소수의 곱인 자연수입니다. 처음 몇 개의 세미프라임은 4, 6, 9, 10, 14, 15, 21, 22, 25, 26입니다.
//
//	비어 있지 않은 배열 P와 Q가 각각 M개의 정수로 구성된 두 개의 배열이 주어집니다. 이 배열은 지정된 범위 내의 반소수 수에 대한 쿼리를 나타냅니다.
//
//	쿼리 K는 (P[K], Q[K]) 범위 내에서 반소수의 수를 찾아야 하며, 여기서 1 ≤ P[K] ≤ Q[K] ≤ N입니다.
//
//	예를 들어, 정수 N = 26과 배열 P, Q를 고려하면 다음과 같습니다:
//
//	P[0] = 1 Q[0] = 26
//	P[1] = 4 Q[1] = 10
//	P[2] = 16 Q[2] = 20
//	각 범위 내의 소수점 수는 다음과 같습니다:
//
//			(1, 26)은 10입니다,
//			(4, 10)은 4입니다,
//			(16, 20)은 0입니다.
//	함수를 작성합니다:
//
//	클래스 솔루션 {공개 int[] 솔루션(int N, int[] P, int[] Q); }
//
//	정수 N과 M개의 정수로 구성된 두 개의 비어 있지 않은 배열 P와 Q가 주어졌을 때, 모든 쿼리에 대한 연속적인 답변을 지정하는 M개의 요소로 구성된 배열을 반환합니다.
//
//	예를 들어, 정수 N = 26과 배열 P, Q가 주어지면 다음과 같이 됩니다:
//
//	P[0] = 1 Q[0] = 26
//	P[1] = 4 Q[1] = 10
//	P[2] = 16 Q[2] = 20
//	함수는 위에서 설명한 대로 [10, 4, 0] 값을 반환해야 합니다.
//
//	다음 가정을 위한 효율적인 알고리즘을 작성하세요:
//
//	N은 [1.50,000] 범위 내의 정수입니다;
//	M은 [1.30,000] 범위 내의 정수입니다;
//	배열 P와 Q의 각 요소는 [1..N] 범위 내의 정수입니다;
//	P[i] ≤ Q[i].

	public static void main(String[] args) {
		int N = 26;
		int[] P = {1,4,16};
		int[] Q = {26,10,20};
		solution(N, P, Q);
	}

	public static int[] solution(int N, int[] P, int[] Q) {

		boolean[] isMathPrime = new boolean[N + 1];
		Arrays.fill(isMathPrime, true);
		isMathPrime[0] = isMathPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			System.out.println("j + " + i);
			if (isMathPrime[i]) {
				//자신보다 큰수부터 시작
				for (int j = i + i; j <= N; j += i) {
					isMathPrime[j] = false;
				}
			}
		}


		boolean[] isSemiPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (isMathPrime[i]) {
				for (int j = i; j * i <= N; j++) {
					if (isMathPrime[j]) {
						isSemiPrime[i * j] = true;
					}
				}
			}
		}

		// 3. 세미프라임의 누적 합 (Prefix Sum)
		int[] semiPrimePrefix = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			semiPrimePrefix[i] = semiPrimePrefix[i - 1] + (isSemiPrime[i] ? 1 : 0);
		}

// 4. 쿼리 처리 (O(M))
		int M = P.length;
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			result[i] = semiPrimePrefix[Q[i]] - semiPrimePrefix[P[i] - 1];
		}

		return result;
	}
}
