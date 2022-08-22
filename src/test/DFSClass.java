package test;

import java.util.Stack;

public class DFSClass {

	static boolean[] vistied = new boolean[9];

	// ê·¸ë¦¼?˜ˆ?‹œ ê·¸ë˜?”„?˜ ?—°ê²°ìƒ?ƒœë¥? 2ì°¨ì› ë°°ì—´ë¡? ?‘œ?˜„
	// ?¸?±?Š¤ê°? ê°ê°?˜ ?…¸?“œë²ˆí˜¸ê°? ?  ?ˆ˜ ?ˆê²? 0ë²ˆì¸?±?Š¤?Š” ?•„ë¬´ê²ƒ?„ ?—†?Š” ?ƒ?ƒœ?¼ê³? ?ƒê°í•˜?‹œë©´ë©?‹ˆ?‹¤.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

	public static void main(String[] args) {
		dfs(1);
	}

	static void dfs(int nodeIndex) {
		// ë°©ë¬¸ ì²˜ë¦¬
		vistied[nodeIndex] = true;

		// ë°©ë¬¸ ?…¸?“œ ì¶œë ¥
		System.out.print(nodeIndex + " -> ");

		// ë°©ë¬¸?•œ ?…¸?“œ?— ?¸? ‘?•œ ?…¸?“œ ì°¾ê¸°
		for (int node : graph[nodeIndex]) {
			// ?¸? ‘?•œ ?…¸?“œê°? ë°©ë¬¸?•œ ? ?´ ?—†?‹¤ë©? DFS ?ˆ˜?–‰
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}


	// DFS ?‚¬?š© ?•  ?Š¤?ƒ
	static Stack<Integer> stack = new Stack<>();

	public void stack() {

		// ?‹œ?‘ ?…¸?“œë¥? ?Š¤?ƒ?— ?„£?–´ì¤ë‹ˆ?‹¤.
		stack.push(1);
		// ?‹œ?‘ ?…¸?“œ ë°©ë¬¸ì²˜ë¦¬
		vistied[1] = true;

		// ?Š¤?ƒ?´ ë¹„ì–´?ˆì§? ?•Š?œ¼ë©? ê³„ì† ë°˜ë³µ
		while(!stack.isEmpty()) {

			// ?Š¤?ƒ?—?„œ ?•˜?‚˜ë¥? êº¼ëƒ…?‹ˆ?‹¤.
			int nodeIndex = stack.pop();

			// ë°©ë¬¸ ?…¸?“œ ì¶œë ¥
			System.out.print(nodeIndex + " -> ");

			// êº¼ë‚¸ ?…¸?“œ?? ?¸? ‘?•œ ?…¸?“œ ì°¾ê¸°
			for (int LinkedNode : graph[nodeIndex]) {
				// ?¸? ‘?•œ ?…¸?“œë¥? ë°©ë¬¸?•˜ì§? ?•Š?•˜?„ ê²½ìš°?— ?Š¤?ƒ?— ?„£ê³? ë°©ë¬¸ì²˜ë¦¬
				if(!vistied[LinkedNode]) {
					stack.push(LinkedNode);
					vistied[LinkedNode] = true;
				}
			}
		}
	}
}
