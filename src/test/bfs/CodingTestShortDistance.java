package test.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTestShortDistance {

	public static void main(String[] args) {
		int i = 0;
		solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
	}

//	ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다.
//	따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
//
//	지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다.
//	다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
//
//	최단거리1_sxuruo.png
//
//	위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다.
//	캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
//	아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
//
//	첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.

	//하나씩 가는 arr를 만듬.
	//bfs로 만듬.
	//맵과 같이 이동 결과를 맵에 기록.
	static int[] departXArr = {1, 0, -1, 0};
	static int[] departYArr = {0, 1, 0, -1};

	static Queue<int[]> que = new LinkedList<int[]>();
	public static int solution(int[][] maps) {
		//결과를 현재위치의 결과를 저장할 map
		int[][] resultMap = new int[maps.length][maps[0].length];
		int answer = -1 ;

		que.add(new int[] {0, 0});
		resultMap[0][0] = 1;
		maps[0][0] = 0;
		bfs(resultMap, maps);

		if(resultMap[maps.length-1][maps[0].length-1] != 0) {
			answer = resultMap[maps.length-1][maps[0].length-1];
		}

		return answer;
	}

	public static void bfs( int[][] resultMap, int[][] maps) {


		while(!que.isEmpty()) {
			int[] cur = que.poll();

			int curX = cur[0];
			int curY = cur[1];
			if(cur[0] == (maps.length -1) && cur[1] == (maps[0].length -1)) {
				return;
			}

			for(int i = 0, len = departXArr.length; i < len; i++) {
				//다음 목적지.
				int depX = curX + departXArr[i];
				int depY = curY + departYArr[i];

				//map을 벗어나면.
				if(depX < 0 || depY < 0 || depX >= maps.length || depY >= maps[0].length) {
					continue;
				}

				if(maps[depX][depY] == 0) {
					continue;
				}

				maps[depX][depY] = 0;
				resultMap[depX][depY] = resultMap[curX][curY] + 1;
				que.add(new int[]{depX, depY});

			}
		}

	}
}
