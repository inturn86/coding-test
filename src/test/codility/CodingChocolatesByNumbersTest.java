package test.codility;

public class CodingChocolatesByNumbersTest {

//	Euclidean algorithm

//	두 개의 양의 정수 N과 M이 주어진다. 정수 N은 0에서 N-1까지 번호가 매겨진 원 안에 배열된 초콜릿의 수를 나타냅니다.
//
//	초콜릿을 먹기 시작합니다. 초콜릿을 먹고 나면 포장지만 남깁니다.
//
//0번 초콜릿을 먹는 것으로 시작합니다. 그런 다음 원에 있는 다음 M-1 초콜릿 또는 포장지를 생략하고 다음 것을 먹습니다.
//
//	더 정확히 말하면, 초콜릿 숫자 X를 먹었다면 다음에 숫자 (X + M) 모듈로 N(나누기의 나머지)이 있는 초콜릿을 먹을 것입니다.
//
//	빈 포장지를 만나면 식사를 중단합니다.
//
//	예를 들어, 주어진 정수 N = 10 및 M = 4. 다음 초콜릿을 먹게 됩니다: 0, 4, 8, 2, 6.
//
//	목표는 위의 규칙에 따라 먹을 초콜릿의 수를 세는 것입니다.
//
//	함수 작성:
//
//	class Solution { public int solution(int N, int M); }
//
//	두 개의 양의 정수 N과 M이 주어지면 먹을 초콜릿의 수를 반환합니다.
//
//	예를 들어 주어진 정수 N = 10 및 M = 4. 위에서 설명한 대로 함수는 5를 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
//
//	N 및 M은 [1..1,000,000,000] 범위 내의 정수입니다.
	public static void main(String[] args) {
		int N = 10, M = 4;
		//최소공약수
		System.out.println(solution(N, M));
	}

	public static int solution(int N, int M) {

		return N / gcdByDivision(N, M);
	}

	static int gcdByDivision(int A, int B) {
		if(A % B == 0) return B;
		else           return gcdByDivision(B, A % B);
	}
}
