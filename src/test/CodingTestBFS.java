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

		//ë°©ë¬¸?•œ ê¸°ë¡ arr
		int[][] visited = new int[maps.length][maps[0].length];
		visited[0][0] = 1;

		//bfsì²˜ë¦¬
		bfs(maps, visited);

		//ìµœì¢… ?„?‹¬ ?œ„ì¹˜ì˜ ?°?´?„° get
		answer = visited[maps.length -1 ][maps[0].length - 1];
		if(answer == 0) {
			answer = -1;
		}

        return answer;
	}

	public static void bfs(int[][] maps, int[][] visited){

		//?˜„?¬ ?œ„ì¹?
		Queue<int[]> que = new LinkedList<int[]>();

		que.add(new int[] {0, 0});

		while(!que.isEmpty()) {
			//?˜„?¬ ?œ„ì¹˜ë?? get
			int[] now = que.poll();


			int currentX = now[0];
			int currentY = now[1];
			//maps?˜ ?œ„ì¹˜ë?? 0?œ¼ë¡? ê°?ì§? ëª»í•˜ê²? set
			maps[currentX][currentY] = 0;

			for(int i = 0, len = departXArr.length; i < len; i++) {
				//ëª©í‘œ ?œ„ì¹˜ë?? get
				int departX = departXArr[i];
				int departY = departYArr[i];
				//?˜„?¬?œ„ì¹˜ì? ëª©í‘œ?œ„ì¹˜ë?? ?”?•˜?—¬
				departX = currentX + departX;
				departY = currentY + departY;

				//ê°ˆìˆ˜ ?ˆ?Š” ?œ„ì¹˜ì¸ì§? ?™•?¸.
				//ê°ˆìˆ˜?—†?„ ê²½ìš° que?— ? ?¬?˜ì§? ?•Šê¸°ì—
				if(departX < 0 || departY < 0 || departX > maps.length - 1 || departY > maps[0].length -1) {
					continue;
				}

				//?•´?‹¹ ?œ„ì¹˜ê? ê°ˆìˆ˜?ˆ?œ¼ë©?
				//ë°©ë¬¸ ê¸°ë¡?„ ?˜„?¬?œ„ì¹˜ì—?„œ +1
				//?˜„?¬ ?œ„ì¹˜ë?? que?— ê¸°ë¡
				if(maps[departX][departY] == 1) {
					maps[departX][departY] = 0;
					visited[departX][departY] = visited[currentX][currentY] + 1;
					que.add(new int[] {departX, departY});
				}
			}
		}
    }
}
