package test.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CodingTest_BFSDFS {

	static boolean[] visited;
	static ArrayList<Integer>[] nodes;
	public static void main(String[] args) {
		int i = 0;
		solution(i);
	}

	public static int solution(int i) {

		int answer = 0 ;

		return answer;
	}

	public static void dfs(int node) {
		visited[node] = true;

		for(int i : nodes[node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();

		visited[node] = true;
		q.add(node);

		while (!q.isEmpty()) {
			int idx = q.poll();

			for(int i : nodes[idx]) {
				if(!visited[idx]) {

					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
