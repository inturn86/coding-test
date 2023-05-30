package test.codility;

import java.util.HashSet;
import java.util.Set;

public class CodingTimeComplexityTapeEquilibriumTest {

//	N개의 정수로 구성된 비어 있지 않은 배열 A가 주어집니다. 배열 A는 테이프의 숫자를 나타냅니다.
//
//0 < P < N과 같은 임의의 정수 P는 이 테이프를 비어 있지 않은 두 부분으로 나눕니다: A[0], A[1], ..., A[P - 1] 및 A[P], A[P + 1], ..., A[N - 1].
//
//	두 부분의 차이는 다음 값입니다. |(A[0] + A[1] + ... + A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1] |
//
//	즉, 첫 번째 부분의 합과 두 번째 부분의 합의 절대적인 차이입니다.
//
//	예를 들어, 다음과 같은 방식으로 배열 A를 고려합니다:
//
//	A[0] = 3
//	A[1] = 1
//	A[2] = 2
//	A[3] = 4
//	A[4] = 3
//	이 테이프는 네 곳으로 나눌 수 있습니다:
//
//	P = 1, 차이 = |3 - 10 | = 7
//	P = 2, 차이 = |4 - 9 | = 5
//	P = 3, 차이 = |6 - 7 | = 1
//	P = 4, 차이 = |10 - 3 | = 7
//	함수 쓰기:
//
//	클래스 솔루션 {public int 솔루션(int[] A); }
//
//	N개 정수의 비어 있지 않은 배열 A가 주어지면 달성할 수 있는 최소 차이를 반환합니다.
//
//	예를 들어, 다음과 같습니다:
//
//	A[0] = 3
//	A[1] = 1
//	A[2] = 2
//	A[3] = 4
//	A[4] = 3
//	함수는 위에서 설명한 대로 1을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성합니다:
//
//	N은 [2] 범위 내의 정수입니다..100,000];
//	배열 A의 각 요소는 [-1,000...1,000] 범위 내의 정수입니다.

	public static void main(String[] args) {
		int[] i = {10, -10};
		solution(i);
	}

	public static int solution(int[] A) {

		int answer = 0;
		Set<Integer> re = new HashSet<>();

		int leftResult = A[0];
		int rightResult = 0;
		for(int i = 1, len = A.length; i < len; i++){
			rightResult += A[i];
		}
		re.add(Math.abs(leftResult - rightResult));
		//끝까지 돌아가지 않게 하는 부분 확인.
		for(int i = 1, len = A.length; i < len-1; i++){
			leftResult += A[i];
			rightResult -= A[i];
			re.add(Math.abs(leftResult - rightResult));
		}
		;
		return re.stream().min(Integer::compare).get();
	}
}
