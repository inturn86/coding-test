package 알고리즘.트리;

import java.util.*;

public class P_11725_RETRY {


	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		//노드 개수
		int N = sc.nextInt();

		result = new int[N + 1];
		visited = new boolean[N + 1];

		ArrayList<Integer>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		//인접 리스트 생성.
		for (int i = 1; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr[start].add(end);
			arr[end].add(start);
		}

		dfs(result, arr, 1);

		for(int i = 2; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static void dfs(int[] result, ArrayList<Integer>[] arr, int target) {

		if(visited[target]) {
			return;
		}

		visited[target] = true;

		ArrayList<Integer> nestArr = arr[target];

		for(int next : nestArr) {
			if(visited[next]) {
				continue;
			}
			result[next] = target;
			dfs(result, arr, next);
		}
	}
}
