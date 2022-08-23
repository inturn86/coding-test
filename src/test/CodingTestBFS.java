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

	//map의 길찾기
	//map은 1이면 갈수있는것 0이면 못감.
	//user는 1,1에서 출발
	//목적지는 5,5
	public static int solutions(int[][] maps) {
		int answer = 0;

		//방문 기록 arr
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
			//현재의 위치
			int[] now = que.poll();


			int currentX = now[0];
			int currentY = now[1];
			//현재 맵을 지나온 길로 0으로 표기
			maps[currentX][currentY] = 0;

			for(int i = 0, len = departXArr.length; i < len; i++) {
				//목표위치 get
				int departX = departXArr[i];
				int departY = departYArr[i];
				//사방으로 계산하여 다음 목표위치 선정
				departX = currentX + departX;
				departY = currentY + departY;

				//맵을 넘어가는지 0밑으로 넘어가는지 확인하여 맞을 경우 패스
				if(departX < 0 || departY < 0 || departX > maps.length - 1 || departY > maps[0].length -1) {
					continue;
				}

				//갈수있는 곳이라면 현재의 위치를 0으로 만들고 방문기록에 현재의 위치 + 1을하여 누적
				//목표치를 queue에 쌓는다.
				if(maps[departX][departY] == 1) {
					maps[departX][departY] = 0;
					visited[departX][departY] = visited[currentX][currentY] + 1;
					que.add(new int[] {departX, departY});
				}
			}
		}
    }
}
