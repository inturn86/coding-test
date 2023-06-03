package test.codility.primeandcompositenumbers;

public class CodingFlagsTest {

	//문제
//	https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/start/

//	N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
//
//	피크는 이웃보다 큰 배열 요소입니다. 보다 정확하게는 0 < P < N − 1이고 A[P − 1] < A[P] > A[P + 1]인 인덱스 P입니다.
//
//	예를 들어, 다음 배열 A:
//
//	A[0] = 1
//	A[1] = 5
//	A[2] = 3
//	A[3] = 4
//	A[4] = 3
//	A[5] = 4
//	A[6] = 1
//	A[7] = 2
//	A[8] = 3
//	A[9] = 4
//	A[10] = 6
//	A[11] = 2
//	정확히 4개의 피크(요소 1, 3, 5 및 10)가 있습니다.
//
//	아래 그림과 같이 상대 높이가 배열 A로 표시되는 산 범위로 여행을 떠납니다. 얼마나 많은 깃발을 가져갈 것인지 선택해야 합니다. 목표는 특정 규칙에 따라 봉우리에 최대 플래그 수를 설정하는 것입니다.
//
//
//
//	플래그는 피크에만 설정할 수 있습니다. 게다가 K 플래그를 사용하는 경우 두 플래그 사이의 거리는 K보다 크거나 같아야 합니다. 인덱스 P와 Q 사이의 거리는 절대값 |P − Q|입니다.
//
//	예를 들어 위의 배열 A로 표시된 산맥이 주어지고 N = 12인 경우 다음을 취합니다.
//
//	두 개의 플래그는 피크 1과 5에 설정할 수 있습니다.
//	세 개의 플래그, 피크 1, 5 및 10에 설정할 수 있습니다.
//	플래그가 4개인 경우 피크 1, 5 및 10에 3개의 플래그만 설정할 수 있습니다.
//	따라서 이 경우 최대 3개의 플래그를 설정할 수 있습니다.
//
//	함수 작성:
//
//	class Solution { public int solution(int[] A); }
//
//	N 정수의 비어 있지 않은 배열 A가 주어지면 배열의 피크에 설정할 수 있는 플래그의 최대 수를 반환합니다.
//
//	예를 들어, 다음 배열 A:
//
//	A[0] = 1
//	A[1] = 5
//	A[2] = 3
//	A[3] = 4
//	A[4] = 3
//	A[5] = 4
//	A[6] = 1
//	A[7] = 2
//	A[8] = 3
//	A[9] = 4
//	A[10] = 6
//	A[11] = 2
//	함수는 위에서 설명한 대로 3을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
//
//	N은 [1..400,000] 범위 내의 정수이고;
//	배열 A의 각 요소는 [0..1,000,000,000] 범위 내의 정수입니다.

	public static void main(String[] args) {
		int[] i = {1,5,3,4,3,4,1,2,3,4,6,2};
		solution(i);
	}

	public static int solution(int[] A) {

		int result = 0;
		boolean[] peaks = getPeaks(A);
		int[] nextPeaks = getNextPeaks(peaks);
		for (int idx = 1; idx < A.length; idx++) {
			if (isPossibleToSetOnPeak(nextPeaks, idx)) {
				result = Math.max(result, idx);
			}
		}
		return result;
	}
	private static boolean[] getPeaks(int[] A) {
		boolean[] peaks = new boolean[A.length];
		for (int idx = 1; idx < A.length - 1; idx++) {
			if (A[idx] > A[idx - 1] && A[idx] > A[idx + 1]) {
				peaks[idx] = true;
			}
		}
		return peaks;
	}
	private static int[] getNextPeaks(boolean[] peaks) {
		int[] nextPeaks = new int[peaks.length];
		int nextPeak = -1;
		for (int idx = nextPeaks.length - 1; idx >= 0; idx--) {
			if (peaks[idx]) {
				nextPeak = idx;
			}
			nextPeaks[idx] = nextPeak;
		}
		return nextPeaks;
	}
	private static boolean isPossibleToSetOnPeak(int[] nextPeaks, int point) {
		int index = 0;
		for (int idx = 0; idx < point; idx++) {
			if (index >= nextPeaks.length || nextPeaks[index] < 0) {
				return false;
			}
			index = nextPeaks[index] + point;
		}
		return true;
	}
}
