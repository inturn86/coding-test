package test.codility.에라스토테네스;

public class CodingCountNonDivisibleTest {

//	You are given an array A consisting of N integers.
//
//	For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
//
//	For example, consider integer N = 5 and array A such that:
//
//	A[0] = 3
//	A[1] = 1
//	A[2] = 2
//	A[3] = 3
//	A[4] = 6
//	For the following elements:
//
//	A[0] = 3, the non-divisors are: 2, 6,
//	A[1] = 1, the non-divisors are: 3, 2, 3, 6,
//	A[2] = 2, the non-divisors are: 3, 3, 6,
//	A[3] = 3, the non-divisors are: 2, 6,
//	A[4] = 6, there aren't any non-divisors.
//	Write a function:
//
//	class Solution { public int[] solution(int[] A); }
//
//	that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
//
//	Result array should be returned as an array of integers.
//
//	For example, given:
//
//	A[0] = 3
//	A[1] = 1
//	A[2] = 2
//	A[3] = 3
//	A[4] = 6
//	the function should return [2, 4, 3, 2, 0], as explained above.
//
//	Write an efficient algorithm for the following assumptions:
//
//	N is an integer within the range [1..50,000];
//	each element of array A is an integer within the range [1..2 * N].

	public static void main(String[] args) {
		int[] i = {3,1,2,3,6};
		solution(i);
	}

	public static int[] solution(int[] A) {

		int N = A.length;
		int maxVal = 2 * N; // A[i]의 최대값
		int[] count = new int[maxVal + 1]; // 등장 횟수 저장

		// Step 1: A 배열의 숫자 빈도수 카운트
		for (int num : A) {
			count[num]++;
		}

		int[] result = new int[N];

		// Step 2: 각 숫자에 대해 비제수 개수 계산
		for (int i = 0; i < N; i++) {
			int num = A[i];
			int divisorCount = 0;

			// 약수 찾기 (O(√num))
			for (int d = 1; d * d <= num; d++) {
				if (num % d == 0) {
					divisorCount += count[d]; // d가 약수일 경우
					if (d != num / d) {
						divisorCount += count[num / d]; // num/d도 다른 약수일 경우
					}
				}
			}

			result[i] = N - divisorCount; // 비제수 개수 = 전체 개수 - 약수 개수
		}

		return result;
	}

//	각 숫자의 약수 찾기
//3 → 약수 (1, 3) → 등장 횟수 1 + 2 = 3 → 비제수 개수 5 - 3 = 2
//			1 → 약수 (1) → 등장 횟수 1 → 비제수 개수 5 - 1 = 4
//			2 → 약수 (1, 2) → 등장 횟수 1 + 1 = 2 → 비제수 개수 5 - 2 = 3
//			3 → 약수 (1, 3) → 등장 횟수 1 + 2 = 3 → 비제수 개수 5 - 3 = 2
//			6 → 약수 (1, 2, 3, 6) → 등장 횟수 1 + 1 + 2 + 1 = 5 → 비제수 개수 5 - 5 = 0
}
