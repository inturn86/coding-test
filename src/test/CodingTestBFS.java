package test;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTestBFS {


	public static void main(String[] args) {

		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

		solutions(maps);
	}

	static int[] departXArr = {1, 0, -1, 0};
	static int[] departYArr = {0, 1, 0, -1};

	public static int solutions(int[][] maps) {
		int answer = 0;

		//λ°©λ¬Έ? κΈ°λ‘ arr
		int[][] visited = new int[maps.length][maps[0].length];
		visited[0][0] = 1;

		//bfsμ²λ¦¬
		bfs(maps, visited);

		//μ΅μ’ ??¬ ?μΉμ ?°?΄?° get
		answer = visited[maps.length -1 ][maps[0].length - 1];
		if(answer == 0) {
			answer = -1;
		}

        return answer;
	}

	public static void bfs(int[][] maps, int[][] visited){

		//??¬ ?μΉ?
		Queue<int[]> que = new LinkedList<int[]>();

		que.add(new int[] {0, 0});

		while(!que.isEmpty()) {
			//??¬ ?μΉλ?? get
			int[] now = que.poll();


			int currentX = now[0];
			int currentY = now[1];
			//maps? ?μΉλ?? 0?Όλ‘? κ°?μ§? λͺ»νκ²? set
			maps[currentX][currentY] = 0;

			for(int i = 0, len = departXArr.length; i < len; i++) {
				//λͺ©ν ?μΉλ?? get
				int departX = departXArr[i];
				int departY = departYArr[i];
				//??¬?μΉμ? λͺ©ν?μΉλ?? ???¬
				departX = currentX + departX;
				departY = currentY + departY;

				//κ°μ ?? ?μΉμΈμ§? ??Έ.
				//κ°μ?? κ²½μ° que? ? ?¬?μ§? ?κΈ°μ
				if(departX < 0 || departY < 0 || departX > maps.length - 1 || departY > maps[0].length -1) {
					continue;
				}

				//?΄?Ή ?μΉκ? κ°μ??Όλ©?
				//λ°©λ¬Έ κΈ°λ‘? ??¬?μΉμ? +1
				//??¬ ?μΉλ?? que? κΈ°λ‘
				if(maps[departX][departY] == 1) {
					maps[departX][departY] = 0;
					visited[departX][departY] = visited[currentX][currentY] + 1;
					que.add(new int[] {departX, departY});
				}
			}
		}
    }
}
