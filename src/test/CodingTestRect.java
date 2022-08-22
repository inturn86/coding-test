package test;

import java.util.HashMap;
import java.util.Map;

public class CodingTestRect {


	public static void main(String[] args) {

		int[][] rect = {{1,10}, {3,10}, {1,3}} ;
		solution(rect);
	}

	public static int[] solution(int[][] v) {
		int[] answer = new int[2];

		for(int i = 0, len = 2; i < len; i++) {
			 if(v[1][i] == v[2][i]) {
				 answer[i] = v[0][i];
			 }
			 else if(v[0][i] == v[2][i]) {
				 answer[i] = v[1][i];
			 }
			 else {
				 answer[i] = v[2][i];
			 }
		}

		System.out.println(answer);

		return answer;
	}
}
