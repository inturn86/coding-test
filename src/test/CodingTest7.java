package test;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest7 {

	public static void main(String[] args) {

		solutions(5,  new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[] {1,3,5}, 5);
	}


	static int[] departXArr = {1, 0, -1, 0};
	static int[] drpartYArr = {0, 1, 0, -1};
	public static int[] solutions(int n, int[][] roads, int[] sources, int destination) {

//		int[][] visited =

		int[] answer = {};
		for(int i = 0, len = sources.length; i < len; i++) {
			int[] visited = new int[n];

			Queue<Integer> que = new LinkedList<Integer>();
			que.add(sources[i]);

			int next = 0;
			while(!que.isEmpty()) {
				Integer s = que.poll();
				for(int j = 0, jlen = roads.length; j < jlen; j++) {
					if(s.equals(roads[j][0])){
						visited[j] = next++;
						que.add(roads[j][1]);
						continue;
					}

					if(destination ==s ) {
						break;
					}
				}

			}

			System.out.println();
		}

		return answer;
	} // End of solution



}
