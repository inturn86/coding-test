package test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodingTestSimulation {

	public static void main(String[] args) {

		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		solution(A, B);

	}

	// 시뮬레이션 숫자 대결
//	먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
//	각 사원은 딱 한 번씩 경기를 합니다.
//	각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
//	만약 숫자가 같다면 누구도 승점을 얻지 않습니다.

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

	// 나의 해답.
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

	 public int solution3(int[] A, int[] B) {
	        int answer = 0;
			Arrays.sort(A);

			Arrays.sort(B);
			int aPoint = 0;
			int bPoint = 0;
			for(int i = 0; i < A.length; i++) {

				if(A[aPoint]>B[bPoint]){
					bPoint++;
				}else if(A[aPoint]==B[bPoint]){
					bPoint++;
				}else{
					aPoint++;
					bPoint++;
					answer++;
				}
			}
			return answer;
	    }

	public static int[] remove(int[] B, int findIdx) {
		return IntStream.range(0, B.length).filter(o -> o != findIdx).map(o -> B[o]).toArray();
	}
}
