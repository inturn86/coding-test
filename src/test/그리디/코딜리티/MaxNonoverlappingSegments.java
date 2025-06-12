package test.그리디.코딜리티;

public class MaxNonoverlappingSegments {

	public int solution(int[] A, int[] B) {

		int N = A.length;
		if (N == 0) return 0; // 빈 입력 처리

		int count = 1; // 첫 번째 세그먼트는 항상 선택
		int end = B[0]; // 현재 선택된 세그먼트의 종료 지점

		for (int i = 1; i < N; i++) {
			if (A[i] > end) { // 겹치지 않는 경우
				count++;
				end = B[i]; // 새롭게 선택한 세그먼트의 종료 지점 업데이트
			}
		}
		return count;
	}
}
