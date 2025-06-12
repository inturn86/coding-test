package test.codility.피보나치의수;

import java.util.LinkedList;
import java.util.Queue;

public class CodingFibFrogTest {

	public static void main(String[] args) {
		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		solution(A);
	}

	public static int solution(int[] A) {

		int[] fib = new int[A.length];

		fib[0] = 1;
		fib[1] = 2;
		for(int i = 2; i < A.length; i++) {
			fib[i] = fib[i - 2] + fib[i - 1];
		}

		//bfs를 통해 구함.
		//int[0] = 현재 위치
		//int[1] = 이동 횟수

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{-1, 0});

		boolean[] visited = new boolean[A.length]; // 방문한 위치
		while (!q.isEmpty()) {

			int[] info = q.poll();
			int pos = info[0];
			int execCnt = info[1];

			for(int i = 0; i < fib.length; i++) {
				int nextPos = pos + fib[i];

				if(nextPos == A.length) {
					return execCnt+1;
				}

				if(nextPos < A.length && A[nextPos] == 1 && !visited[nextPos]) {
					visited[nextPos] = true;
					q.add(new int[]{nextPos, execCnt+1});
//					break;
				}
			}
		}

		return -1;
	}
}
