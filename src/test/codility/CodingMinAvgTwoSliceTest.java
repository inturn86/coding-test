package test.codility;

public class CodingMinAvgTwoSliceTest {

	//###구간합.

//	N개의 정수로 구성된 비어 있지 않은 배열 A가 주어집니다. 0 ≤ P < Q < N과 같은 정수 쌍(P, Q)을 배열 A의 슬라이스라고 합니다(슬라이스에 적어도 두 개의 요소가 포함됨). 슬라이스의 평균(P, Q)은 A[P] + A[P + 1] + ...의 합입니다... + A[Q]를 슬라이스 길이로 나눈 값입니다. 정확히 말하면, 평균은 (A[P] + A[P + 1] + ...과 같습니다... + A[Q]) / (Q - P + 1).
//
//	예를 들어 배열 A는 다음과 같습니다:
//
//	A[0] = 4
//	A[1] = 2
//	A[2] = 2
//	A[3] = 5
//	A[4] = 1
//	A[5] = 5
//	A[6] = 8
//	에는 다음 예제 조각이 포함되어 있습니다:
//
//	슬라이스(1, 2), 평균은 (2 + 2) / 2 = 2;
//	슬라이스(3, 4), 평균은 (5 + 1) / 2 = 3;
//	슬라이스(1, 4), 평균은 (2 + 2 + 5 + 1) / 4 = 2.5입니다.
//	목표는 평균이 최소인 슬라이스의 시작 위치를 찾는 것입니다.
//
//	함수 쓰기:
//
//	클래스 솔루션 {public int 솔루션(int[] A); }
//
//	N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 최소 평균으로 슬라이스의 시작 위치를 반환합니다. 최소 평균을 갖는 조각이 둘 이상 있으면 해당 조각의 가장 작은 시작 위치를 반환해야 합니다.
//
//	예를 들어 배열 A가 주어지면 다음과 같습니다:
//
//	A[0] = 4
//	A[1] = 2
//	A[2] = 2
//	A[3] = 5
//	A[4] = 1
//	A[5] = 5
//	A[6] = 8
//	함수는 위에서 설명한 대로 1을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성합니다:
//
//	N은 [2] 범위 내의 정수입니다..100,000];
//	배열 A의 각 요소는 [-10,000] 범위 내의 정수입니다..10,000].
	public static void main(String[] args) {
		int[] i = {4,2,2,5,1,5,8};
		solution(i);
	}

//	https://cheolhojung.github.io/posts/algorithm/Codility-MinAvgTwoSlice.html
//	https://lipcoder.tistory.com/195
	public static int solution(int[] A) {

		float minAvg = (A[0] + A[1]) / 2f;
		int minIndex = 0;
		for (int i = 2; i < A.length; i++) {
			float avg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
			if (minAvg > avg) {
				minAvg = avg;
				minIndex = i - 2;
			}

			avg = (A[i - 1] + A[i]) / 2f;
			if (minAvg > avg) {
				minAvg = avg;
				minIndex = i - 1;
			}
		}
		return minIndex;
	}

}
