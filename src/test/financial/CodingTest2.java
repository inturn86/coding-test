package test.financial;

import java.util.ArrayList;
import java.util.List;

public class CodingTest2 {

	public static void main(String[] args) {
		int i = 0;
		int[][] maps = {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19}, {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29}, {39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};
		solution(maps, 19, 6);
	}

	static class Node {
        int x;
        int y;
        int point;
        int r;

        public Node(int x, int y, int point, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
            if(r > 1) {
            	this.point = point;
            }
            else {
            	this.point = point/2;
            }
        }
    }

	int[] xArr = {1,0,-1,0};
	int[] yArr = {0,1,0,-1};

	static int[] node1 = {1, 1};
	static int[] node2 = {1, -1};
	static int[] node3 = {-1, -1};
	static int[] node4 = {-1, 1};

	public static int solution(int[][] maps, int p, int r) {

		int answer = 0 ;

		int area = r / 2;

//		int rigthDown = {4,4};
//		int rigthUp = {4, 4 - 1};
//		int leftDown = {4-1, 4};
//		int leftUp = {4 -1 ,4 -1};

		int x = 0;
		int y = 0;


		int result[][] = new int[maps.length][maps[0].length];
		for(int i = 0, len = maps.length; i < len; i++) {
			for( int j = 0; j < maps[0].length; j++) {
//				maps[i][j]
			}
		}

		return answer;
	}

	public static List<Node> get(int x, int y, int p, int area) {

		Node rigthDown = new Node(x, y, p, area);
		Node rigthUp = new Node(x, y-1, p, area);
		Node leftDown = new Node(x-1, y, p, area);
		Node leftUp = new Node(x-1, y-1, p, area);

		Node[] nodes = new Node[4];
		nodes[0] = rigthDown;
		nodes[1] = rigthUp;
		nodes[2] = leftDown;
		nodes[3] = leftUp;
		List<Node> nodesList = new ArrayList<>();
		nodesList.add(rigthDown);
		nodesList.add(rigthUp);
		nodesList.add(leftDown);
		nodesList.add(leftUp);
		for(int i = 0 , len = area; i < len; i++) {
			Node n1 = new Node(nodes[1].x + node1[0], nodes[1].y + node1[1], p, len - area);
			nodesList.add(new Node(n1.x + node1[0], n1.y + node1[1], p, len - area));
			Node n2 = new Node(nodes[2].x + node1[0], nodes[2].y + node1[1], p, len - area);
			nodesList.add(new Node(n2.x + node2[0], n2.y + node2[1], p, len - area));
			Node n3 = new Node(nodes[3].x + node1[0], nodes[3].y + node1[1], p, len - area);
			nodesList.add(new Node(n3.x + node3[0], n3.y + node3[1], p, len - area));
			Node n4 = new Node(nodes[4].x + node1[0], nodes[4].y + node1[1], p, len - area);
			nodesList.add(new Node(n4.x + node4[0], n4.y + node4[1], p, len - area));
		}
		return nodesList;
	}
}
