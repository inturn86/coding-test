package test.codility;

public class CodingCountingElementMaxCountersTest {

//	처음에는 0으로 설정된 N개의 카운터가 제공되며 다음 두 가지 작업을 수행할 수 있습니다:
//
//	증가(X) - 카운터 X가 1만큼 증가합니다,
//	max counter - 모든 카운터가 모든 카운터의 최대값으로 설정됩니다.
//	M 정수의 비어 있지 않은 배열 A가 제공됩니다. 이 배열은 연속적인 작업을 나타냅니다:
//
//	만약 A[K] = X가 1 ≤ X ≤ N이라면, 연산 K는 증가(X),
//	A[K] = N + 1이면 연산 K는 max 카운터입니다.
//	예를 들어, 정수 N = 5와 배열 A가 주어지면 다음과 같습니다:
//
//	A[0] = 3
//	A[1] = 4
//	A[2] = 4
//	A[3] = 6
//	A[4] = 1
//	A[5] = 4
//	A[6] = 4
//	각 연속 작동 후의 카운터 값은 다음과 같습니다:
//
//			(0, 0, 1, 0, 0)
//			(0, 0, 1, 1, 0)
//			(0, 0, 1, 2, 0)
//			(2, 2, 2, 2, 2)
//			(3, 2, 2, 2, 2)
//			(3, 2, 2, 3, 2)
//			(3, 2, 2, 4, 2)
//	목표는 모든 작업 후 모든 카운터의 값을 계산하는 것입니다.
//
//	함수 쓰기:
//
//	클래스 솔루션 {public int[] 솔루션(int N, int[] A); }
//
//	정수 N과 M 정수로 구성된 비어 있지 않은 배열 A가 주어지면 카운터 값을 나타내는 정수 시퀀스를 반환합니다.
//
//	결과 배열은 정수 배열로 반환되어야 합니다.
//
//	예를 들어, 다음과 같습니다:
//
//	A[0] = 3
//	A[1] = 4
//	A[2] = 4
//	A[3] = 6
//	A[4] = 1
//	A[5] = 4
//	A[6] = 4
//	함수는 위에서 설명한 대로 [3, 2, 2, 4, 2]를 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성합니다:
//
//	N과 M은 [1] 범위 내의 정수입니다..100,000];
//	배열 A의 각 요소는 [1] 범위 내의 정수입니다..N + 1].

	public static void main(String[] args) {
		int N = 0;
		int[] A = {1,2,3};
		solution(N, A);
	}

	public static int[] solution(int N, int[] A) {

		int answer = 0 ;

		int[] result = new int[N];
		int max = 0;
		int currentMax = 0;

		for(int i = 0, len = A.length; i < len; i++){
			int val = A[i];
			//MAX
			if(val == N + 1){
				//이걸 안넣으면 됨.
//				for(int j = 0, jlen = result.length; j < jlen; j++){
//					result[j] = max;
//				}
				currentMax = max;
			}
			// ++
			else{
				int targetVal = result[A[i] - 1];

				//현재의 max보다 작으면
				if(targetVal < currentMax){
					targetVal = currentMax;
				}

				if(targetVal + 1 > max){
					max = targetVal + 1;
				}
				result[A[i] - 1] = targetVal + 1 ;
			}
		}

		for(int j = 0, jlen = result.length; j < jlen; j++){
			if(result[j] < currentMax)  result[j] = currentMax;
		}

		return result;
	}
}
