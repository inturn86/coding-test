package 알고리즘.트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_11725 {

	static List<Integer>[] A;
	static boolean[] visited;

	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		A = new ArrayList[N + 1];

		result = new int[N + 1];

		for(int i = 0; i < A.length; i++) {
			A[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for(int i = 1; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			A[s].add(e);
			A[e].add(s);
		}

		dfs(1);

		for(int i = 2; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static void dfs(int v) {
//
		if(visited[v]) {
			return;
		}

		visited[v] = true;

		for(int i : A[v]) {

			if(!visited[i]) {
				result[i] = v;
				dfs(i);
			}
		}
	}
}
