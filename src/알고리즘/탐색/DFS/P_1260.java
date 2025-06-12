package 알고리즘.탐색.DFS;

import java.util.*;

public class P_1260 {


//	DFS와 BFS
//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	324402	129620	76526	38.502%
//	문제
//	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//	입력
//	첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
//	출력
//	첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
//
//	예제 입력 1
//			4 5 1
//			1 2
//			1 3
//			1 4
//			2 4
//			3 4
//	예제 출력 1
//			1 2 4 3
//			1 2 3 4
//	예제 입력 2
//			5 5 3
//			5 4
//			5 2
//			1 2
//			3 4
//			3 1
//	예제 출력 2
//			3 1 2 5 4
//			3 1 4 2 5
//	예제 입력 3
//			1000 1 1000
//			999 1000
//	예제 출력 3
//			1000 999
//			1000 999
//

	static boolean[] visited;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int edgeCnt = sc.nextInt();
		int sIdx = sc.nextInt();
		visited = new boolean[N + 1];
		A = new ArrayList[N + 1];

		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for(int i = 0; i < edgeCnt; i++) {

			int s = sc.nextInt();
			int e = sc.nextInt();

			A[s].add(e);
			A[e].add(s);
		}

		for(int i = 1; i < A.length; i++) {
			Collections.sort(A[i]);
		}

		dfs(sIdx);

		System.out.println();
		visited = new boolean[N + 1];

		bfs(sIdx);


	}

	private static void dfs(int s) {
		if(visited[s]) {
			return;
		}

		visited[s] = true;
		System.out.print(s);
		System.out.print(" ");
		for(int i : A[s]) {
			if(visited[i] == false) {
				dfs(i);
			}
		}
	}

	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int val = q.poll();
			System.out.print(val + " ");
			for(int i : A[val]) {
				if(visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
