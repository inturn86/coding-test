package test.codility.피보나치의수;

public class CodingLadderTest {

	public static void main(String[] args) {
		int[] A = {4,4,5,5,1};
		int[] B = {3,2,4,3,1};
		solution(A, B);
	}

	public static int[] solution(int[] A, int[] B) {

		int[] fib = new int[A.length];
		int[] result = new int[A.length];
		int max = (int)Math.pow(2, 30);
		fib[0] = 1;
		fib[1] = 2;
		for(int i = 2; i < A.length; i++) {
			fib[i] = (fib[i - 2] + fib[i - 1]) % max;
		}

		for(int i = 0; i < B.length; i++) {
			result[i] = fib[A[i] - 1] % (int)Math.pow(2, B[i]);
		}

		return result;
	}
}
