package 알고리즘.트리;

import java.util.ArrayList;
import java.util.Scanner;

public class P_1068 {

	static ArrayList<Integer>[] link;
	static boolean[] visited;

	static int result = 0;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		link = new ArrayList[cnt];
		visited = new boolean[cnt];

		for(int i = 0; i < cnt; i++) {
			link[i] = new ArrayList<>();
		}

		int root = 0;
		for(int i = 0; i < cnt; i++) {
			int n = sc.nextInt();
			if(n == -1) {
				root = i;
			}
			else {
				link[i].add(n);
				link[n].add(i);
			}
		}
		int ex = sc.nextInt();

		if(ex == root) {
			System.out.println("0");
		}
		else {

			DFS(root, ex);
			System.out.println(result);
		}
	}

	public static void DFS(int t, int ex) {

		visited[t] = true;
		int cNode = 0;
		for(int i = 0; i < link[t].size(); i++) {
			int g = link[t].get(i);
			if(!visited[g]) {
				if(ex != g) {
					cNode ++;
					DFS(g, ex);
				}
			}
		}

//		for(int i : link[t]) {
//			if(!visited[i]) {
//				if(ex != i) {
//					cNode ++;
//					DFS(i, ex);
//				}
//			}
//		}

		if(cNode == 0){
			result++;
		}
	}
}
