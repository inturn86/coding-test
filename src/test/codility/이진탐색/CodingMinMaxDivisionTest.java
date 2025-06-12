package test.codility.이진탐색;

public class CodingMinMaxDivisionTest {

	public static void main(String[] args) {
		int K = 3;
		int M = 5;
		int[] A = {2,1,5,1,2,2,2};
		solution(K, M, A);
	}

	public static int solution(int K, int M, int[] A) {
		int left = 0, right = 0;
		for (int num : A) {
			left = Math.max(left, num); // 최소 블록 합: 배열의 최대값
			right += num; // 최대 블록 합: 배열의 총합
		}

		int result = right; // 최소 큰 합을 저장할 변수

		while (left <= right) {
			int mid = (left + right) / 2;

			if (canDivide(A, K, mid)) {
				result = mid;  // 더 작은 값도 가능한지 확인
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	private static boolean canDivide(int[] A, int K, int maxSum) {
		int blocks = 1;
		int currentSum = 0;

		for (int num : A) {
			if (currentSum + num > maxSum) {
				blocks++;  // 새로운 블록 시작
				currentSum = num;
				if (blocks > K) {
					return false;
				}
			} else {
				currentSum += num;
			}
		}

		return true;
	}
}