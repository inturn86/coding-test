package 알고리즘.탐색.BFS;

import java.util.*;

public class P_11724 {

//	문제
//	방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
//	입력
//	첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
//			출력
//	첫째 줄에 연결 요소의 개수를 출력한다.
//
//	예제 입력 1
//			6 5
//			1 2
//			2 5
//			5 1
//			3 4
//			4 6
//	예제 출력 1
//			2
//	예제 입력 2
//			6 8
//			1 2
//			2 5
//			5 1
//			3 4
//			4 6
//			5 4
//			2 4
//			2 3
//	예제 출력 2
//			1



	static boolean[] visited;
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int edgeCnt = sc.nextInt();
		visited = new boolean[N + 1];
		A = new ArrayList[N + 1];

		List<Integer> s = new ArrayList<>();
		for(int i = 1; i <=  N; i++) {
			A[i] = new ArrayList<>();
		}

		for(int i = 0; i < edgeCnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			A[x].add(y);
			A[y].add(x);

		}

		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int v) {

		if(visited[v]) {
			return;
		}

		visited[v] = true;

		for(int i = 0; i < A[v].size(); i++) {
			int val = A[v].get(i);
			if(visited[val] == false) {
				dfs(val);
			}
		}
	}
}
