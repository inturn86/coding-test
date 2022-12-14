package test;

import java.util.Stack;

public class DFSClass {

	static boolean[] vistied = new boolean[9];

	// κ·Έλ¦Ό?? κ·Έλ?? ?°κ²°μ?λ₯? 2μ°¨μ λ°°μ΄λ‘? ??
	// ?Έ?±?€κ°? κ°κ°? ?Έ?λ²νΈκ°? ?  ? ?κ²? 0λ²μΈ?±?€? ?λ¬΄κ²? ?? ???Όκ³? ?κ°ν?λ©΄λ©??€.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

	public static void main(String[] args) {
		dfs(1);
	}

	static void dfs(int nodeIndex) {
		// λ°©λ¬Έ μ²λ¦¬
		vistied[nodeIndex] = true;

		// λ°©λ¬Έ ?Έ? μΆλ ₯
		System.out.print(nodeIndex + " -> ");

		// λ°©λ¬Έ? ?Έ?? ?Έ? ? ?Έ? μ°ΎκΈ°
		for (int node : graph[nodeIndex]) {
			// ?Έ? ? ?Έ?κ°? λ°©λ¬Έ? ? ?΄ ??€λ©? DFS ??
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}


	// DFS ?¬?© ?  ?€?
	static Stack<Integer> stack = new Stack<>();

	public void stack() {

		// ?? ?Έ?λ₯? ?€?? ?£?΄μ€λ?€.
		stack.push(1);
		// ?? ?Έ? λ°©λ¬Έμ²λ¦¬
		vistied[1] = true;

		// ?€??΄ λΉμ΄?μ§? ??Όλ©? κ³μ λ°λ³΅
		while(!stack.isEmpty()) {

			// ?€??? ??λ₯? κΊΌλ??€.
			int nodeIndex = stack.pop();

			// λ°©λ¬Έ ?Έ? μΆλ ₯
			System.out.print(nodeIndex + " -> ");

			// κΊΌλΈ ?Έ??? ?Έ? ? ?Έ? μ°ΎκΈ°
			for (int LinkedNode : graph[nodeIndex]) {
				// ?Έ? ? ?Έ?λ₯? λ°©λ¬Έ?μ§? ??? κ²½μ°? ?€?? ?£κ³? λ°©λ¬Έμ²λ¦¬
				if(!vistied[LinkedNode]) {
					stack.push(LinkedNode);
					vistied[LinkedNode] = true;
				}
			}
		}
	}
}
