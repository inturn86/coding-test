package test.dp;

import java.util.Arrays;

public class CodingTestDPMySol {

	public static void main(String[] args) {
		solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
	}

	public static int solution(int[][] triangle) {

		int answer = 0 ;
		//결과값을 저장.
		int[][] result = new int[triangle.length][triangle[triangle.length - 1].length];

		//모든 array 접근
		result[0][0] = triangle[0][0];
		for(int i = 1, len = triangle.length; i < len; i++) {
			for(int j = 0, jlen = triangle[i].length; j < jlen; j++) {
				//처음값이면
				if(j == 0) {
					result[i][j] = result[i-1][0] + triangle[i][0];
				}
				//마지막 값이면.
				else if(j == jlen - 1) {
					result[i][j] = result[i-1][j - 1] + triangle[i][j];
				}
				//중간의 값이면.
				else {
					result[i][j] = Math.max(result[i-1][j - 1], result[i-1][j]) + triangle[i][j];
				}
			}
		}
		int[] r = result[triangle.length-1];
		int max = Arrays.stream(r).max().getAsInt();
		return max;
	}
}
