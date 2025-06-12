package test.codility.유클리드호제법;

import java.util.*;

public class CodingCommonPrimeDivisorsTest {

//	소수는 정확히 두 개의 서로 다른 약수를 가진 양의 정수 X입니다: 1과 X. 처음 몇 개의 소수 정수는 2, 3, 5, 7, 11, 13입니다.
//
//	소수 D는 양의 정수 K가 존재하여 D * K = P가 되는 경우, 양의 정수 P의 소수라고 불립니다. 예를 들어, 2와 5는 20의 소수입니다.
//
//	두 개의 양의 정수 N과 M이 주어집니다. 목표는 정수 N과 M의 소인수 집합이 정확히 동일한지 확인하는 것입니다.
//
//	예를 들어, 주어진:
//
//	N = 15와 M = 75의 소수점은 동일합니다: {3, 5};
//	N = 10과 M = 30의 소수점은 같지 않습니다: {2, 5}는 {2, 3, 5}와 같지 않습니다;
//	N = 9와 M = 5의 소수점은 같지 않습니다: {3}은 {5}와 같지 않습니다.
//	함수를 작성합니다:
//
//	클래스 솔루션 {공공 int 솔루션(int[] A, int[] B); }
//
//	두 개의 비어 있지 않은 Z 정수 배열 A와 B가 주어졌을 때, A[K]와 B[K]의 소수점이 정확히 같은 위치 K의 수를 반환합니다.
//
//	예를 들어, 주어진:
//
//	A[0] = 15 B[0] = 75
//	A[1] = 10 B[1] = 30
//	A[2] = 3 B[2] = 5
//	함수는 1을 반환해야 합니다. 왜냐하면 한 쌍(15, 75)만이 동일한 소수점을 가지고 있기 때문입니다.
//
//	다음 가정을 위한 효율적인 알고리즘을 작성하세요:
//
//	Z는 [1.6,000] 범위 내의 정수입니다;
//	배열 A와 B의 각 요소는 [1..2,147,483,647] 범위 내의 정수입니다.

	public static void main(String[] args) {
		int[] A = {15, 10, 3};
		int[] B = {75, 30, 5};
		solution(A, B);
	}

	public static int solution(int[] A, int[] B) {
		int count = 0;

		for(int i = 0; i < A.length; i++) {
			if(hasSamePrimeDiv(A[i], B[i])) {
				count++;
			}
		}
		return count;
	}

	private static int gcd(int A, int B){
		if(B == 0) {
			return A;
		}
		else {
			return gcd(B, A % B);
		}
	}


//	먼저, 두 수의 최대 공약수를 구해 준 후, 각 수를 최대 공약수와의 최대 공약수를 다시 구해주면된다.
//
//	그리고 나서 각 수를 구한 최대 공약수로 나눈 후 다시 그 값과 위의 최대 공약수로 다시 최대공약수를 구해서 과정을 반복하면 된다.
//
//	그리고 나서 gcd가 1이 되었을 때 값이 1이 아니라면 그 수가 공통되지 않은 인수가 된다. 이 시점에서 이미 공통되지 않는다는 사실이 나왔으므로 이 공통되지 않은 인수 값이 소수인지 아닌지를 판별할 필요는 없다.
//
//
//	결론은 각 수의 인수가 두 수의 최대 공약수의 인수와 같다면 인수가 같은 것으로 보면된다.
	private static boolean hasSamePrimeDiv(int A, int B) {
		int gcd = gcd(A, B);
		int gcdA = 0;
		int gcdB = 0;

		while(gcdA != 1) {
			gcdA = gcd(A, gcd);
			A = A / gcdA;
		}

		while(gcdB != 1) {
			gcdB = gcd(B, gcd);
			B = B / gcdB;
		}

		return (A == 1 && B == 1)? true : false;
	}

}
