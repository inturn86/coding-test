package test;

import java.util.Stack;

public class DFSClass {

	static boolean[] vistied = new boolean[9];

	// 그림?��?�� 그래?��?�� ?��결상?���? 2차원 배열�? ?��?��
	// ?��?��?���? 각각?�� ?��?��번호�? ?�� ?�� ?���? 0번인?��?��?�� ?��무것?�� ?��?�� ?��?��?���? ?��각하?��면됩?��?��.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

	public static void main(String[] args) {
		dfs(1);
	}

	static void dfs(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;

		// 방문 ?��?�� 출력
		System.out.print(nodeIndex + " -> ");

		// 방문?�� ?��?��?�� ?��?��?�� ?��?�� 찾기
		for (int node : graph[nodeIndex]) {
			// ?��?��?�� ?��?���? 방문?�� ?��?�� ?��?���? DFS ?��?��
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}


	// DFS ?��?�� ?�� ?��?��
	static Stack<Integer> stack = new Stack<>();

	public void stack() {

		// ?��?�� ?��?���? ?��?��?�� ?��?��줍니?��.
		stack.push(1);
		// ?��?�� ?��?�� 방문처리
		vistied[1] = true;

		// ?��?��?�� 비어?���? ?��?���? 계속 반복
		while(!stack.isEmpty()) {

			// ?��?��?��?�� ?��?���? 꺼냅?��?��.
			int nodeIndex = stack.pop();

			// 방문 ?��?�� 출력
			System.out.print(nodeIndex + " -> ");

			// 꺼낸 ?��?��?? ?��?��?�� ?��?�� 찾기
			for (int LinkedNode : graph[nodeIndex]) {
				// ?��?��?�� ?��?���? 방문?���? ?��?��?�� 경우?�� ?��?��?�� ?���? 방문처리
				if(!vistied[LinkedNode]) {
					stack.push(LinkedNode);
					vistied[LinkedNode] = true;
				}
			}
		}
	}
}
