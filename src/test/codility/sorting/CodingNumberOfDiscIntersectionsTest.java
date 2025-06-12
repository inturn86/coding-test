package test.codility.sorting;

import java.util.Arrays;

public class CodingNumberOfDiscIntersectionsTest {

	public static void main(String[] args) {
		int[] i = {1,5,2,1,4,0};
		solution(i);
	}

	public static int solution(int[] A) {

		int N = A.length;
		if (N < 2) return 0; // No intersections possible

		long[] left = new long[N];
		long[] right = new long[N];

		// 좌 / 우의 원의 위치를 표시
		for (int i = 0; i < N; i++) {
			left[i] = (long) i - A[i];  //int로는 해결이 안되 long으로
			right[i] = (long) i + A[i];
		}

		// sort 처리.
		Arrays.sort(left);
		Arrays.sort(right);

		int intersections = 0;
		int activeDiscs = 0;
		int j = 0; // left의 배열

		// Sweep through right[] array
		for (int i = 0; i < N; i++) {
			while (j < N && left[j] <= right[i]) {
				intersections += activeDiscs; // 순차적으로 포함되는 원의 갯수를 겹치는 구간에 넣음
				activeDiscs++;  // 겹치는 부분의 수
				j++;    //left의 포인터

				// Return early if the count exceeds the limit
				if (intersections > 10_000_000) {
					return -1;
				}
			}
			//i가 늘어나기에 현재 가지고있는 활성화 원 중 하나를 제거.
			activeDiscs--; // Remove the disc whose right boundary is reached
		}

		return intersections;
	}
}
