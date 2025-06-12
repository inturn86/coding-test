package 알고리즘.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

public class P_2178 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int N, M;

	static int[][] A;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();

			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}

		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}

	private static void BFS(int x, int y) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});

		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < dx.length; i++) {
				int nextX = cur[0] + dx[i];
				int nextY = cur[1] + dy[i];
				if(nextY < 0 || nextX < 0) {
					continue;
				}
				if(nextX >= N || nextY >= M) {
					continue;
				}
				if(visited[nextX][nextY]) {
					continue;
				}
				if(A[nextX][nextY] == 1 ) {
					visited[nextX][nextY] = true;
					q.offer(new int[]{nextX, nextY});
					A[nextX][nextY] = A[cur[0]][cur[1]] + 1;
				}
			}
		}
	}


}
