package 알고리즘.그래프.다익스트라;

import java.util.*;

public class P_1753 {

	static List<Node>[] A;
	static int[] result;
	static boolean[] visited;

	static int INF = 10000000;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		int sIdx = sc.nextInt();

		A = new ArrayList[N + 1];
		result = new int[N + 1];
		visited = new boolean[N + 1];

		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
			if(i == sIdx) {
				result[i] = 0;
			}
			else {
				result[i] = INF;
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>();

		for(int i = 1; i <= E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int d = sc.nextInt();

			Node node = new Node(e, d);
			A[s].add(node);
		}

		q.offer(new Node(sIdx, 0));

		while (!q.isEmpty()) {

			Node node = q.poll();

			int t = node.getT();
			if(visited[t] == true) {
				continue;
			}

			visited[t] = true;

			for(Node n : A[t]) {
//				int target = n.getT();
//				int dis = n.getD();
//				if (result[target] > result[node.getT()] + dis) {
//
//					result[target] = result[node.getT()] + dis;
//					q.add(new Node(target, result[target]));
//				}
				int target = n.getT();
				int min = Math.min(result[target], node.getD() + n.getD());
				result[target] = min;

				q.add(new Node(target, min));
			}
		}

		for(int i = 1; i <= N; i++) {
			if(visited[i]) {
				System.out.println(result[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}

	protected static class Node implements Comparable<Node>{
		protected int t;
		protected int d;

		public Node(int t, int d) {
			this.t = t;
			this.d = d;
		}

		public int getT() {
			return this.t;
		}

		public int getD() {
			return this.d;
		}

		@Override
		public int compareTo(Node o) {
			//d가 작은 순서대로 remove
			if(this.d > o.d)    return -1;
			else return 1;
		}

	}
}
