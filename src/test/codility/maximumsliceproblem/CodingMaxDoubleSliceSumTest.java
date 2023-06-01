package test.codility.maximumsliceproblem;

public class CodingMaxDoubleSliceSumTest {

//	N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
//
//0 ≤ X < Y < Z < N인 삼중선(X, Y, Z)을 이중 슬라이스라고 합니다.
//
//	이중 슬라이스(X, Y, Z)의 합은 A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[ Y + 2] + ... + A[Z - 1].
//
//	예를 들어 배열 A는 다음과 같습니다.
//
//	A[0] = 3
//	A[1] = 2
//	A[2] = 6
//	A[3] = -1
//	A[4] = 4
//	A[5] = 5
//	A[6] = -1
//	A[7] = 2
//	다음 예제 이중 슬라이스를 포함합니다.
//
//			더블 슬라이스(0, 3, 6), 합계는 2 + 6 + 4 + 5 = 17,
//	이중 슬라이스(0, 3, 7), 합계는 2 + 6 + 4 + 5 − 1 = 16,
//	이중 슬라이스(3, 4, 5), 합계는 0입니다.
//	목표는 더블 슬라이스의 최대 합을 찾는 것입니다.
//
//	함수 작성:
//
//	class Solution { public int solution(int[] A); }
//
//	N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 이중 슬라이스의 최대 합계를 반환합니다.
//
//	예를 들면 다음과 같습니다.
//
//	A[0] = 3
//	A[1] = 2
//	A[2] = 6
//	A[3] = -1
//	A[4] = 4
//	A[5] = 5
//	A[6] = -1
//	A[7] = 2
//	배열 A의 이중 슬라이스의 합이 17보다 크지 않기 때문에 함수는 17을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
//
//	N은 [3..100,000] 범위 내의 정수이고;
//	배열 A의 각 요소는 [-10,000..10,000] 범위 내의 정수입니다.

	public static void main(String[] args) {
		int[] i = {3,2,6,-1,4,5,-1,2};
		solution(i);
	}

	public static int solution(int[] A) {

		int[] leftSum = new int[A.length];
		int[] rightSum = new int[A.length];


		for(int i = 1; i < A.length - 1; i++){
			leftSum[i] = Math.max(0, leftSum[i - 1] + A[i]);
		}

		for(int i = A.length - 2; i >= 1 ; i--){
			rightSum[i] = Math.max(0, rightSum[i + 1] + A[i]);
		}

		int maxSum = 0;
		for(int i = 1, len = A.length - 1; i < len; i++){
			maxSum = Math.max(maxSum, leftSum[i - 1] + rightSum[i + 1]);
		}

		return maxSum;
	}

	//풀이
//	주어진 배열 A를 예를 들면 0번 인덱스와 7번 인덱스는 어떠한 경우에도 포함되지 않는다. 따라서 인덱스 1번과 6번 사이에서 가능한 최대 부분합을 구하면되는데, (X,Y,Z)에서 Y 인덱스 값은 부분합에 포함되지 않아야 한다.
//
//
//
//	따라서 Y를 기준으로 앞쪽으로 부분합 배열을 하나 만들고, 뒷쪽으로 부분합 배열을 하나 만들어서 두 배열을 합한 값이 가장 큰 값을 return하면 된다.
//
//
//			Math.max(0, value)처럼 0과 비교해 주는 이유는, X,Y가 인접한 경우와 Y,Z가 인접한 경우 값이 0이므로 값으로 넣을 수 있는 가장 작은 값이다. 따라서 0과 이전 인덱스 까지의 최대 부분합 + 현재 인덱스 값과 비교해서 더 큰 값을 넣어준다.
}

