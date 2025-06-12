package test.동적계획법.코딜리티;

import java.util.Deque;
import java.util.LinkedList;

public class CodingTest {

	public static void main(String[] args) {
		int[] A = {1, -2, 0, 9, -1, -2};
		solution(A);
	}

	public static int solution(int[] A) {

		int N = A.length;
		int[] dp = new int[N];
		dp[0] = A[0];

		Deque<Integer> deque = new LinkedList<>();
		deque.add(0); // 첫 번째 인덱스를 추가

		for (int i = 1; i < N; i++) {
			// 슬라이딩 윈도우에서 범위를 벗어난 인덱스 제거
			while (!deque.isEmpty() && deque.peekFirst() < i - 6) {
				deque.pollFirst();
			}

			// 현재 위치의 점수 = A[i] + deque의 최대값(dp[deque.peekFirst()])
			dp[i] = A[i] + dp[deque.peekFirst()];

			// 새 값 추가: deque의 끝에서 작은 값들은 제거 (dp[i]가 더 크면 필요 없음)
			while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
				deque.pollLast();
			}

			deque.addLast(i);
		}

		return dp[N - 1];
	}
}
