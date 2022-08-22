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

		//방문?�� 기록 arr
		int[][] visited = new int[maps.length][maps[0].length];
		visited[0][0] = 1;

		//bfs처리
		bfs(maps, visited);

		//최종 ?��?�� ?��치의 ?��?��?�� get
		answer = visited[maps.length -1 ][maps[0].length - 1];
		if(answer == 0) {
			answer = -1;
		}

        return answer;
	}

	public static void bfs(int[][] maps, int[][] visited){

		//?��?�� ?���?
		Queue<int[]> que = new LinkedList<int[]>();

		que.add(new int[] {0, 0});

		while(!que.isEmpty()) {
			//?��?�� ?��치�?? get
			int[] now = que.poll();


			int currentX = now[0];
			int currentY = now[1];
			//maps?�� ?��치�?? 0?���? �?�? 못하�? set
			maps[currentX][currentY] = 0;

			for(int i = 0, len = departXArr.length; i < len; i++) {
				//목표 ?��치�?? get
				int departX = departXArr[i];
				int departY = departYArr[i];
				//?��?��?��치�? 목표?��치�?? ?��?��?��
				departX = currentX + departX;
				departY = currentY + departY;

				//갈수 ?��?�� ?��치인�? ?��?��.
				//갈수?��?�� 경우 que?�� ?��?��?���? ?��기에
				if(departX < 0 || departY < 0 || departX > maps.length - 1 || departY > maps[0].length -1) {
					continue;
				}

				//?��?�� ?��치�? 갈수?��?���?
				//방문 기록?�� ?��?��?��치에?�� +1
				//?��?�� ?��치�?? que?�� 기록
				if(maps[departX][departY] == 1) {
					maps[departX][departY] = 0;
					visited[departX][departY] = visited[currentX][currentY] + 1;
					que.add(new int[] {departX, departY});
				}
			}
		}
    }
}
