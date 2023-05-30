package test.codility;

public class CodingTimeComplexityPermMissingEleTest {
//	N개의 다른 정수로 구성된 배열 A가 주어집니다. 배열에 [1] 범위의 정수가 포함되어 있습니다..(N + 1)], 즉 하나의 원소가 정확하게 결측되었음을 의미합니다.
//
//	당신의 목표는 사라진 요소를 찾는 것입니다.
//
//	함수 쓰기:
//
//	클래스 솔루션 {public int 솔루션(int[] A); }
//
//	배열 A가 주어지면 결측 요소의 값을 반환합니다.
//
//	예를 들어 배열 A가 주어지면 다음과 같습니다:
//
//	A[0] = 2
//	A[1] = 3
//	A[2] = 1
//	A[3] = 5
//	함수는 누락된 요소이므로 4를 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성합니다:
//
//	N은 [0] 범위 내의 정수입니다..100,000];
//	A의 요소는 모두 별개입니다;
//	배열 A의 각 요소는 [1] 범위 내의 정수입니다..(N + 1)].
	public static void main(String[] args) {
		int[] i = {1,2,4};
		int s = solution(i);
		System.out.println(s);
	}

	public static int solution(int[] A) {

		int answer = 0;

		int max = A.length + 1;
		int maxResult = 0;
		int arrResult = 0;
		for(int i = 1; i <= max; i++){
			maxResult += i;
		}
		for(int i = 0; i < A.length; i++){
			arrResult += A[i];
		}

		return maxResult - arrResult;
	}
}
