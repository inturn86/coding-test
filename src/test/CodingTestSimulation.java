package test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodingTestSimulation {

	public static void main(String[] args) {

		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		solution(A, B);

	}

	// ?•´?‹µ. ???´.
	public static int solutions(int[] A, int[] B) {
		Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int index = B.length - 1;

        for(int i = A.length-1 ; i>= 0; i--) {
            if(A[i] < B[index]) {
                index--;
                answer++;
            }
        }

        return answer;
	}

	// ?•ì°? ???´.
	public static int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0, ilen = A.length; i < ilen; i++) {

			int findIdx = 0;
			for (int j = 0, jlen = B.length; j < jlen; j++) {
				if (A[i] < B[j]) {
					answer++;
					findIdx = j;
					break;
				}
			}
			B = remove(B, findIdx);
		}

		return answer;
	}

	public static int[] remove(int[] B, int findIdx) {
		return IntStream.range(0, B.length).filter(o -> o != findIdx).map(o -> B[o]).toArray();
	}
}
